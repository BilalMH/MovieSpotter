package com.bilalhaider.projecttemplate.domain.data.remote.api

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

open class MobileAPIClient(private val httpEngine: HttpClientEngine) {

    companion object {
        const val BASE_URL = ""
    }

    private var _httpClient: HttpClient? = client()

    fun client() : HttpClient {
        if (_httpClient == null) {
            val newInstance = HttpClient(httpEngine) {
                expectSuccess = true

                install(Logging) {
                    logger = object : Logger {
                        override fun log(message: String) {
                            Log.d("HttpClient", message)
                        }
                    }

                    level = LogLevel.ALL
                }

                install(ContentNegotiation) {
                    json(
                        Json {
                            ignoreUnknownKeys = true
                            prettyPrint = true
                            isLenient = true
                        }
                    )
                }
            }

            _httpClient = newInstance
        }

        return _httpClient as HttpClient
    }
}