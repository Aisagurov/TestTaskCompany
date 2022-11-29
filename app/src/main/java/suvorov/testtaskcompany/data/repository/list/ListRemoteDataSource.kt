package suvorov.testtaskcompany.data.repository.list

import suvorov.testtaskcompany.data.api.ApiService
import javax.inject.Inject

class ListRemoteDataSource @Inject constructor(private val service: ApiService) {
    suspend fun getCompaniesList() = service.getCompaniesList()
}