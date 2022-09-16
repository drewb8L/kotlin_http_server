package com.babcock.testHelpers

import java.io.FileInputStream
import java.lang.Exception
import java.lang.StringBuilder

object Utils {
    fun getFileStream(file:String):String {
        val input: FileInputStream = FileInputStream(file)
        var output = StringBuilder()
        try {
            val byte: ByteArray = ByteArray(input.available())
            input.read(byte)

            println("File size = ${byte.size}")
            for (i in 0..byte.size) {
                if (i >= byte.size) {
                    break
                } else {
                    output.append(byte[i].toInt().toChar())

                }

            }
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            input.close()
        }
        return output.toString()

    }

}