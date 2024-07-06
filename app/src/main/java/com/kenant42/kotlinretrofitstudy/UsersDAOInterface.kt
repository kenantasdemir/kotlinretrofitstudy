package com.kenant42.kotlinretrofitstudy

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface UsersDAOInterface {
    @POST("kisiler/delete_kisiler.php")
    @FormUrlEncoded
    fun removeUser(@Field("kisi_id") kisi_id:Int):Call<CRUDResponse>

    @POST("kisiler/insert_kisiler.php")
    @FormUrlEncoded
    fun saveUser(@Field("kisi_ad") kisi_ad:String,@Field("kisi_tel") kisi_tel:String):Call<CRUDResponse>

    @POST("kisiler/update_kisiler.php")
    @FormUrlEncoded
    fun updateUser(@Field("kisi_id") kisi_id:Int,@Field("kisi_ad") kisi_ad:String,@Field("kisi_tel") kisi_tel:String):Call<CRUDResponse>

    @GET("kisiler/tum_kisiler.php")
    fun getUsers():Call<UserResponse>

    @POST("kisiler/tum_kisiler_arama.php")
    @FormUrlEncoded
    fun searchUser(@Field("kisi_ad") kisi_ad:String):Call<UserResponse>
}