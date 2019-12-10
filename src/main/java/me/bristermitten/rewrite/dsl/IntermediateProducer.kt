package me.bristermitten.rewrite.dsl

interface IntermediateProducer<out T: IntermediateProducer<IntermediateProducer<T, F>, F>, F>
