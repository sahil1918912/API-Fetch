package com.example.e2logy_sahil.model

data class Products(
    val Message: String,
    val RecordCount: String,
    val Result: List<Result>,
    val Status: Int
)