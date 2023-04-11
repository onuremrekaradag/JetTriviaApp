package com.kefelon.jettriviaapp.repository

import android.util.Log
import com.kefelon.jettriviaapp.data.DataOrException
import com.kefelon.jettriviaapp.model.QuestionItem
import com.kefelon.jettriviaapp.network.QuestionApi
import javax.inject.Inject

class QuestionRepository @Inject constructor(private val questionApi: QuestionApi) {

    private val dataOrException = DataOrException<ArrayList<QuestionItem>, Boolean, Exception>()

    suspend fun getAllQuestions(): DataOrException<ArrayList<QuestionItem>, Boolean, Exception> {
        try {
            dataOrException.loading = true
            dataOrException.data = questionApi.getAllQuestions()
            if (dataOrException.data.toString().isNotEmpty()) {
                dataOrException.loading = false
            }
        } catch (e: Exception) {
            dataOrException.e = e
            e.localizedMessage?.let { Log.e("Logger", it) }
        }

        return dataOrException
    }
}