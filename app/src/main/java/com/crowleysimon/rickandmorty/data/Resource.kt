package com.crowleysimon.rickandmorty.data

/**
 * Sealed class that holds a value and represents it's state Success/Loading/Error
 * @param <T>
 */
sealed class Resource<out T> {
    data class Success<out T>(val data: T) : Resource<T>()
    data class Loading<out T>(val partialData: T? = null) : Resource<T>()
    data class Failure<out T>(val throwable: Throwable? = null) : Resource<T>()
}