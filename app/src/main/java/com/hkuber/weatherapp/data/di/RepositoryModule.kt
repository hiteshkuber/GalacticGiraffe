package com.hkuber.weatherapp.data.di

import com.hkuber.weatherapp.data.location.DefaultLocationTracker
import com.hkuber.weatherapp.data.repository.WeatherRepositoryImpl
import com.hkuber.weatherapp.domain.location.LocationTracker
import com.hkuber.weatherapp.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindWeatherRepository(weatherRepositoryImpl: WeatherRepositoryImpl): WeatherRepository
}