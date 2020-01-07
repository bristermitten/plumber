package me.bristermitten.plumber

import org.bukkit.plugin.PluginDescriptionFile
import org.bukkit.plugin.java.JavaPluginLoader
import java.io.File

//That's it!
class TestPlugin : PlumberPlugin {
    constructor(loader: JavaPluginLoader?, description: PluginDescriptionFile?, dataFolder: File?, file: File?) : super(
        loader,
        description,
        dataFolder,
        file
    )

    constructor()

}
