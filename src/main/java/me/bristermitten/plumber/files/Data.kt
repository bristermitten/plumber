package me.bristermitten.plumber.files

@StorageMapping(MappingType.TWO_WAY)
data class Data (@Id
                 var id: Long = 0,
                 var name: String = ""
)
