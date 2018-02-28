package com.kwetter.models

import com.kwetter.dao.IModel
import java.util.Date
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EntityManager
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinTable
import javax.persistence.NamedQuery
import javax.persistence.OneToMany
import javax.validation.constraints.Size
import javax.xml.bind.annotation.XmlTransient

@Entity
@NamedQuery(name = "user.findByUserName", query = "SELECT a FROM User a where a.username like :username")
data class User(
        @Column(unique = true)
        var username: String,

        @Column(unique = true)
        var email: String,

        var password: String,

        var profile_picture: String,
        var location: String,
        var website: String,

        @Size(max = 160)
        var bio: String = "",

        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        override var id: Long = -1,

        override var createdAt: Date = Date(),
        override var updatedAt: Date = Date()
) : IModel {
    @OneToMany(mappedBy = "owner")
    @XmlTransient
    lateinit var tweets: List<Tweet>

    @OneToMany
    @XmlTransient
    @JoinTable(name = "user_following")
    lateinit var following: List<User>
}

fun EntityManager.createNamedQueryUserFindByQuery() =
        this.createNamedQuery("user.findByUserName", User::class.java)


//@OneToMany(mapped_by = "user")
//

//@ManyToOne @JoinColumn(name = "user_id")
//va user: User