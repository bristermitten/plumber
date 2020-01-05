package me.bristermitten.plumber.dsl.implementation

import com.google.inject.Inject
import com.google.inject.assistedinject.Assisted
import me.bristermitten.plumber.dsl.BuilderFactory
import me.bristermitten.plumber.dsl.KeyChangeChooser
import me.bristermitten.plumber.dsl.PlayerActionBuilder
import me.bristermitten.plumber.struct.Resettable
import me.bristermitten.plumber.struct.key.DataKey
import me.bristermitten.plumber.struct.player.PPlayer
import java.util.function.Consumer

class PlayerActionBuilderImpl @Inject constructor(
    @Assisted private val player: PPlayer,
    @Assisted private val onTrigger: Runnable,
    private val factory: ImplementationFactory,
    builderFactory: BuilderFactory
) : ActionBuilderImpl<PlayerActionBuilder>(), PlayerActionBuilder {

    private var message: String? = null
    private var onComplete: Consumer<PPlayer>? = null
    private val toReset = hashSetOf<Resettable>()

    override fun <K> keyChange(key: DataKey<K>): KeyChangeChooser<PlayerActionBuilder, K> {
        val chooser: KeyChangeChooser<PlayerActionBuilder, K> = factory.createKeyChangeChooser(key, this, this)
        toReset.add(chooser)
        return chooser
    }

    override fun playerLogout(): PlayerActionBuilder {
        return this
    }

    override fun run() {
        onTrigger.run()
        reset()
    }

    override fun reset() {
        if (message != null) {
            player.message(message!!)
        }
        if (onComplete != null) {
            onComplete!!.accept(player)
        }
        toReset.forEach(Consumer { obj: Resettable -> obj.reset() })
        toReset.clear()
    }

    override fun withMessageOnComplete(msg: String): PlayerActionBuilder {
        message = msg
        return this
    }

    override fun <K : Any> setKeyOnComplete(key: DataKey<K>, value: K): PlayerActionBuilder {
        onComplete =
            Consumer { p: PPlayer ->
                p.rawSetData(key, value)
            }
        return this
    }

    init {
        parent = builderFactory.createPlayerTaskLengthConfiguration(this)
    }
}
