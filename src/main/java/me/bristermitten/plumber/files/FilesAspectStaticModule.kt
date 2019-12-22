package me.bristermitten.plumber.files

import com.google.inject.AbstractModule
import com.google.inject.assistedinject.FactoryModuleBuilder
import org.yaml.snakeyaml.DumperOptions
import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.introspector.Property
import org.yaml.snakeyaml.nodes.MappingNode
import org.yaml.snakeyaml.nodes.Tag
import org.yaml.snakeyaml.representer.Representer

class FilesAspectStaticModule : AbstractModule() {
    override fun configure() {
        install(FactoryModuleBuilder().build(PlumberFileFactory::class.java))

        val representer = object : Representer() {
            override fun representJavaBean(properties: MutableSet<Property>, javaBean: Any): MappingNode {
                if (!classTags.containsKey(javaBean.javaClass)) {
                    addClassTag(javaBean.javaClass, Tag.MAP)
                }
                return super.representJavaBean(properties, javaBean)
            }
        }

        val yaml = Yaml(representer, DumperOptions().apply {
            isPrettyFlow = true
            defaultFlowStyle = DumperOptions.FlowStyle.BLOCK
        })

        bind(Yaml::class.java).toInstance(yaml)
    }
}
