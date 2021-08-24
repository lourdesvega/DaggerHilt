package com.example.daggerhilt.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggerhilt.R
import com.example.daggerhilt.repository.CoverageRepository
import com.example.daggerhilt.repository.DataStoreRepository
import com.example.daggerhilt.repositoryImp.CoverageRepositoryImp
import com.example.daggerhilt.repositoryImp.DataStoreRepositoryImp
import com.example.daggerhilt.ui.adapter.CoverageAdapter
import com.example.models.Coverage
import com.example.web.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoverageVM @Inject constructor(
    private val coverageRepository: CoverageRepositoryImp,

    ): ViewModel() {
    private val _response: MutableLiveData<NetworkResult<List<Coverage>>> = MutableLiveData()
    val response: LiveData<NetworkResult<List<Coverage>>> = _response


    fun fetchCoveragesResponse() = viewModelScope.launch {
        coverageRepository.getCoverages().collect{ values: NetworkResult<List<Coverage>> ->
            _response.value = values
        }
    }


//    fun getAdapter(): CoverageAdapter?{
//        adapterCoverage = CoverageAdapter(this, R.layout.item_coverage)
//
//        return adapterCoverage
//    }
//
//    fun setAdapter(coverage: List<Coverage>?){
//        adapterCoverage?.setCoverageList(coverage)
//        adapterCoverage?.notifyDataSetChanged()
//    }

    fun getCoverageAt(position: Int): Coverage?{
        val coverage: List<Coverage>? = _response.value?.data
        return coverage?.get(position)
    }


}