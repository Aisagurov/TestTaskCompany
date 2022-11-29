package suvorov.testtaskcompany.domain

import androidx.lifecycle.LiveData
import suvorov.testtaskcompany.data.model.local.DetailEntity

interface DetailRepository {
    fun detailById(id: String): LiveData<DetailEntity>
    suspend fun getDetailFromApi(id: Int)
}