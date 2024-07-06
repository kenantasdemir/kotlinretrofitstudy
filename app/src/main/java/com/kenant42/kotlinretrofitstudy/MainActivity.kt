package com.kenant42.kotlinretrofitstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchUser()
    }

    fun removeUser() {
        val usersDAO = ApiUtils.getUsersDAOInterface()
        usersDAO.removeUser(387).enqueue(object : Callback<CRUDResponse> {
            override fun onResponse(call: Call<CRUDResponse>?, response: Response<CRUDResponse>?) {
                if (response != null) {
                    Log.e("BAŞARI: ", response.body().success.toString())
                    Log.e("MESAJ: ", response.body().message.toString())
                }
            }

            override fun onFailure(call: Call<CRUDResponse>?, t: Throwable?) {
                TODO("Not yet implemented")
            }
        })
    }


    fun saveUser() {
        val usersDAO = ApiUtils.getUsersDAOInterface()
        usersDAO.saveUser("Ali", "6546346346").enqueue(object : Callback<CRUDResponse> {
            override fun onFailure(call: Call<CRUDResponse>?, t: Throwable?) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<CRUDResponse>?, response: Response<CRUDResponse>?) {
                if (response != null) {
                    Log.e("SUCCESS ", response.body().success.toString())
                    Log.e("MESSAGE ", response.body().message)
                }
            }
        })
    }

    fun updateUser() {
        val usersDAO = ApiUtils.getUsersDAOInterface()

        usersDAO.updateUser(3, "YENI AD", "64646456").enqueue(object : Callback<CRUDResponse> {
            override fun onResponse(call: Call<CRUDResponse>?, response: Response<CRUDResponse>?) {
                if (response != null) {
                    Log.e("SUCCESS ", response.body().success.toString())
                    Log.e("MESSAGE ", response.body().message)
                }
            }

            override fun onFailure(call: Call<CRUDResponse>?, t: Throwable?) {
                TODO("Not yet implemented")
            }
        })
    }

    fun getUsers() {
        val usersDAO = ApiUtils.getUsersDAOInterface()
        usersDAO.getUsers().enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>?, response: Response<UserResponse>?) {
                if (response != null) {
                    var usersList = response.body().users
                    for (user in usersList) {
                        Log.e("USER ID: ", user.kisiId.toString())
                        Log.e("USER NAME: ", user.kisiAd)
                        Log.e("USER PHONE: ", user.kisiTel)
                        Log.e("******************", "*******************")
                    }
                }
            }

            override fun onFailure(call: Call<UserResponse>?, t: Throwable?) {
                TODO("Not yet implemented")
            }
        })
    }

    fun searchUser() {
        val usersDAO = ApiUtils.getUsersDAOInterface()
        usersDAO.searchUser("Ahmet").enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>?, response: Response<UserResponse>?) {
                if (response != null) {
                    val usersList = response.body().users
                    for (user in usersList) {
                        Log.e("USER ID: ", user.kisiId.toString())
                        Log.e("USER NAME: ", user.kisiAd)
                        Log.e("USER PHONE: ", user.kisiTel)
                        Log.e("******************", "*******************")
                    }
                }
            }

            override fun onFailure(call: Call<UserResponse>?, t: Throwable?) {
                TODO("Not yet implemented")
            }
        })
    }
}