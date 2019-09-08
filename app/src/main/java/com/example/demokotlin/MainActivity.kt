package com.example.demokotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.demokotlin.retrofit.ResponseServer
import com.example.demokotlin.retrofit.RetrofitService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ResponseServer {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RetrofitService.RetrofitService(this)
        btnClick.setOnClickListener { RetrofitService.get("ABC") }
    }

    override fun success(data: String) {
        Toast.makeText(this,data,Toast.LENGTH_SHORT).show()
    }

    override fun success() {
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
    }

    override fun error() {
        Toast.makeText(this, "Fail", Toast.LENGTH_SHORT).show()
    }
}
