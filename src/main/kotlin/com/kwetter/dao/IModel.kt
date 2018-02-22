package com.kwetter.dao

import java.util.*

@FunctionalInterface
interface IModel {
    val id: Long
    var createdAt: Date
    var updatedAt: Date
}