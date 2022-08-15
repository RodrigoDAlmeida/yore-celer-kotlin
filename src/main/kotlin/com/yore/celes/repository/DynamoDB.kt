package com.yore.celes.repository

import aws.sdk.kotlin.services.dynamodb.DynamoDbClient
import aws.sdk.kotlin.services.dynamodb.model.PutItemRequest
import aws.sdk.kotlin.services.dynamodb.model.AttributeValue
import aws.sdk.kotlin.services.dynamodb.model.GetItemRequest
import aws.sdk.kotlin.services.dynamodb.model.GetItemResponse

import kotlinx.coroutines.runBlocking

class DynamoDB {

      fun putItem(values:  Map<String, AttributeValue>, table: String) {

          val request = PutItemRequest{
              tableName = table
              item = values
          }

         runBlocking {
             DynamoDbClient { region = "us-east-1" }.use { ddb ->
                 ddb.putItem(request);
             }
         }
     }

    fun getItem(idMap:  Map<String, AttributeValue>, table:String): Map<String, AttributeValue>? {
        var response: GetItemResponse;

        val request = GetItemRequest{
            tableName = table
            key = idMap
        }

        runBlocking {
            DynamoDbClient { region = "us-east-1" }.use { ddb ->
                response = ddb.getItem(request);

            }
        }

        return response.item;
    }
}