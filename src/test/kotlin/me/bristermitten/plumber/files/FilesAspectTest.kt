package me.bristermitten.plumber.files

import me.bristermitten.plumber.PlumberExtension
import me.bristermitten.plumber.TestPlugin
import org.bukkit.plugin.java.JavaPlugin
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(PlumberExtension::class)
class FilesAspectTest{

    @Test
    fun `Test Correct Saving and Reloading of Value Store`() {
        val type = TestStore::class.java
        val plugin = PlumberExtension.plugin

        val store = plugin.getInstance(type)

        val element = Data(id = 3, name = "Test")
        store.add(element)
        store.flush()

        store.clear()

        assertEquals(0, store.size)
        store.reload()

        assertEquals(1, store.size)
        assertEquals(element, store[0])
        assertEquals(listOf(element), store)
        assertFalse(element === store[0])
    }

    @Test
    fun `Test Correct Saving and Reloading of KeyValue Store`() {
        val type = TestKeyStore::class.java
        val plugin = PlumberExtension.plugin

        val store = plugin.getInstance(type)

        val element = Data(id = 3, name = "Test")

        store.save(element)
        store.flush()

        store.clear()

        assertEquals(0, store.size)

        store.reload()

        assertEquals(1, store.size)
        assertEquals(element, store[element.id])
        assertEquals(mapOf(element.id to element), store)
        assertFalse(element === store[element.id])
    }

    @MappedTo("test.yml")
    interface TestStore : ValueStore<Data>

    @MappedTo("test.yml")
    interface TestKeyStore : KeyValueStore<Long, Data>

//    @MappedTo("config-test.yml")
//    class TestConfig  {
////        @ConfigKey("name")
//        var name: String = ""
//    }
}
