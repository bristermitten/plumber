package me.bristermitten.plumber.struct.builder;

import me.bristermitten.plumber.scheduling.timings.TimeUnitPicker;
import me.bristermitten.plumber.struct.DataKey;

public interface PlayerTaskBuilder extends TaskBuilder {

    PlayerTaskBuilder playerLogout();

    PlayerTaskBuilder or();

    TimeUnitPicker<PlayerTaskBuilder> after(long length);

    <K> KeyChangeChooser<PlayerTaskBuilder, K> onKeyChange(DataKey<K> key);
}
