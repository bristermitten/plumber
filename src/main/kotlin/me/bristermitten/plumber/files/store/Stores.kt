package me.bristermitten.plumber.files.store

import me.bristermitten.plumber.annotation.Unstable
import me.bristermitten.plumber.files.Id
import me.bristermitten.plumber.util.filterNotNull
import me.bristermitten.reflector.Reflector
import java.lang.reflect.Method
import kotlin.reflect.jvm.javaMethod

@Unstable("Functional but not documented and undergoing heavy refactoring")
//@StoreInfo(HashMap::class, DictionaryHandler::class)
interface DictionaryStore<K, T> : Store<T>, MutableMap<K, T>

class DictionaryHandler<K, V>(private val reflector: Reflector) : StoreHandler<MutableMap<K, V>, V> {
    override fun initMethodTable(table: MutableMap<Method, (Array<Any>) -> Any?>) {
        table[Store<V>::save.javaMethod!!] = { args ->
        }
    }

    override fun loadData(loadFrom: MutableMap<K, V>, loadTo: MutableMap<K, V>) {
        loadTo.clear()
        for (entry in loadFrom) {
            if (entry.value != null)
                loadTo[entry.key] = entry.value
        }
    }

    override fun save(store: MutableMap<K, V>, data: V) {
        val idProperty = reflector.getStructure(data?.javaClass).searchProperties()
            .byAnnotation(Id::class.java).search().findFirst().orElseThrow {
                IllegalArgumentException("Class has no @Id property")
            }
        store[idProperty.getValue(data) as K] = data
    }


}


@Unstable("Functional but not documented and undergoing heavy refactoring")
interface ObjectStore<T> : Store<T>, MutableList<T>

class ObjectStoreHandler<T> : StoreHandler<MutableList<T>, T> {
    override fun initMethodTable(table: MutableMap<Method, (Array<Any>) -> Any?>) {
    }

    override fun loadData(loadFrom: MutableList<T>, loadTo: MutableList<T>) {
        loadTo.clear()
        loadTo.addAll(loadFrom.filterNotNull())
    }

    override fun save(store: MutableList<T>, data: T) {
        store.add(data)
    }

}
