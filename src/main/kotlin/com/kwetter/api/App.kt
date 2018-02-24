package com.kwetter.api

import javax.ws.rs.ApplicationPath
import javax.ws.rs.core.Application

@ApplicationPath("/api/*")
class App : Application() {

    override fun getClasses(): Set<Class<*>> = setOf(
            Users::class.java
    )
}