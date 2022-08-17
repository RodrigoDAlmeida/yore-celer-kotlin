package com.yore.celes.model

import java.time.LocalDateTime

data class User(
    var id:String = "",
    var name:String = "",
    var email:String = "",
    var login:String = "",
    var password:String = "",
    var active:Boolean = true,
    var lastLogin:LocalDateTime = LocalDateTime.now()
);
