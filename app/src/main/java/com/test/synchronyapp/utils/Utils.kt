package com.test.synchronyapp.utils

import android.graphics.Bitmap
import android.util.Base64
import android.util.Base64.DEFAULT
import android.util.Base64.encodeToString
import java.io.ByteArrayOutputStream
import android.graphics.BitmapFactory

class Utils {
    companion object {
        fun getEncodedString(bmp: Bitmap): String? {
            val baos = ByteArrayOutputStream()
            bmp.compress(Bitmap.CompressFormat.PNG, 100, baos)
            val b: ByteArray = baos.toByteArray()
            return Base64.encodeToString(b, Base64.DEFAULT)
        }

        fun getBitmapFromEncodedStr(encodedImageString: String?): Bitmap? {
            val bytarray: ByteArray = Base64.decode(encodedImageString, DEFAULT)
            val bmimage = BitmapFactory.decodeByteArray(
                bytarray, 0,
                bytarray.size
            )
            return bmimage
        }
    }
}