package me.bristermitten.plumber.struct.builder.impl;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import me.bristermitten.plumber.struct.DataKey;
import me.bristermitten.plumber.struct.builder.BuilderFactory;
import me.bristermitten.plumber.struct.builder.ImplementationFactory;
import me.bristermitten.plumber.struct.builder.KeyChangeChooser;
import me.bristermitten.plumber.struct.builder.PlayerActionBuilder;
import me.bristermitten.plumber.struct.player.PPlayer;
import org.jetbrains.annotations.NotNull;

public class PlayerActionBuilderImpl extends ActionBuilderImpl<PlayerActionBuilder> implements PlayerActionBuilder {

    private final PPlayer player;
    @org.jetbrains.annotations.NotNull
    private final BuilderFactory factory;
    private final ImplementationFactory f2;

    @Inject
    public PlayerActionBuilderImpl(@Assisted PPlayer player, BuilderFactory factory, ImplementationFactory f2) {
        this.factory = factory;
        this.f2 = f2;
        this.parent = factory.createPlayerConfiguration(this);
        this.player = player;
    }

    @NotNull
    @Override
    public <K> KeyChangeChooser<PlayerActionBuilder, K> keyChange(@NotNull DataKey<K> key) {
        return f2.createKeyChangeChooser(key, this);
    }

    @Override
    public PlayerActionBuilder playerLogout() {
        return this;
    }
}
