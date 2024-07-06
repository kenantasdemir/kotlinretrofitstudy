package com.kenant42.kotlinretrofitstudy

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("kisi_id")
    @Expose
    var kisiId:Int,
    @SerializedName("kisi_ad")
    @Expose
    var kisiAd:String,
    @SerializedName("kisi_tel")
    @Expose
    var kisiTel:String

) {
}