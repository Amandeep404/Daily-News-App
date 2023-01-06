package com.example.dailynews.utils

//this class is recommended by google To wrap around pur network responses and to handle the loading state

// "Sealed" classes are like abstract classes but by using "sealed" we can allow which classes can inherit from this class
sealed class Resource<T>(
    val data : T? = null,
    val message : String? = null
) {
    class Success<T>(data : T) : Resource<T>(data)
    class Error<T>(message: String, data : T? = null) : Resource<T>(data, message)
    class Loading<T> : Resource<T>()
}