package com.kwetter.api

import javax.ws.rs.ApplicationPath
import javax.ws.rs.core.Application
import java.util.HashSet

@ApplicationPath("/api/*")
class App : Application() {
    override fun getClasses(): Set<Class<*>> = setOf(
            HelloWorld::class.java
    )
}
