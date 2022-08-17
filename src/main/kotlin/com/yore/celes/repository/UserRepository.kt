package com.yore.celes.repository

import aws.sdk.kotlin.services.dynamodb.model.AttributeValue
import com.yore.celes.dto.UserInput
import com.yore.celes.mapper.UserMapper
import com.yore.celes.model.User
import java.time.LocalDateTime
import java.util.*

class UserRepository {

    val table = "celer-user";
    fun create(user: UserInput): User {

        var newUser = User(
            id =  UUID.randomUUID().toString(),
            name = user.name,
            email = user.email,
            login = user.login,
            password = user.password,
            active = true,
            lastLogin = LocalDateTime.now()
        );

        val userMap = mapOf(
            "id" to AttributeValue.S(newUser.id),
            "name" to AttributeValue.S(newUser.name),
            "email" to AttributeValue.S(newUser.email),
            "login" to AttributeValue.S(newUser.login),
            "password" to AttributeValue.S(newUser.password),
            "active" to AttributeValue.Bool(newUser.active),
            "lastLogin" to AttributeValue.S(newUser.lastLogin.toString())
        )
        DynamoDB().putItem(userMap, table);

        return newUser;
    }

    fun get(id: String): User? {
        val idMap = mapOf("id" to AttributeValue.S(id));
        val userResponse = DynamoDB().getItem(idMap, table);

        if (userResponse != null) {
            return UserMapper().map(userResponse);
        }

        return null;
    }

}




