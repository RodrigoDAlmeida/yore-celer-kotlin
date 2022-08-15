package com.yore.celes.model

import java.time.LocalDateTime

data class User(
    val id:String? = null,
    val name:String,
    val email:String,
    val login:String,
    val password:String,
    val active:Boolean = true,
    val lastLogin:LocalDateTime? = null
);
