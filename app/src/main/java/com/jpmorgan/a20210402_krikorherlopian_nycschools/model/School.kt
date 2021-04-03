package com.jpmorgan.a20210402_krikorherlopian_nycschools.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class School(@SerializedName("dbn")
                  val dbn: String?,
                  @SerializedName("school_name")
                  val schoolName: String?,
                  @SerializedName("overview_paragraph")
                  val overviewParagraph: String?,
                  @SerializedName("academicopportunities1")
                  val academicOpp1: String?,
                  @SerializedName("academicopportunities2")
                  val academicOpp2: String?,
                  @SerializedName("academicopportunities3")
                  val academicOpp3: String?,
                  @SerializedName("school_email")
                  val schoolEmail: String?,
                  @SerializedName("school_sports")
                  val schoolSports: String?,
                  @SerializedName("location")
                  val location: String?,
                  @SerializedName("city")
                  val city: String?,
                  @SerializedName("extracurricular_activities")
                  val extracurricularAct: String?,
                  @SerializedName("website")
                  val website: String?,
                  @SerializedName("start_time")
                  val startTime: String?,
                  @SerializedName("end_time")
                  val endTime: String?,
                  @SerializedName("program1")
                  val program1: String?,
                  @SerializedName("latitude")
                  val lat: String?,
                  @SerializedName("longitude")
                  val lng: String?,
                  @SerializedName("phone_number")
                  val phoneNumber: String?): Serializable{

    constructor(name: String) : this(dbn="", schoolName=name,"","","","","","","","",
    "","","","","","","","")
}
