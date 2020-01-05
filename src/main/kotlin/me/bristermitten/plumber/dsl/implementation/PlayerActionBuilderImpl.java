package me.bristermitten.plumber.dsl.implementation;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import me.bristermitten.plumber.dsl.BuilderFactory;
import me.bristermitten.plumber.dsl.KeyChangeChooser;
import me.bristermitten.plumber.dsl.PlayerActionBuilder;
import me.bristermitten.plumber.struct.Resettable;
import me.bristermitten.plumber.struct.key.DataKey;
import me.bristermitten.plumber.struct.player.PPlayer;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class PlayerActionBuilderImpl extends ActionBuilderImpl<PlayerActionBuilder> implements PlayerActionBuilder {
    private final PPlayer player;
    private final ImplementationFactory factory;
    private final Runnable onTrigger;
    private String message;
    private Consumer<PPlayer> onComplete;

    private Set<Resettable> toReset = new HashSet<>();

    @Inject
    public PlayerActionBuilderImpl(@Assisted PPlayer player,
                                   @Assisted Runnable onTrigger,
                                   BuilderFactory factory,
                                   ImplementationFactory factory2) {
        this.factory = factory2;
        this.onTrigger = onTrigger;
        this.parent = factory.createPlayerTaskLengthConfiguration(this);
        this.player = player;
    }

    @NotNull
    @Override
    public <K> KeyChangeChooser<PlayerActionBuilder, K> keyChange(@NotNull DataKey<K> key) {
        KeyChangeChooser<PlayerActionBuilder, K> chooser = factory.createKeyChangeChooser(key, this, this);
        toReset.add(chooser);
        return chooser;
    }

    @NotNull
    @Override
    public PlayerActionBuilder playerLogout() {
        return this;
    }

    @Override
    public void run() {
        onTrigger.run();
        reset();
    }

    public void reset() {
        if (message != null) {
            player.message(message);
        }
        if (onComplete != null) {
            onComplete.accept(player);
        }
        toReset.forEach(Resettable::reset);
        toReset.clear();
    }

    @NotNull
    @Override
    public PlayerActionBuilder withMessageOnComplete(@NotNull String msg) {
        this.message = msg;
        return this;
    }

    @NotNull
    @Override
    public <K> PlayerActionBuilder setKeyOnComplete(@NotNull DataKey<K> key, K value) {
        onComplete = p -> p.rawSetData(key, value);
        return this;
    }
}
