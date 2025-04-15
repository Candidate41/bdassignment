package com.example.nanitassignmentclient.babybirthday.data

import com.example.nanitassignmentclient.babybirthday.data.model.BabyBirthdaySettingsResponse
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.websocket.WebSockets
import io.ktor.client.plugins.websocket.webSocket
import io.ktor.http.HttpMethod
import io.ktor.http.URLProtocol
import io.ktor.websocket.Frame
import io.ktor.websocket.readText
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.serialization.json.Json

class BabyBirthdayClient {

    private val client = HttpClient(CIO) {
        install(WebSockets) {
            pingInterval = 2000
        }
    }

    fun listenForBirthdaySettings(host: String): Flow<BabyBirthdaySettingsResponse> = flow {
        client.webSocket(
            method = HttpMethod.Get,
            host = host,
            port = 8080,
            path = "/nanit",
            request = {
                url.protocol = URLProtocol.WS
            }
        ) {
            send(Frame.Text("HappyBirthday"))

            for (frame in incoming) {
                if (frame is Frame.Text) {
                    val response = frame.readText()
                    emit(parseBabyInfoSettings(response))
                }
            }
        }
    }.flowOn(Dispatchers.IO)

    private fun parseBabyInfoSettings(response: String): BabyBirthdaySettingsResponse {
        return try {
            val json = Json { ignoreUnknownKeys = true }
            json.decodeFromString<BabyBirthdaySettingsResponse>(response)
        } catch (e: Exception) {
            throw IllegalArgumentException("Failed to parse BabyInfo from response: $response", e)
        }
    }
}