package com.adiupd123.cookmaster

class UserService {

    val retrofit = RetrofitClient.getClient()
    val userApi = retrofit.create(RecipeApi::class.java)


}