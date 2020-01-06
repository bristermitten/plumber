---
title: alltypes - plumber
---

### All Types

|

##### [me.bristermitten.plumber.aspect.AbstractAspect](../me.bristermitten.plumber.aspect/-abstract-aspect/index.html)

Boilerplate-handling abstract implementation of [Aspect](../me.bristermitten.plumber.aspect/-aspect/index.html)
Provides logging, enabled-status handling, and a wrapper for Guice's [Injector](https://google.github.io/guice/api-docs/latest/javadoc/com/google/inject/Injector.html)


|

##### [me.bristermitten.plumber.files.AbstractPlumberFile](../me.bristermitten.plumber.files/-abstract-plumber-file/index.html)


|

##### [me.bristermitten.plumber.dsl.ActionBuilder](../me.bristermitten.plumber.dsl/-action-builder/index.html)

It's quite hard to give a simple description for this interface, other than it provides
a specification for sub-classes like [PlayerActionBuilder](../me.bristermitten.plumber.dsl/-player-action-builder/index.html)
Generally Action Builder is used after [TaskLengthConfiguration](../me.bristermitten.plumber.dsl/-task-length-configuration/index.html) in the interface flow


|

##### [me.bristermitten.plumber.dsl.implementation.ActionBuilderImpl](../me.bristermitten.plumber.dsl.implementation/-action-builder-impl/index.html)

Simple implementation of [ActionBuilder](../me.bristermitten.plumber.dsl/-action-builder/index.html) that holds a parent [TaskLengthConfiguration](../me.bristermitten.plumber.dsl/-task-length-configuration/index.html)


|

##### [me.bristermitten.rewrite.dsl.core.ActionFilter](../me.bristermitten.rewrite.dsl.core/-action-filter/index.html)


|

##### [me.bristermitten.rewrite.dsl.core.impl.ActionFilterImpl](../me.bristermitten.rewrite.dsl.core.impl/-action-filter-impl/index.html)


|

##### [me.bristermitten.plumber.aspect.Aspect](../me.bristermitten.plumber.aspect/-aspect/index.html)

A section of Plumber's functionality, for example, command handling or file management
An Aspect should be considered the parent of this section, and manage dependency injection and initial setup


|

##### [me.bristermitten.plumber.aspect.AspectAnnotation](../me.bristermitten.plumber.aspect/-aspect-annotation/index.html)

Binds an Annotation to an Aspect.


|

##### [me.bristermitten.plumber.aspect.AspectConfig](../me.bristermitten.plumber.aspect/-aspect-config.html)

Configuration interface for an Aspect
Users can extend this to customise functionality for an Aspect
However it is the Aspect's responsibility to get the implementations from [ClassFinder](../me.bristermitten.plumber.reflection/-class-finder/index.html)
and load them into the individual Aspect


|

##### [me.bristermitten.rewrite.dsl.core.BooleanOperator](../me.bristermitten.rewrite.dsl.core/-boolean-operator/index.html)

Used for chaining multiple tasks


|

##### [me.bristermitten.rewrite.dsl.core.impl.BooleanOperatorImpl](../me.bristermitten.rewrite.dsl.core.impl/-boolean-operator-impl/index.html)


|

##### [me.bristermitten.plumber.dsl.BuilderFactory](../me.bristermitten.plumber.dsl/-builder-factory/index.html)

Guice Factory for creating various builder interfaces


|

##### [me.bristermitten.plumber.util.Chat](../me.bristermitten.plumber.util/-chat/index.html)


| (extensions in package me.bristermitten.plumber.util)

##### [java.lang.Class](../me.bristermitten.plumber.util/java.lang.-class/index.html)


|

##### [me.bristermitten.plumber.reflection.ClassFinder](../me.bristermitten.plumber.reflection/-class-finder/index.html)

Helper that wraps [ClassGraph](#) into a cleaner system and provides
extra functionality


|

##### [me.bristermitten.plumber.boot.ClassGraphProvider](../me.bristermitten.plumber.boot/-class-graph-provider/index.html)

Guice [Provider](https://google.github.io/guice/api-docs/latest/javadoc/com/google/inject/Provider.html) for [ClassGraph](#)
This lazily initialises the instance, and uses [PlumberInfo](../me.bristermitten.plumber.boot/-plumber-info/index.html) to whitelist packages


|

##### [me.bristermitten.plumber.command.CommandAspect](../me.bristermitten.plumber.command/-command-aspect/index.html)

Internal aspect that handles the scanning of command classes, and the registration of such classes


|

##### [me.bristermitten.plumber.command.CommandAspectConfig](../me.bristermitten.plumber.command/-command-aspect-config/index.html)


|

##### [me.bristermitten.plumber.reflection.CommonAnnotationTarget](../me.bristermitten.plumber.reflection/-common-annotation-target/index.html)

Annotation targets that are possible in both Java and Kotlin.
Some values may be compressed, such as [AnnotationTarget.CONSTRUCTOR](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.annotation/-annotation-target/-c-o-n-s-t-r-u-c-t-o-r/index.html)
which is classed as a Method in ClassGraph so serves no purpose to be standalone


|

##### [me.bristermitten.plumber.scheduling.timings.compare.CompareRootTimePicker](../me.bristermitten.plumber.scheduling.timings.compare/-compare-root-time-picker/index.html)

Picker interface for picking a distance from a certain time


|

##### [me.bristermitten.plumber.aspect.component.Component](../me.bristermitten.plumber.aspect.component/-component/index.html)

Similar to Spring's @Component, this indicates that the class should be instantiated with Guice
and bound as a singleton.
It will be bound as part of [ComponentAspect](../me.bristermitten.plumber.aspect.component/-component-aspect/index.html)


|

##### [me.bristermitten.plumber.aspect.component.ComponentAspect](../me.bristermitten.plumber.aspect.component/-component-aspect/index.html)

Required Aspect that facilitates the injection of all [Component](../me.bristermitten.plumber.aspect.component/-component/index.html) classes
They are bound as eager singletons


|

##### [me.bristermitten.rewrite.dsl.core.ContinuousActionBuilder](../me.bristermitten.rewrite.dsl.core/-continuous-action-builder/index.html)


|

##### [me.bristermitten.plumber.struct.key.DataKey](../me.bristermitten.plumber.struct.key/-data-key/index.html)

A DataKey provides a key for storing key-value data in entities
It only stores the key, and a default value. It does NOT store the values, these are stored in the entities
Means that Strings don't have to be passed around for simple storage


|

##### [me.bristermitten.plumber.dsl.implementation.DefaultTaskLengthConfiguration](../me.bristermitten.plumber.dsl.implementation/-default-task-length-configuration/index.html)


|

##### [me.bristermitten.plumber.scheduling.timings.compare.DistanceComparer](../me.bristermitten.plumber.scheduling.timings.compare/-distance-comparer/index.html)

DSL Picker for comparing lengths, often of time


|

##### [me.bristermitten.plumber.dsl.DSLAspect](../me.bristermitten.plumber.dsl/-d-s-l-aspect/index.html)

Aspect containing the management of all default DSL implementations


|

##### [me.bristermitten.plumber.struct.event.EventController](../me.bristermitten.plumber.struct.event/-event-controller/index.html)

A wrapper for handling events that provides simple boilerplate handling
Currently, only supports [Cancellable](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Cancellable.html) instances of [PlayerEvent](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/player/PlayerEvent.html)
All instances have an [EventPriority](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/EventPriority.html) of [EventPriority.NORMAL](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/EventPriority.html#NORMAL)
For performance reasons, if no handling functionality is defined, the controller is not registered into Bukkit


|

##### [me.bristermitten.plumber.struct.event.EventControllerFactory](../me.bristermitten.plumber.struct.event/-event-controller-factory/index.html)

Simple factory class for creating instances of [EventController](../me.bristermitten.plumber.struct.event/-event-controller/index.html)
Can't use Guice because of generics, so currently stuck to [EventControllerImpl](../me.bristermitten.plumber.struct.event/-event-controller-impl/index.html)


|

##### [me.bristermitten.plumber.struct.event.EventControllerImpl](../me.bristermitten.plumber.struct.event/-event-controller-impl/index.html)

Default implementation of [EventController](../me.bristermitten.plumber.struct.event/-event-controller/index.html)


|

##### [me.bristermitten.plumber.struct.extension.Extendable](../me.bristermitten.plumber.struct.extension/-extendable/index.html)


|

##### [me.bristermitten.plumber.struct.extension.Extension](../me.bristermitten.plumber.struct.extension/-extension.html)


|

##### [me.bristermitten.plumber.struct.extension.ExtensionMap](../me.bristermitten.plumber.struct.extension/-extension-map/index.html)


|

##### [me.bristermitten.plumber.files.FilesAspect](../me.bristermitten.plumber.files/-files-aspect/index.html)


|

##### [me.bristermitten.plumber.files.FilesAspectStaticModule](../me.bristermitten.plumber.files/-files-aspect-static-module/index.html)


|

##### [me.bristermitten.plumber.files.Id](../me.bristermitten.plumber.files/-id/index.html)

Define the Id parameter for a data class
This is only needed for Key-Value storage, and is used as the key


|

##### [me.bristermitten.plumber.dsl.implementation.ImplementationFactory](../me.bristermitten.plumber.dsl.implementation/-implementation-factory/index.html)

Factory for creating objects that Guice cannot handle


| (extensions in package me.bristermitten.plumber.util)

##### [com.google.inject.Injector](../me.bristermitten.plumber.util/com.google.inject.-injector/index.html)


|

##### [me.bristermitten.plumber.boot.InjectorHolder](../me.bristermitten.plumber.boot/-injector-holder/index.html)

Holder class for Guice's [Injector](https://google.github.io/guice/api-docs/latest/javadoc/com/google/inject/Injector.html)
Because the current [Injector](https://google.github.io/guice/api-docs/latest/javadoc/com/google/inject/Injector.html) is modified frequently in Aspect creation, if an
Aspect has an instance of [Injector](https://google.github.io/guice/api-docs/latest/javadoc/com/google/inject/Injector.html) injected it will not necessarily have every binding required.


|

##### [me.bristermitten.plumber.files.JsonPlumberFile](../me.bristermitten.plumber.files/-json-plumber-file/index.html)


|

##### [me.bristermitten.plumber.dsl.KeyChangeChooser](../me.bristermitten.plumber.dsl/-key-change-chooser/index.html)

Interfaces that wraps watching a [DataKey](../me.bristermitten.plumber.struct.key/-data-key/index.html) for a specific value


|

##### [me.bristermitten.plumber.dsl.implementation.KeyChangeChooserImpl](../me.bristermitten.plumber.dsl.implementation/-key-change-chooser-impl/index.html)


|

##### [me.bristermitten.plumber.struct.key.KeyHolder](../me.bristermitten.plumber.struct.key/-key-holder/index.html)

A KeyHolder defines an entity that holds key-value storage in the form of [DataKey](../me.bristermitten.plumber.struct.key/-data-key/index.html)


|

##### [me.bristermitten.plumber.struct.key.KeyMap](../me.bristermitten.plumber.struct.key/-key-map/index.html)

Simple delegate of [HashMap](https://docs.oracle.com/javase/6/docs/api/java/util/HashMap.html) with generics overridden


|

##### [me.bristermitten.plumber.files.KeyValueStore](../me.bristermitten.plumber.files/-key-value-store.html)


|

##### [me.bristermitten.plumber.files.KeyValueStoreProxyHandler](../me.bristermitten.plumber.files/-key-value-store-proxy-handler/index.html)


|

##### [me.bristermitten.rewrite.dsl.core.LengthConfiguration](../me.bristermitten.rewrite.dsl.core/-length-configuration/index.html)


|

##### [me.bristermitten.plumber.aspect.LoadIfPresent](../me.bristermitten.plumber.aspect/-load-if-present/index.html)

Only applicable to subclasses of [Aspect](../me.bristermitten.plumber.aspect/-aspect/index.html).


|

##### [me.bristermitten.rewrite.dsl.core.impl.MainPlumberEntity](../me.bristermitten.rewrite.dsl.core.impl/-main-plumber-entity/index.html)


|

##### [me.bristermitten.plumber.files.MappedTo](../me.bristermitten.plumber.files/-mapped-to/index.html)

Map an object to a persistent store i.e. a File or Database


|

##### [me.bristermitten.plumber.files.MappingType](../me.bristermitten.plumber.files/-mapping-type/index.html)

Methods of mapping data to a backend storage


| (extensions in package me.bristermitten.plumber.util)

##### [com.google.inject.Module](../me.bristermitten.plumber.util/com.google.inject.-module/index.html)


|

##### [me.bristermitten.plumber.dsl.PlayerActionBuilder](../me.bristermitten.plumber.dsl/-player-action-builder/index.html)

Subclass of [ActionBuilder](../me.bristermitten.plumber.dsl/-action-builder/index.html) that defines various actions that a Player could do.
In the default implementation, a callback is defined that is ran when any of the actions are complete


|

##### [me.bristermitten.plumber.dsl.implementation.PlayerActionBuilderImpl](../me.bristermitten.plumber.dsl.implementation/-player-action-builder-impl/index.html)


|

##### [me.bristermitten.rewrite.dsl.player.PlayerActionFilter](../me.bristermitten.rewrite.dsl.player/-player-action-filter/index.html)


|

##### [me.bristermitten.plumber.struct.player.PlayerExtension](../me.bristermitten.plumber.struct.player/-player-extension.html)


|

##### [me.bristermitten.plumber.event.player.PlayerJoinEvent](../me.bristermitten.plumber.event.player/-player-join-event/index.html)

Event that gives Plumber functionality to the default Bukkit event


|

##### [me.bristermitten.rewrite.dsl.player.PlayerReactorPicker](../me.bristermitten.rewrite.dsl.player/-player-reactor-picker/index.html)


|

##### [me.bristermitten.plumber.dsl.implementation.PlayerTaskLengthConfiguration](../me.bristermitten.plumber.dsl.implementation/-player-task-length-configuration/index.html)


|

##### [me.bristermitten.plumber.command.PlumberCommand](../me.bristermitten.plumber.command/-plumber-command/index.html)

Extension of [BaseCommand](https://aikar.github.io/commands/acf-core/co/aikar/commands/BaseCommand.html) that gives extra boilerplate handling
It's recommended to use this class


|

##### [me.bristermitten.rewrite.dsl.core.PlumberEntity](../me.bristermitten.rewrite.dsl.core/-plumber-entity/index.html)


|

##### [me.bristermitten.plumber.files.PlumberFile](../me.bristermitten.plumber.files/-plumber-file/index.html)


|

##### [me.bristermitten.plumber.files.PlumberFileFactory](../me.bristermitten.plumber.files/-plumber-file-factory/index.html)


|

##### [me.bristermitten.plumber.boot.PlumberInfo](../me.bristermitten.plumber.boot/-plumber-info/index.html)

Holds info about the running Plumber instance.
Currently, this only includes the package name of the [PlumberPlugin](../me.bristermitten.plumber/-plumber-plugin/index.html) implementation
for [ClassFinder](../me.bristermitten.plumber.reflection/-class-finder/index.html), but may have more in the future.


|

##### [me.bristermitten.plumber.boot.PlumberLoader](../me.bristermitten.plumber.boot/-plumber-loader/index.html)

Class responsible for loading the entirety of Plumber.


|

##### [me.bristermitten.plumber.PlumberPlugin](../me.bristermitten.plumber/-plumber-plugin/index.html)

Main class of Plumber. A Plugin that uses Plumber should extend this instead of
[JavaPlugin](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/plugin/java/JavaPlugin.html), as it is responsible for the loading of the framework,
and may handle more in the future.


|

##### [me.bristermitten.plumber.PlumberServer](../me.bristermitten.plumber/-plumber-server/index.html)


|

##### [me.bristermitten.plumber.struct.player.PPlayer](../me.bristermitten.plumber.struct.player/-p-player/index.html)

Plumber wrapper for the [Player](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html) class
Allows lots of boilerplate on Players do be done easily


|

##### [me.bristermitten.rewrite.dsl.player.PPlayer](../me.bristermitten.rewrite.dsl.player/-p-player/index.html)


|

##### [me.bristermitten.plumber.struct.player.PPlayerManager](../me.bristermitten.plumber.struct.player/-p-player-manager/index.html)

Singleton for managing implementations of [PPlayer](../me.bristermitten.plumber.struct.player/-p-player/index.html) bound to their underlying [Player](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)


|

##### [me.bristermitten.rewrite.dsl.core.ReactorPicker](../me.bristermitten.rewrite.dsl.core/-reactor-picker/index.html)


|

##### [me.bristermitten.plumber.util.Reflection](../me.bristermitten.plumber.util/-reflection/index.html)


|

##### [me.bristermitten.plumber.aspect.RequiredAspect](../me.bristermitten.plumber.aspect/-required-aspect/index.html)

Only applicable to subclasses of [Aspect](../me.bristermitten.plumber.aspect/-aspect/index.html).


|

##### [me.bristermitten.plumber.struct.Resettable](../me.bristermitten.plumber.struct/-resettable/index.html)

Indicates that something can be reset


|

##### [me.bristermitten.plumber.scheduling.ScheduledTask](../me.bristermitten.plumber.scheduling/-scheduled-task/index.html)

Aspect annotation linking to [SchedulerAspect](../me.bristermitten.plumber.scheduling/-scheduler-aspect/index.html)
Currently, does nothing as the scheduler aspect is always loaded


|

##### [me.bristermitten.plumber.scheduling.SchedulerAspect](../me.bristermitten.plumber.scheduling/-scheduler-aspect/index.html)

Aspect that handles the scheduler related functionality of Plumber
Currently, all it does is installs the required Assisted Injection factories


| (extensions in package me.bristermitten.plumber.util)

##### [kotlin.sequences.Sequence](../me.bristermitten.plumber.util/kotlin.sequences.-sequence/index.html)


|

##### [me.bristermitten.plumber.aspect.StaticModule](../me.bristermitten.plumber.aspect/-static-module/index.html)

Only applicable to subclasses of [Aspect](../me.bristermitten.plumber.aspect/-aspect/index.html).


|

##### [me.bristermitten.plumber.files.StorageMapping](../me.bristermitten.plumber.files/-storage-mapping/index.html)

The type of mapping to use from memory to storage


|

##### [me.bristermitten.plumber.files.StorageType](../me.bristermitten.plumber.files/-storage-type/index.html)

Types of File or storage to use for saving and loading data


|

##### [me.bristermitten.plumber.files.Store](../me.bristermitten.plumber.files/-store/index.html)


|

##### [me.bristermitten.plumber.files.StoreProxyHandler](../me.bristermitten.plumber.files/-store-proxy-handler/index.html)


|

##### [me.bristermitten.plumber.scheduling.Task](../me.bristermitten.plumber.scheduling/-task/index.html)

A Task wraps Bukkit's Scheduler system into a single object.
Currently, all tasks are ran asynchronously, but this will be improved in the future.


|

##### [me.bristermitten.plumber.scheduling.timings.TaskBuilder](../me.bristermitten.plumber.scheduling.timings/-task-builder/index.html)

Builder for configuring times in the future for scheduling
This can be safely injected


|

##### [me.bristermitten.plumber.scheduling.TaskFactory](../me.bristermitten.plumber.scheduling/-task-factory/index.html)

Guice Assisted Injection factory for creating instances of [Task](../me.bristermitten.plumber.scheduling/-task/index.html)


|

##### [me.bristermitten.plumber.dsl.TaskLengthConfiguration](../me.bristermitten.plumber.dsl/-task-length-configuration/index.html)

Interface for deciding how long a task should take


|

##### [me.bristermitten.plumber.scheduling.timings.Time](../me.bristermitten.plumber.scheduling.timings/-time/index.html)

Represents a length of time, with a unit


|

##### [me.bristermitten.plumber.scheduling.timings.TimeUnit](../me.bristermitten.plumber.scheduling.timings/-time-unit/index.html)

Simple Time Unit enum that includes Minecraft ticks,
where ideally 20 ticks are in a second.
Anything below a millisecond is not included, as realistically they are highly unlikely
to be needed in a Minecraft server


|

##### [me.bristermitten.plumber.scheduling.timings.TimeUnitPicker](../me.bristermitten.plumber.scheduling.timings/-time-unit-picker/index.html)

A TimeUnitPicker allows developers to choose a time unit for an action.
General best practice is to have the method that returns a TimeUnitPicker
take a long for the amount of time, for example
`
PPlayer#blockEvent(PlayerMoveEvent.class).undoAfter(30).seconds()
` *


|

##### [me.bristermitten.plumber.scheduling.timings.TimeUnitPickerFactory](../me.bristermitten.plumber.scheduling.timings/-time-unit-picker-factory/index.html)

Simple factory class for creating instances of [TimeUnitPicker](../me.bristermitten.plumber.scheduling.timings/-time-unit-picker/index.html)
Due to the use of generics, we can't use Assisted Inject for this, so have to do it manually


|

##### [me.bristermitten.plumber.annotation.Unstable](../me.bristermitten.plumber.annotation/-unstable/index.html)

Indicates that a part of the API is unstable.
This can range from bugs, to completely nothing being implemented / working yet.
It's advised not to use anything annotated with [Unstable](../me.bristermitten.plumber.annotation/-unstable/index.html),
but feel free to submit a PR!


|

##### [me.bristermitten.plumber.files.ValueStore](../me.bristermitten.plumber.files/-value-store.html)


|

##### [me.bristermitten.plumber.files.ValueStoreProxyHandler](../me.bristermitten.plumber.files/-value-store-proxy-handler/index.html)


|

##### [me.bristermitten.plumber.files.YamlPlumberFile](../me.bristermitten.plumber.files/-yaml-plumber-file/index.html)


