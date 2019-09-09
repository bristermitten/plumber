package me.bristermitten.plumber.struct.builder.impl;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import me.bristermitten.plumber.struct.DataKey;
import me.bristermitten.plumber.struct.builder.BuilderFactory;
import me.bristermitten.plumber.struct.builder.KeyChangeChooser;
import me.bristermitten.plumber.struct.builder.PlayerActionBuilder;
import me.bristermitten.plumber.struct.player.PPlayer;

public class PlayerActionBuilderImpl extends ActionBuilderImpl<PlayerActionBuilder> implements PlayerActionBuilder {

    private final PPlayer player;

    @Inject
    public PlayerActionBuilderImpl(@Assisted PPlayer player, BuilderFactory factory) {
        this.parent = factory.createPlayerConfiguration(this);
        this.player = player;
    }

    @Override
    public <K> KeyChangeChooser<PlayerActionBuilder, K> keyChange(DataKey<K> key) {
        return null;
    }

    @Override
    public PlayerActionBuilder playerLogout() {
        return this;
    }
}
