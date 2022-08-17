package com.yore.celes.lambda

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent
import com.google.gson.GsonBuilder
import com.yore.celes.model.User
import com.yore.celes.repository.UserRepository
import com.yore.celes.util.LocalDateAdapter
import java.time.LocalDateTime


class GetUser : RequestHandler<String, APIGatewayProxyResponseEvent> {


    override fun handleRequest(id: String, context: Context?): APIGatewayProxyResponseEvent {

        val gson = GsonBuilder().registerTypeAdapter(LocalDateTime::class.java, LocalDateAdapter()).create();
        var userRepository = UserRepository();


        var user = userRepository.get(id);

        return APIGatewayProxyResponseEvent()
            .withStatusCode(200)
            .withBody("${gson.toJson(user)}")
    }
}