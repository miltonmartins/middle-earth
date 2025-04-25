package com.martins.milton.middle.earth.common

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.request
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode

suspend inline fun <reified T> HttpClient.getResults(
    block: HttpRequestBuilder.() -> Unit
): ResultData<T> = try {
    val response = request(block)
    if (response.status == HttpStatusCode.OK) {
        ResultData.Success(response.body())
    } else {
        ResultData.Error("${response.status}: ${response.bodyAsText()}")
    }
} catch (e: Exception) {
    ResultData.Error(e.message.orEmpty())
}


inline fun <T, R> ResultData<T>.map(transform: (value: T) -> R): ResultData<R> = when (this) {
    is ResultData.Success -> ResultData.Success(transform(data))
    is ResultData.Error -> ResultData.Error(message)
    is ResultData.Loading -> ResultData.Loading(loading)
}