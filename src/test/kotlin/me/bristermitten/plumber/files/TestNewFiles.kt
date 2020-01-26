package me.bristermitten.plumber.files

import me.bristermitten.plumber.PlumberExtension
import me.bristermitten.plumber.newfiles.store.Store
import me.bristermitten.plumber.newfiles.store.StoreStrategy
import me.bristermitten.plumber.newfiles.store.id.IDStrategy
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

/**
 * @author Alexander Wood (BristerMitten)
 */
@ExtendWith(PlumberExtension::class)
class TestNewFiles {

    @Test
    fun `Test Incremental Store Basic Adding and Removing`() {
        val store = PlumberExtension.plugin.getInstance(TestIncrementStore::class.java)

        val data = TestData(3)
        store.add(data)

        assertEquals(data, store[1])
        assertEquals(null, store[3])

        assertEquals(1, store.size)
        assertTrue(data === store[1])


        store.remove(1)

        assertEquals(null, store[1])
        assertEquals(0, store.size)
    }

    @Test
    fun `Test Property Store Basic Adding and Removing`() {
        val store = PlumberExtension.plugin.getInstance(TestPropertyStore::class.java)

        val data = TestData(3)
        store.add(data)

        assertEquals(data, store[3])
        assertEquals(null, store[1])

        assertEquals(1, store.size)
        assertTrue(data === store[3])

        store.remove(3)
        assertEquals(null, store[3])
        assertEquals(0, store.size)
    }

}

interface TestIncrementStore : Store<Long, TestData>

@StoreStrategy(IDStrategy.PROPERTY)
interface TestPropertyStore : Store<Long, TestData>

data class TestData(
    @Id private val id: Long
)
