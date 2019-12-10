package me.bristermitten.rewrite.dsl

interface ContinuousActionBuilder<F>{
    companion object{
        private lateinit var lengthConfiguration: LengthConfiguration<PlayerActionFilter<*>, *,* >
        fun test(){
            lengthConfiguration.until().logout()
        }
    }
}
