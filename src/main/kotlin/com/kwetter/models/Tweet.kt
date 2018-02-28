package com.kwetter.models

import com.kwetter.dao.IModel
import java.util.Date
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.validation.constraints.Size
import javax.xml.bind.annotation.XmlTransient

@Entity
data class Tweet(
        @Size(max = 140)
        var text: String,

        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        override var id: Long = -1,

        override var createdAt: Date = Date(),
        override var updatedAt: Date = Date()
) : IModel {
    @ManyToOne
    @XmlTransient
    @JoinColumn(name = "user_id")
    lateinit var owner: User
}