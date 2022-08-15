package com.yore.celes.dto

import java.time.LocalDateTime

data class UserView (
    var name:String,
    var email:String,
    var login:String,
    var password:String,
    val active:Boolean,
    val lastLogin: LocalDateTime

)