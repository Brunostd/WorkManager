package com.deny.workmanager.di

import com.deny.workmanager.MainViewModel
import com.deny.workmanager.repository.MoviesRepository
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {
    singleOf(::MoviesRepository)
    viewModelOf(::MainViewModel)
}