package com.example.daggerhilt.repositoryImp

import com.example.daggerhilt.repository.CoverageRepository
import com.example.models.Coverage
import com.example.web.BaseApiResponse
import com.example.web.NetworkResult
import com.example.web.RemoteDataSource
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ActivityRetainedScoped
class CoverageRepositoryImp @Inject constructor(private val remoteDataSource: RemoteDataSource) : CoverageRepository, BaseApiResponse() {
//    override fun callCoverages() {
//        TODO("Not yet implemented")
//    }

//    override fun getCoverages(): MutableLiveData<List<Coverage>>? {
//        TODO("Not yet implemented")
//    }

    suspend fun getCoverages(): Flow<NetworkResult<List<Coverage>>>{
        return flow<NetworkResult<List<Coverage>>>{
            emit(safeApiCall { remoteDataSource.getCoverages() })
        }.flowOn(Dispatchers.IO)
    }


}