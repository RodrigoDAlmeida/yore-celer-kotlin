package com.yore.celes.mapper

import aws.sdk.kotlin.services.dynamodb.model.AttributeValue
import com.yore.celes.model.User
import java.time.LocalDateTime

class UserMapper: Mapper<Map<String, AttributeValue>, User> {
    override fun map(t: Map<String, AttributeValue>): User {

        var user = User();
        t.forEach { (t, u) ->

            when(t){
                "id" -> user.id = u.asS()
                "name" -> user.name = u.asS()
                "login" -> user.login = u.asS()
                "password" -> user.password = u.asS()
                "active" -> user.active = u.asBool()
                "lastLogin" -> user.lastLogin = LocalDateTime.parse(u.asS())
            }
        }

        return user;
    }
}