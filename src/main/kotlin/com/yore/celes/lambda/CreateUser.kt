package com.yore.celes.lambda

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent
import com.google.gson.GsonBuilder
import com.yore.celes.dto.UserInput
import com.yore.celes.model.User
import com.yore.celes.repository.UserRepository
import com.yore.celes.util.LocalDateAdapter
import kotlinx.coroutines.runBlocking
import java.time.LocalDateTime


class CreateUser : RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {


    override fun handleRequest(input: APIGatewayProxyRequestEvent, context: Context?): APIGatewayProxyResponseEvent {
        val gson = GsonBuilder().registerTypeAdapter(LocalDateTime::class.java, LocalDateAdapter()).create();
        var userRepository = UserRepository();
        val newUser = userRepository.create(gson.fromJson(input.body, UserInput::class.java));

        return APIGatewayProxyResponseEvent()
            .withStatusCode(201)
            .withBody(gson.toJson(newUser))
    }
}