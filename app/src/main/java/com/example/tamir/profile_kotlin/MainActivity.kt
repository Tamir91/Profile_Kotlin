package com.example.tamir.profile_kotlin

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val REQUEST_CODE: Int = 1

    lateinit var et_user_name: EditText
    lateinit var et_user_age: EditText
    lateinit var b_edit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        intiViews()
        initListeners()
    }

    private fun intiViews() {
        et_user_name = findViewById(R.id.et_user_name)
        et_user_age = findViewById(R.id.et_user_age)
        b_edit = findViewById(R.id.btn_edit)
    }

    private fun initListeners() {
        b_edit.setOnClickListener {
            val intent = Intent(this, EditActivity::class.java)
            intent.putExtra("name", et_user_name.text.toString())
            intent.putExtra("age", et_user_age.text.toString())

            startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK){
            et_user_name.setText(data!!.extras.getString("name"))
            et_user_age.setText(data!!.extras.getString("age"))
        }
    }
}