package com.tihasg.rxjava.di

import com.google.gson.GsonBuilder
import com.tihasg.rxjava.network.NewsApi
import com.tihasg.rxjava.repository.Repository
import com.tihasg.rxjava.ui.HomeViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


val loginModule = module {
    single { provideHttpLoggingInterceptor() }
    single { provideOkHttp(get()) }
    single { provideRetrofit(get()) }

    factory { Repository(get()) }

    viewModel { HomeViewModel(get()) }
}

private fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
    HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }


private fun provideOkHttp(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
    val okHttpClient = OkHttpClient.Builder()
    okHttpClient.apply {
        addInterceptor(httpLoggingInterceptor)
    }
    return okHttpClient.build()
}

private fun provideRetrofit(okHttpClient: OkHttpClient): NewsApi {
    val gson = GsonBuilder().setLenient().create()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.spaceflightnewsapi.net/v3/")
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttpClient)
        .build()

    return retrofit.create(NewsApi::class.java)
}