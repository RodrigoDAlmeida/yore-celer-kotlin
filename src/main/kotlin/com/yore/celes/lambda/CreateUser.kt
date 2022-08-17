package com.yore.celes.lambda

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent
import com.yore.celes.dto.UserInput
import com.yore.celes.model.User
import com.yore.celes.repository.UserRepository
import kotlinx.coroutines.runBlocking


class CreateUser : RequestHandler<UserInput, APIGatewayProxyResponseEvent> {


    override fun handleRequest(input: UserInput, context: Context?): APIGatewayProxyResponseEvent {

        var userRepository = UserRepository();
        var user = User(
            name = input.name,
            login = input.login,
            password = input.password,
            email = input.email
        )

        val msg = userRepository.create(user);

        return APIGatewayProxyResponseEvent()
            .withStatusCode(201)
            .withBody("User created!${msg}")
    }
}