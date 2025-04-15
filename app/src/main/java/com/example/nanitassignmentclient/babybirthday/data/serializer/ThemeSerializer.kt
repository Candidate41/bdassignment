package com.example.nanitassignmentclient.babybirthday.data.serializer

import com.example.nanitassignmentclient.babybirthday.domain.model.Theme
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

object ThemeSerializer : KSerializer<Theme> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("Theme", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: Theme) {
        encoder.encodeString(value.name.lowercase())
    }

    override fun deserialize(decoder: Decoder): Theme {
        return Theme.valueOf(decoder.decodeString().uppercase())
    }
}