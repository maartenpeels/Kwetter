package com.kwetter.dao

import javax.ejb.Stateless
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Stateless
abstract class AbstractDao<T: Model> {
    @PersistenceContext
    private lateinit var em: EntityManager

    protected fun getEntityManager(): EntityManager? {
        return this.em
    }

    fun create(model: T): T {
        em.persist(model)
        return model
    }
}