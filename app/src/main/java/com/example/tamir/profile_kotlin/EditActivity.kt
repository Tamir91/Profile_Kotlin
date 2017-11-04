package com.example.tamir.profile_kotlin

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class EditActivity : AppCompatActivity() {

    lateinit var et_user_name: EditText
    lateinit var et_user_age: EditText
    lateinit var b_save: Button

    lateinit var extras: Bundle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        intiViews()
        initListeners()
    }

    private fun initListeners() {
        b_save.setOnClickListener{
            intent.putExtra("name", et_user_name.text.toString())
            intent.putExtra("age", et_user_age.text.toString())
            setResult(Activity.RESULT_OK, intent)

            finish()
        }
    }

    private fun intiViews() {
        extras = intent.extras

        et_user_name = findViewById(R.id.et_user_name)
        et_user_name.setText(extras.getString("name"))

        et_user_age = findViewById(R.id.et_user_age)
        et_user_age.setText(extras.getString("age"))

        b_save = findViewById(R.id.btn_save)
    }
}
