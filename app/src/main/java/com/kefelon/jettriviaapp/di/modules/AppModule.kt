package com.kefelon.jettriviaapp.di.modules

import com.kefelon.jettriviaapp.network.QuestionApi
import com.kefelon.jettriviaapp.repository.QuestionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideQuestionRepository(api: QuestionApi): QuestionRepository =
        QuestionRepository(api)
}