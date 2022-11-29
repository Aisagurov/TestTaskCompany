package suvorov.testtaskcompany.data.api

import retrofit2.http.GET
import retrofit2.http.Query
import suvorov.testtaskcompany.data.model.remote.Company
import suvorov.testtaskcompany.data.model.remote.Detail

interface ApiService {
    @GET("test.php")
    suspend fun getCompaniesList(): List<Company>

    @GET("test.php")
    suspend fun getDetail(@Query("id") id: Int): List<Detail>
}