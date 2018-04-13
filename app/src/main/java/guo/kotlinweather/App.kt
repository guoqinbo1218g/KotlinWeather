package guo.kotlinweather

import android.app.Application

/**
 * 作者：author
 * 时间：2018/4/13:21:21
 * 说明：
 */
class App : Application() {
    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}