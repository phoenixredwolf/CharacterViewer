package com.sample.sampleapp.di

import com.sample.sampleapp.data.repo.CharacterRepositoryImpl
import com.sample.sampleapp.data.repo.CharacterRespository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {

    @Binds
    abstract fun bindRepo(characterRepositoryImpl: CharacterRepositoryImpl): CharacterRespository

}