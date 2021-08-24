package mx.com.satoritech.web.api.serializers

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import java.lang.reflect.Type

class BooleanDeserializer : JsonDeserializer<Boolean> {
    @Throws(JsonParseException::class)
    override fun deserialize(
        json: JsonElement, typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Boolean {
        return try {
            json.asInt == 1
        } catch (e: Exception) {
            try {
                json.asBoolean
            } catch (ignored: Exception) {
                false
            }
        }
    }
}