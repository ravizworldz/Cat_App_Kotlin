package com.test.synchronyapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(getLayoutResourceId())
        getSupportActionBar()?.hide()
        onViewModelInit()
        onViewReady(savedInstanceState , intent)
    }

    protected abstract fun getLayoutResourceId(): Int
    protected abstract fun onViewReady(savedInstanceState: Bundle?, intent: Intent)
    protected abstract fun onViewModelInit()

    override fun onBackPressed() {
        super.onBackPressed()
    }

    /**
     * Show error dialog.
     */
    fun showError(title: String, message: String, button: String) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton(button) { dialog, which ->
            dialog.dismiss()
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}