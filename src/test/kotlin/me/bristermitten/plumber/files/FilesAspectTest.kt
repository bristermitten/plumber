package me.bristermitten.plumber.files

import me.bristermitten.plumber.PlumberExtension
import me.bristermitten.plumber.files.store.DictionaryStore
import me.bristermitten.plumber.files.store.ObjectStore
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(PlumberExtension::class)
class FilesAspectTest {

    @Test
    fun `Test Correct Saving and Reloading of Value Store`() {
        val type = TestStore::class.java
        val plugin = PlumberExtension.plugin

        val store = plugin.getInstance(type)

        val element = TestDataClass(id = 3, name = "Test")
        store.save(element)
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

        val element = TestDataClass(id = 3, name = "Test")

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
    interface TestStore : ObjectStore<TestDataClass>

    @MappedTo("test.yml")
    interface TestKeyStore : DictionaryStore<Long, TestDataClass>

//    @MappedTo("config-test.yml")
//    class TestConfig  {
////        @ConfigKey("name")
//        var name: String = ""
//    }
}
