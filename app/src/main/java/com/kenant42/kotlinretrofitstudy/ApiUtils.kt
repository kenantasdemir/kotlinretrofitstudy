package com.kenant42.kotlinretrofitstudy

class ApiUtils {
    companion object{
        val BASE_URL = "http://kasimadalan.pe.hu/"

        fun getUsersDAOInterface():UsersDAOInterface{
            return RetrofitClient.getClient(BASE_URL).create(UsersDAOInterface::class.java)
        }
    }
}