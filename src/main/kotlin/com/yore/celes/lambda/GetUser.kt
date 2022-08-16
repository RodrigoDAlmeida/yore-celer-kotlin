package com.yore.celes.lambda

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent
import com.yore.celes.dto.UserInput
import com.yore.celes.model.User
import com.yore.celes.repository.UserRepository
import kotlinx.coroutines.runBlocking


class GetUser : RequestHandler<String, APIGatewayProxyResponseEvent> {


    override fun handleRequest(id: String, context: Context?): APIGatewayProxyResponseEvent {

        var userRepository = UserRepository();

        val user = userRepository.get(id);

        return APIGatewayProxyResponseEvent()
            .withStatusCode(200)
            .withBody("$user")
    }
}