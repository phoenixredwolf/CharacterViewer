package com.sample.sampleapp.utility

fun getName(str: String): String {
    return str.split("/").last().replace("_", " ")
}