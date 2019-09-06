package br.com.knowledge.capitulo8_fragment


interface OnLogWrapper{

    fun debug(value:String)
    fun info(value:String)
    fun warn(value:String)
    fun verbose(value:String)
    fun error(value:String)

    companion object {
        const val APPNAME = "FRAGMENT"
    }


}