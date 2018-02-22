package com.kwetter.services

import com.kwetter.models.User
import javax.ejb.Stateless
import javax.inject.Inject
import com.kwetter.dao.IDao
import com.kwetter.dao.UserDao
import com.kwetter.models.createNamedQueryUserFindByQuery


@Stateless
open class UserService: AbstractService<User>() {
    override val dao: IDao<User>
        get() = userDao

    @Inject
    lateinit var userDao: UserDao

    fun findByUsername(text: String): List<User>{
        if (text.isEmpty())
            throw IllegalArgumentException("Search query is empty")

        return userDao.getEntityManager().createNamedQueryUserFindByQuery().setParameter("username", "%$text%").resultList
    }
}