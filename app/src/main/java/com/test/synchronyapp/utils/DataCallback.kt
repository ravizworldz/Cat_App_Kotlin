package com.test.synchronyapp.utils

class DataCallback <out T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T?): DataCallback<T> {
            return DataCallback(Status.SUCCESS, data, null)
        }

        fun <T> success(data: T?, extraParams: String?): DataCallback<T> {
            return DataCallback(Status.SUCCESS, data, extraParams.toString())
        }

        fun <T> error(msg: String?, data: T?): DataCallback<T> {
            return DataCallback(Status.ERROR, data, msg)
        }

        fun <T> loading(data: T?): DataCallback<T> {
            return DataCallback(Status.LOADING, data, null)
        }
    }

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }
}