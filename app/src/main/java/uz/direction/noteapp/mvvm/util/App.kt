package uz.direction.noteapp.mvvm.util

import android.app.Application

class App : Application() {

    companion object {
        private lateinit var INSTANCE: App

        fun getContext(): App {
            return INSTANCE
        }

    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

}