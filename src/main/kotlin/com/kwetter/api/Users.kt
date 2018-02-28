package com.kwetter.api

import com.kwetter.services.UserService
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import com.kwetter.models.User
import javax.ejb.Stateless
import javax.ws.rs.PathParam

@Stateless
@Path("/user")
open class Users @Inject constructor(private var userService: UserService){

    @GET
    @Path("/{id}")
    fun userById(@PathParam("id") id: Int): User {
        return userService.getById(id)
    }

    @GET
    @Path("test")
    fun test(): String {
        return "Werkt"
    }
}