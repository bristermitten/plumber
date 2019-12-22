package me.bristermitten.plumber.files

import me.bristermitten.plumber.PlumberTest
import me.bristermitten.plumber.files.*
import org.junit.Assert.assertEquals
import org.junit.Test

class FilesAspectTest : PlumberTest()
{

    @Test
    fun testCorrectSerialization() {
        val type = TestStore::class.java
        val store = plugin.getInstance(type)

        val element = Data(id = 3, name = "YO")
        store.add(element)
        store.flush()
        store.clear()
        store.reload()

        assertEquals(1, store.size)
        assertEquals(element, store[0])
        assertEquals(listOf(element), store)
    }

    @MappedTo("test.yml")
    interface TestStore : ValueStore<Data>
}
