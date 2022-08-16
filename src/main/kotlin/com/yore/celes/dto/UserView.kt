package com.yore.celes.dto

import kotlinx.serialization.Serializable
import java.time.LocalDateTime

@Serializable
class UserView (
    val id:String? = null,
    val name:String,
    val email:String,
    val login:String,
    val password:String,
    val active:Boolean = true,
    val lastLogin: LocalDateTime = LocalDateTime.now()
)
