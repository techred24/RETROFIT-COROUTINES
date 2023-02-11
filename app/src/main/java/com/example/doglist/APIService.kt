package com.example.doglist

import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface APIService {
    //@Headers("Accept: application/json")
    @GET
    suspend fun getDogsByBreeds(@Url url:String):Response<DogsResponse>

    @GET("/example/example2/{id}/loquesea")
    fun getCharacterByName(@Path("id") id:String): Call<DogsResponse>

    @GET("/example/example2/v2/loquesea")
    fun getCharacterByName2(@Query("pet") pet:String, @Query("name") name:String):Call<DogsResponse>

    @POST
    fun getEverything(@Body exampleRafaelDto: ExampleRafaelDto): Call<*>

    @Multipart
    @POST
    fun sendPhoto(@Part image: MultipartBody.Part, @Part("example") myExample: String): Call<*>
    // val requestBody = RequestBody.create(MediaType.parse(getContentResolver().getType(fileUri)), file);
    // val a = MultipartBody.Part.createFormData("picture", file.getName(), requestBody);
}

data class ExampleRafaelDto(val name: String, val age: Int)