package br.com.knowledge.biulder

import java.io.Serializable
/**
 * como usar
 *  lloadTestBuilder(TestBuilder.Builder().apply {
    setAge(1)
    }.build())
 * */
class TestBuilder private constructor(builder: Builder): Serializable{
    val name: String?
    val age: Int?

    init {
        this.name = builder.name
        this.age = builder.age
    }

    class Builder {
        var name: String? = null
            private set

        var age: Int?= null
            private set

        fun setName(date: String) = apply { this.name = date }
        fun setAge(date:Int) = apply { this.age = date }


        fun build() = TestBuilder(this)

    }
}



