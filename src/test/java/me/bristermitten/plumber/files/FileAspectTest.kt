package me.bristermitten.plumber.files

import me.bristermitten.plumber.PlumberTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import java.nio.file.Files

class FileAspectTest : PlumberTest() {

    lateinit var file: TestPlumberFile

    @Before
    override fun setUp() {
        super.setUp()
        file = plugin.getInstance(TestPlumberFile::class.java)
    }

    @Test
    fun `Test loading of Managed File`() {
        assertNotNull(file)
        assertNotNull(file.test)
    }

    @Test
    fun `Test saving of Managed File`() {
        file.file.save()
        assertEquals("test: Test\n", file.file.saveToString())
    }

    @Test
    fun `Test saving and reloading of Managed File`() {
        file.file.save()
        Files.write(file.file.path.toPath(), "test: Test2".toByteArray())
        file.file.reload()
        assertEquals("Test2", file.test)
    }
}
