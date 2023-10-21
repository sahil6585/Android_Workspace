package com.example.crick_r

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Modell
{

    @Expose
    @SerializedName("id")
    var id=0

    @Expose
    @SerializedName("cricketer_name")
    var cricketer_name=""

    @Expose
    @SerializedName("cricketer_total_score")
    var cricketer_total_score=""

    @Expose
    @SerializedName("cricketer_age")
    var cricketer_age=""

    @Expose
    @SerializedName("cricketer_highest_score")
    var cricketer_highest_score=""

    @Expose
    @SerializedName("cricketer_wickets")
    var cricketer_wickets=""

}