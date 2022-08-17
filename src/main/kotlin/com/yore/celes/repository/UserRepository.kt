package com.yore.celes.repository

import aws.sdk.kotlin.services.dynamodb.model.AttributeValue
import com.yore.celes.mapper.UserMapper
import com.yore.celes.model.User
import java.util.*

class UserRepository {

    val table = "celer-user";
    fun create(user: User): String {

        val userMap = mapOf(

            "id" to AttributeValue.S(UUID.randomUUID().toString()),
            "name" to AttributeValue.S(user.name),
            "email" to AttributeValue.S(user.email),
            "login" to AttributeValue.S(user.login),
            "password" to AttributeValue.S(user.password),
            "active" to AttributeValue.Bool(user.active),
            "lastLogin" to AttributeValue.S(user.lastLogin.toString())

        )
        DynamoDB().putItem(userMap, table);

        return "success"
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




