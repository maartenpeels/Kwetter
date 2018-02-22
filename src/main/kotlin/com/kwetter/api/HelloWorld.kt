package com.kwetter.api

import com.kwetter.models.User

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces

@Path("/helloworld")
class HelloWorld {
    @GET
    @Path("test")
    @Produces("application/json")
    fun test(): User {
        return User(1)
    }
}
