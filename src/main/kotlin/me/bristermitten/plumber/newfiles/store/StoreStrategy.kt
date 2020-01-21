package me.bristermitten.plumber.newfiles.store

import me.bristermitten.plumber.aspect.AspectAnnotation
import me.bristermitten.plumber.newfiles.FilesAspect
import me.bristermitten.plumber.newfiles.store.id.IDStrategy
import java.lang.annotation.Inherited

/**
 * @author Alexander Wood (BristerMitten)
 */
@Inherited
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@AspectAnnotation(FilesAspect::class)
annotation class StoreStrategy(val strategy: IDStrategy)

