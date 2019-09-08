package com.example.demokotlin.retrofit

import android.support.annotation.NonNull

interface RequestMethod {

    fun get(@NonNull url: String)

    fun post(@NonNull url: String)

    fun put(@NonNull url: String)

    fun delete(@NonNull url: String)
}