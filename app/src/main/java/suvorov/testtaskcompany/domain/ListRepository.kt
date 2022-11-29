package suvorov.testtaskcompany.domain

import androidx.lifecycle.LiveData
import suvorov.testtaskcompany.data.model.local.CompanyEntity

interface ListRepository {
    val companiesListFromDatabase: LiveData<List<CompanyEntity>>
    suspend fun getCompaniesListFromApi()
}