package com.example.wbproject

fun Int?.orZero(): Int {
    return this ?: 0
}