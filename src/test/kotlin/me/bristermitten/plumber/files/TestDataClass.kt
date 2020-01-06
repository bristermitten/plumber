package me.bristermitten.plumber.files

@StorageMapping(MappingType.TWO_WAY)
data class TestDataClass(
    @Id var id: Long = 0,
    var name: String = ""
)
