package com.example.demokotlin.retrofit

import android.os.Build
import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName
import java.util.*

class BaseResponse {

    @SerializedName("data")
    private val data: JsonElement? = null

    @SerializedName("message")
    val message: String? = null

    @SerializedName("code")
    val code: Int? = null

    val dataObject: JsonObject
        get() = data!!.asJsonObject

    val dataArray: JsonArray
        get() = data!!.asJsonArray

    fun getData(): String {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.toString(data)
        } else data!!.toString()
    }
}