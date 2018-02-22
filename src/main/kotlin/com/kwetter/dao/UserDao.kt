package com.kwetter.dao

import com.kwetter.models.User
import javax.ejb.Stateless


@Stateless
open class UserDao : AbstractDao<User>() {
    override fun getEntityClass(): Class<User> {
        return User::class.java
    }
}