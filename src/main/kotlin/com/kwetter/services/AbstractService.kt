package com.kwetter.services
import com.kwetter.dao.IDao


abstract class AbstractService<T> : IDao<T> {
    protected abstract val dao: IDao<T>

    override fun create(model: T): T {
        return dao.create(model)
    }

    override fun update(model: T): T {
        return dao.update(model)
    }

    override fun remove(model: T) {
        dao.remove(model)
    }

    override fun getById(id: Int): T {
        return dao.getById(id)
    }

    override fun getAll(): List<T> {
        return dao.getAll()
    }

    override fun count(): Int {
        return dao.count()
    }
}