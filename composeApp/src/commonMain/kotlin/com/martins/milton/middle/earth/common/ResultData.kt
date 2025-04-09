package com.martins.milton.middle.earth.common

sealed class ResultData<out R> {
    data class Success<out T>(val data: T): ResultData<T>()
    data class Error(val message: String): ResultData<Nothing>()
    data class Loading(val loading: Boolean): ResultData<Nothing>()
}