package suvorov.testtaskcompany.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import suvorov.testtaskcompany.data.model.local.CompanyEntity
import suvorov.testtaskcompany.data.model.local.DetailEntity

@Dao
interface CompanyDao {
    @Query("SELECT * FROM company")
    fun getCompaniesList(): LiveData<List<CompanyEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCompaniesList(list: List<CompanyEntity>)

    @Query("SELECT * FROM detail WHERE id = :id")
    fun detailById(id: String): LiveData<DetailEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDetail(detail: DetailEntity)
}