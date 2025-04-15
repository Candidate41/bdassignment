package com.example.nanitassignmentclient.babybirthday.data.serializer

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneOffset

object LocalDateAsEpochMillisSerializer : KSerializer<LocalDate> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("LocalDateAsEpochMillis", PrimitiveKind.LONG)

    override fun serialize(encoder: Encoder, value: LocalDate) {
        val millis = value.atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli()
        encoder.encodeLong(millis)
    }

    override fun deserialize(decoder: Decoder): LocalDate {
        val millis = decoder.decodeLong()
        return Instant.ofEpochMilli(millis).atZone(ZoneOffset.UTC).toLocalDate()
    }
}