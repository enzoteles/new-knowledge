package br.com.knowledge.capitulo8_fragment

import android.util.Log


object LogWrapperUtil: OnLogWrapper{
    override fun debug(value: String) {
        Log.d(OnLogWrapper.APPNAME, value)
    }

    override fun info(value: String) {
        Log.i(OnLogWrapper.APPNAME, value)
    }

    override fun warn(value: String) {
        Log.w(OnLogWrapper.APPNAME, value)
    }

    override fun verbose(value: String) {
        Log.v(OnLogWrapper.APPNAME, value)
    }

    override fun error(value: String) {
        Log.e(OnLogWrapper.APPNAME, value)
    }
}