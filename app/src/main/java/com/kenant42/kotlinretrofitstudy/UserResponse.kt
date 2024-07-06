package com.kenant42.kotlinretrofitstudy

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("kisiler")
    @Expose
    var users:List<User>,
    @SerializedName("success")
    @Expose
    var success:Int
) {
}