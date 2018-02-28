package com.kwetter.dao

import java.util.Date
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

abstract class AbstractDao<T : IModel> : IDao<T> {
    @PersistenceContext
    private lateinit var em: EntityManager

    protected abstract fun getEntityClass(): Class<T>

    fun getEntityManager(): EntityManager {
        return em
    }

    override fun create(model: T): T {
        model.createdAt = Date()
        model.updatedAt = Date()
        em.persist(model)
        return model
    }

    override fun update(model: T): T {
        model.updatedAt = Date()
        em.merge(model)
        return model
    }

    override fun remove(model: T) {
        em.remove(em.merge(model))
    }

    override fun getById(id: Int): T {
        return em.find(getEntityClass(), id)
    }

    override fun getAll(): List<T> {
        val c = em.criteriaBuilder.createQuery(getEntityClass())
        c.from(getEntityClass())
        val query = em.createQuery(c)
        return query.getResultList()
    }

    override fun count(): Int {
        val builder = em.criteriaBuilder
        val c = builder.createQuery(Long::class.java)
        c.select(builder.count(c.from(getEntityClass())))
        val query = em.createQuery(c)
        val counter = query.singleResult
        return Math.toIntExact(counter!!)
    }
}