package suvorov.testtaskcompany.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import suvorov.testtaskcompany.data.repository.detail.DetailLocalDataSource
import suvorov.testtaskcompany.data.repository.detail.DetailRemoteDataSource
import suvorov.testtaskcompany.data.repository.detail.DetailRepositoryImpl
import suvorov.testtaskcompany.data.repository.list.ListLocalDataSource
import suvorov.testtaskcompany.data.repository.list.ListRemoteDataSource
import suvorov.testtaskcompany.data.repository.list.ListRepositoryImpl
import suvorov.testtaskcompany.domain.ListRepository
import suvorov.testtaskcompany.domain.DetailRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun provideCompanyRepository(
        remoteDataSource: ListRemoteDataSource,
        localDataSource: ListLocalDataSource
    ): ListRepository {
        return ListRepositoryImpl(remoteDataSource, localDataSource)
    }

    @Provides
    @Singleton
    fun provideDetailRepository(
        remoteDataSource: DetailRemoteDataSource,
        localDataSource: DetailLocalDataSource
    ): DetailRepository {
        return DetailRepositoryImpl(remoteDataSource, localDataSource)
    }
}