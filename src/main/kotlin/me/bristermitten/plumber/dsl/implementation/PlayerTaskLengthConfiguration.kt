package me.bristermitten.plumber.dsl.implementation

import com.google.inject.Inject
import com.google.inject.assistedinject.Assisted
import me.bristermitten.plumber.dsl.PlayerActionBuilder
import me.bristermitten.plumber.scheduling.TaskFactory
import me.bristermitten.plumber.scheduling.timings.TimeUnitPickerFactory

class PlayerTaskLengthConfiguration @Inject constructor(
    @Assisted parent: PlayerActionBuilder,
    factory: TimeUnitPickerFactory,
    taskFactory: TaskFactory
) : DefaultTaskLengthConfiguration<PlayerActionBuilder>(parent, factory, taskFactory)
