package me.bristermitten.plumber.files

import me.bristermitten.plumber.annotation.Unstable

@Unstable("Functional but not documented and undergoing heavy refactoring")
interface PlumberFile {
    fun loadData()

    fun saveData()
}
