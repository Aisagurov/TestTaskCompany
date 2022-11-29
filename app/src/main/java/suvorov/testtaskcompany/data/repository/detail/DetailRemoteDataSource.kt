package suvorov.testtaskcompany.data.repository.detail

import suvorov.testtaskcompany.data.api.ApiService
import javax.inject.Inject

class DetailRemoteDataSource @Inject constructor(private val service: ApiService) {
    suspend fun getDetail(id: Int) = service.getDetail(id)
}