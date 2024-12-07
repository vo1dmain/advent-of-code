package ru.vo1dmain.advent

import java.io.FileNotFoundException

fun <T : Any> T.resource(path: String) = this.javaClass.getResource(path) ?: throw FileNotFoundException()