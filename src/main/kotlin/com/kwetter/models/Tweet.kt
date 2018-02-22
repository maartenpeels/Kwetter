package com.kwetter.models

import com.kwetter.dao.IModel
import java.util.*
import javax.persistence.*
import javax.validation.constraints.Size

@Entity
data class Tweet(
        @Size(max = 140)
        var text: String,

        @ManyToOne @JoinColumn(name = "user_id")
        var owner: User,

        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        override var id: Long = -1,

        override var createdAt: Date = Date(),
        override var updatedAt: Date = Date()
) : IModel