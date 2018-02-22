package com.kwetter.dao

interface IDao<T> {
    fun create(model: T): T
    fun update(model: T): T
    fun remove(model: T)
    fun getById(id: Int): T
    fun getAll(): List<T>
    fun count(): Int
}