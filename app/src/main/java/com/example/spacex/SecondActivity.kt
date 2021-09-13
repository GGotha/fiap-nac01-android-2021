package com.example.spacex

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val sharedPreferences =
            getSharedPreferences(getString(R.string.pref_key), Context.MODE_PRIVATE);

        val userName = sharedPreferences.getString(getString(R.string.pref_key), "")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        var welcomeMessage = findViewById<TextView>(R.id.welcomeName)

        welcomeMessage.text = "Olá, ${userName}"

        getLatestLaunch()
    }

    fun getLatestLaunch() {

        WebService().getService().getLatestLaunch().enqueue(object : Callback<Launch> {

            override fun onFailure(call: Call<Launch>, t: Throwable) {
                Toast.makeText(this@SecondActivity, "Falha ao buscar", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Launch>, response: Response<Launch>) {
                val latestLaunch = response.body()

                var latestLaunchName = findViewById<TextView>(R.id.latestLaunchName)


                latestLaunchName.text = latestLaunch?.name

            }


        })

    }


}