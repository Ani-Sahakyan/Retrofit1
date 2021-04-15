package am.example.retrofit1

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface UserAPI {

    @GET("public-api/products/2")
    fun getSingleUser(): Call<UserModel>
}

object UserRetrofitService{
    val retrofit = Retrofit.Builder()
        .baseUrl("https://gorest.co.in/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}