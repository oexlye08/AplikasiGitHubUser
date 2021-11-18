package id.my.okisulton.aplikasigithubuser.utils

import android.content.Context
import java.io.IOException

/**
 *Created by osalimi on 10-11-2021.
 **/
fun getDataFromAsset(context: Context, filename: String): String? {
    val jsonString: String
    try {
        jsonString = context.assets.open(filename).bufferedReader().use { it.readText() }

    } catch (ioException: IOException) {
        ioException.printStackTrace()
        return null
    }
    return jsonString
}
