package mx.com.satoritech.web.api.serializers

import com.google.gson.JsonElement
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import java.lang.reflect.Type
import java.text.SimpleDateFormat
import java.util.*

class DateSerializer : JsonSerializer<Date?> {
    override fun serialize(
        src: Date?, typeOfSrc: Type,
        context: JsonSerializationContext
    ): JsonElement {
        return (if (src == null) null else JsonPrimitive(
            formatter.format(
                src
            )
        ))!!
    }

    companion object {
        private val formatter =
            SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    }
}
