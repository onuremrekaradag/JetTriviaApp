package com.kefelon.jettriviaapp.network

import com.kefelon.jettriviaapp.model.Question
import retrofit2.http.GET

interface QuestionApi {

    @GET("itmmckernan/triviaJSON/master/world.json")
    suspend fun getAllQuestions(): Question


}