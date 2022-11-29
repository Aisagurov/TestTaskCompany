package suvorov.testtaskcompany.data.repository.detail

import suvorov.testtaskcompany.data.mapper.DetailMapper.map
import suvorov.testtaskcompany.domain.DetailRepository
import javax.inject.Inject

class DetailRepositoryImpl @Inject constructor(
    private val remoteDataSource: DetailRemoteDataSource,
    private val localDataSource: DetailLocalDataSource
): DetailRepository {

    override fun detailById(id: String) = localDataSource.detailById(id)

    override suspend fun getDetailFromApi(id: Int) {
        val detail = map(remoteDataSource.getDetail(id))
        localDataSource.insertDetailIntoDatabase(detail)
    }
}