package com.kwetter.models

import com.kwetter.dao.IModel
import java.util.*
import javax.persistence.*
import javax.validation.constraints.Size

@Entity
@NamedQuery(name = "userdao.findByUserName", query = "SELECT a FROM User a where a.username like :username")
data class User(
        @Column(unique = true)
        var username: String,

        @Column(unique = true)
        var email: String,

        var profile_picture: String,
        var location: String,
        var website: String,

        @Size(max = 160)
        var bio: String,

        @OneToMany(mappedBy = "owner")
        var tweets: List<Tweet>,

        @OneToMany
        @JoinTable(name = "user_following")
        var following: List<User>,

        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        override var id: Long = -1,

        override var createdAt: Date = Date(),
        override var updatedAt: Date = Date()
) : IModel

fun EntityManager.createNamedQueryUserFindByQuery() =
        this.createNamedQuery("userdao.findByUserName", User::class.java)


//@OneToMany(mapped_by = "user")
//

//@ManyToOne @JoinColumn(name = "user_id")
//va user: User