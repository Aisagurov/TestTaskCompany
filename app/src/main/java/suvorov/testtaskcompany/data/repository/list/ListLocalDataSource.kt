package suvorov.testtaskcompany.data.repository.list

import suvorov.testtaskcompany.data.database.CompanyDao
import suvorov.testtaskcompany.data.model.local.CompanyEntity
import javax.inject.Inject

class ListLocalDataSource @Inject constructor(private val dao: CompanyDao) {

    val companiesList = dao.getCompaniesList()

    suspend fun insertCompaniesListIntoDatabase(list: List<CompanyEntity>) {
        if (list.isNotEmpty()) {
            dao.insertCompaniesList(list)
        }
    }
}