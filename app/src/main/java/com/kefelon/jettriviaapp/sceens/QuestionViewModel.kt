package com.kefelon.jettriviaapp.sceens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kefelon.jettriviaapp.data.DataOrException
import com.kefelon.jettriviaapp.model.QuestionItem
import com.kefelon.jettriviaapp.repository.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionViewModel @Inject constructor(private val questionRepository: QuestionRepository) :
    ViewModel() {


    val data: MutableState<DataOrException<ArrayList<QuestionItem>, Boolean, java.lang.Exception>> =
        mutableStateOf(
            DataOrException(null, true, Exception(""))
        )

    init {
        getAllQuestions()
    }


    private fun getAllQuestions() {
        viewModelScope.launch(Dispatchers.Main) {
//            data.value.loading = true
            data.value = questionRepository.getAllQuestions()
//            if (data.value.data.toString().isNotEmpty()) {
//                data.value.loading = false
//            }


//                DataOrException(
//                data = questionRepository.getAllQuestions(),
//                loading = false,
//                e = null
//            )

        }
    }

    fun getTotalQuestionCount(): Int {
        return data.value.data?.toMutableList()?.size!!
    }
}




