package com.yore.celes.util

import com.google.gson.JsonElement
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import java.lang.reflect.Type
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class LocalDateAdapter : JsonSerializer<LocalDateTime> {
    override fun serialize(src: LocalDateTime, typeOfSrc: Type?, context: JsonSerializationContext?): JsonElement {
        return JsonPrimitive(src.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME))
    }
}