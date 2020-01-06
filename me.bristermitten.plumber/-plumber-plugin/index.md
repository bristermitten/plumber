---
title: PlumberPlugin - plumber
---

[plumber](../../index.html) / [me.bristermitten.plumber](../index.html) / [PlumberPlugin](./index.html)

# PlumberPlugin

`open class PlumberPlugin : JavaPlugin`

Main class of Plumber. A Plugin that uses Plumber should extend this instead of
[JavaPlugin](#), as it is responsible for the loading of the framework,
and may handle more in the future.

This class will be a Singleton throughout the framework, and at the moment doesn't do much
else than the initial setup.
On that note, in any Plumber plugin, [PlumberPlugin.loadPlumber](load-plumber.html)
should be called in your [JavaPlugin.onEnable](#) if you override the default [PlumberPlugin.onEnable](on-enable.html)

### Constructors

| [&lt;init&gt;](-init-.html) | Basic no-args constructor This constructor it provided so that it can be overridden for mocking or similar purposes`PlumberPlugin()`<br>Basic JavaPlugin constructor This constructor it provided so that it can be overridden for mocking or similar purposes`PlumberPlugin(loader: JavaPluginLoader?, description: PluginDescriptionFile?, dataFolder: `[`File`](https://docs.oracle.com/javase/6/docs/api/java/io/File.html)`?, file: `[`File`](https://docs.oracle.com/javase/6/docs/api/java/io/File.html)`?)` |

### Properties

| [holder](holder.html) | `lateinit var holder: `[`InjectorHolder`](../../me.bristermitten.plumber.boot/-injector-holder/index.html) |
| [logger](logger.html) | `val logger: Logger` |

### Functions

| [getInstance](get-instance.html) | Helper method to get an instance of a class with Guice`fun <T> getInstance(clazz: `[`Class`](https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<T>): T` |
| [loadPlumber](load-plumber.html) | Load the framework. This entails scanning classes in the classpath, creating instances and injectors through Guice, and loading all necessary aspects. This should be called before anything else in [onEnable](on-enable.html)`fun loadPlumber(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onEnable](on-enable.html) | Default [JavaPlugin.onEnable](#) implementation. This loads Plumber, and if overridden [loadPlumber](load-plumber.html) should be called`open fun onEnable(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

