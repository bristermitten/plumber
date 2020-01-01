package me.bristermitten.plumber.files

@Configuration("test.yml")
class TestPlumberFile {

    @ConfigVar("test")
    var test = "Test"

    lateinit var file : ManagedFile
}
