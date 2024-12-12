package com.rgos_developer.projetomvvmcleanhilt.di

import com.rgos_developer.projetomvvmcleanhilt.data.remote.DummyAPI
import com.rgos_developer.projetomvvmcleanhilt.data.repository.UserRepositoryImpl
import com.rgos_developer.projetomvvmcleanhilt.domain.repository.UserRepository
import com.rgos_developer.projetomvvmcleanhilt.domain.usecases.GetUsersUseCase
import com.rgos_developer.projetomvvmcleanhilt.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
@InstallIn(ViewModelComponent::class)
object AppModule {
    @Provides
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideDummyApi(retrofit: Retrofit) : DummyAPI {
        return retrofit.create(DummyAPI::class.java)
    }

    @Provides
    fun provideUserRepository(dummyAPI: DummyAPI) : UserRepository {
        return  UserRepositoryImpl(dummyAPI)
    }

    @Provides
    fun providerGetUsersUseCase(repository: UserRepository) : GetUsersUseCase {
        return  GetUsersUseCase(repository)
    }
}