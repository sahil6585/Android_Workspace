package com.example.crick_r

import android.telecom.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import java.lang.Void

interface ApiInterface
{


    @FormUrlEncoded
    @POST("insert.php")
    fun insertdata(
        @Field("cricketer_name") c_name:String,
        @Field("cricketer_wickets") c_wicket:String,
        @Field("cricketer_age") c_age:String,
        @Field("cricketer_highest_score") c_h_score:String,
        @Field("cricketer_total_score") c_t_score:String
        ): retrofit2.Call<Void>

    @GET("view.php")
    fun viewdata(): retrofit2.Call<List<Modell>>


    @FormUrlEncoded
    @POST("delete.php")
    fun deletedata(
        @Field("id") id:Int
    ):retrofit2.Call<Void>

    @FormUrlEncoded
    @POST("update.php")
    fun updatedata(
        @Field("id")id:Int,
        @Field("cricketer_name")name:String,
        @Field("cricketer_wickets")wicket:String,
        @Field("cricketer_age")age:String,
        @Field("cricketer_highest_score")hscore:String,
        @Field("cricketer_total_score")tscore:String
    ): retrofit2.Call<Void>


    @FormUrlEncoded
    @POST("register.php")
    fun registerdata(
        @Field("mobile") mobile:String,
        @Field("location") location:String,
        @Field("password") pass:String,
        @Field("username") username:String,
    ):retrofit2.Call<Void>

    @FormUrlEncoded
    @POST("login.php")
    fun logindata(
        @Field("mobile") mobile:String,
        @Field("password") pass:String,
    ):retrofit2.Call<RegisteerModel>
}