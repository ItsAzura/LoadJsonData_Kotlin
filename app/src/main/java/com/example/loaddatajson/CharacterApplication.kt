package com.example.loaddatajson

import android.app.Application
import com.example.loaddatajson.data.AppContainer
import com.example.loaddatajson.data.DefaultAppContainer

class CharacterApplication: Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}