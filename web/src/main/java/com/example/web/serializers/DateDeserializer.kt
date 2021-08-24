package mx.com.satoritech.web.api.serializers

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import java.lang.reflect.Type
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class DateDeserializer : JsonDeserializer<Date?> {
    @Throws(JsonParseException::class)
    override fun deserialize(
        json: JsonElement, typeOfT: Type,
        context: JsonDeserializationContext
    ): Date? {
        return try {
            if (json.asString.length > 10) {
                dateTimeFormatter.parse(json.asString)
            } else {
                dateFormatter.parse(json.asString)
            }
        } catch (e: ParseException) {
            null
        }
    }

    companion object {
        private val dateFormatter =
            SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        private val dateTimeFormatter =
            SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    }
}