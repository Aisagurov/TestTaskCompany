package suvorov.testtaskcompany.data.repository.detail

import suvorov.testtaskcompany.data.database.CompanyDao
import suvorov.testtaskcompany.data.model.local.DetailEntity
import javax.inject.Inject

class DetailLocalDataSource @Inject constructor(private val dao: CompanyDao) {

    fun detailById(id: String) = dao.detailById(id)

    suspend fun insertDetailIntoDatabase(detail: DetailEntity) {
        dao.insertDetail(detail)
    }
}