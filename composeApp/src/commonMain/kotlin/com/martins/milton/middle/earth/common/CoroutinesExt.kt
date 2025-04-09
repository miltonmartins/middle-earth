package com.martins.milton.middle.earth.common

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

fun <T> CoroutineScope.launchAndGetData(
    block: suspend CoroutineScope.() -> T,
    onResult: GenericCallback<ResultData<T>>
) {
    launch {
        try {
            onResult(ResultData.Loading(true))
            val result = withContext(Dispatchers.IO) {
                block()
            }
            onResult(ResultData.Loading(false))

            withContext(Dispatchers.Main) {
                onResult(ResultData.Success(result))
            }
        } catch (exception: Exception) {
            onResult(ResultData.Error(exception.message.orEmpty()))
        }
    }
}