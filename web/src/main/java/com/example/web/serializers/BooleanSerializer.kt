package mx.com.satoritech.web.api.serializers

import com.google.gson.JsonElement
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import java.lang.reflect.Type

class BooleanSerializer : JsonSerializer<Boolean?> {
    override fun serialize(
        src: Boolean?, typeOfSrc: Type,
        context: JsonSerializationContext
    ): JsonElement? {
        return src?.let { JsonPrimitive(it) }
    }
}
