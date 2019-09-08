package com.example.demokotlin.dto

data class Currency(
    val currencyCode: String,
    val currencyName: String,
    val buy: Double,
    val sell: Double,
    val transfer: Double,
    val isChose: Boolean
)
