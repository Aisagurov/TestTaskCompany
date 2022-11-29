package suvorov.testtaskcompany.data.repository.list

import suvorov.testtaskcompany.data.mapper.CompanyMapper.map
import suvorov.testtaskcompany.domain.ListRepository
import javax.inject.Inject

class ListRepositoryImpl @Inject constructor(
    private val remoteDataSource: ListRemoteDataSource,
    private val localDataSource: ListLocalDataSource
): ListRepository {

    override val companiesListFromDatabase = localDataSource.companiesList

    override suspend fun getCompaniesListFromApi() {
        val companies = remoteDataSource.getCompaniesList().map { map(it) }
        localDataSource.insertCompaniesListIntoDatabase(companies)
    }
}