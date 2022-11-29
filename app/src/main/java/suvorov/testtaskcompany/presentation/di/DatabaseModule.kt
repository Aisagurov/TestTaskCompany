package suvorov.testtaskcompany.presentation.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import suvorov.testtaskcompany.data.database.CompanyDao
import suvorov.testtaskcompany.data.database.CompanyDatabase
import suvorov.testtaskcompany.util.Constants.NAME_DATABASE
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): CompanyDatabase {
        return Room.databaseBuilder(
            context, CompanyDatabase::class.java, NAME_DATABASE
        ).build()
    }

    @Provides
    @Singleton
    fun provideDao(database: CompanyDatabase): CompanyDao {
        return database.dao()
    }
}