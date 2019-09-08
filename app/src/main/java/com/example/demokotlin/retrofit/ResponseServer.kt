package com.example.demokotlin.retrofit

interface ResponseServer {

    fun success()

    fun error()

    fun success(data: String)
}