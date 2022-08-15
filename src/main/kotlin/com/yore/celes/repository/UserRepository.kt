package com.yore.celes.repository

import aws.sdk.kotlin.services.dynamodb.DynamoDbClient
import aws.sdk.kotlin.services.dynamodb.model.AttributeValue
import aws.sdk.kotlin.services.dynamodb.model.PutItemRequest
import com.yore.celes.model.User
import kotlinx.coroutines.runBlocking
import java.util.UUID

class UserRepository {

     fun create(user: User):String {

        val userMap = mapOf(

            "id" to AttributeValue.S(UUID.randomUUID().toString()),
            "name" to AttributeValue.S(user.name),
            "email" to AttributeValue.S(user.email),
            "login" to AttributeValue.S(user.login),
            "password" to AttributeValue.S(user.password),
            "active" to AttributeValue.Bool(user.active),
            "lastLogin" to AttributeValue.S(user.lastLogin.toString())

        )
        val request = PutItemRequest{
            tableName = "celer-user"
            item = userMap
        }

         runBlocking { put(request);}

         return "success"
    }

    suspend fun put(item:PutItemRequest){

        DynamoDbClient { region = "us-east-1" }.use{
            ddb -> ddb.putItem(item);
        }

    }

}