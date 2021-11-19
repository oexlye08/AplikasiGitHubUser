package id.my.okisulton.aplikasigithubuser.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
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

