package suvorov.testtaskcompany.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import suvorov.testtaskcompany.data.model.local.CompanyEntity
import suvorov.testtaskcompany.data.model.local.DetailEntity

@Database(entities = [CompanyEntity::class, DetailEntity::class], version = 1, exportSchema = false)
abstract class CompanyDatabase: RoomDatabase() {
    abstract fun dao(): CompanyDao
}