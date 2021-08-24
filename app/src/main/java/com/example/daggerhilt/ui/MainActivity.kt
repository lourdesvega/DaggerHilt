package com.example.daggerhilt.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daggerhilt.R
import com.example.daggerhilt.databinding.ActivityMainBinding
import com.example.daggerhilt.ui.adapter.CoverageAdapter
import com.example.daggerhilt.viewModel.CoverageVM
import com.example.models.Coverage
import com.example.web.NetworkResult
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mainViewModel by viewModels<CoverageVM>()
    private lateinit var _binding: ActivityMainBinding
    private lateinit var adapterCoverage: CoverageAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        fetchData()

    }

    private fun fetchData(){
        mainViewModel.fetchCoveragesResponse()
        mainViewModel.response.observe(this){ response->
            when(response){
                is NetworkResult.Success->{
                   initRecycler(response.data)
                }
                is NetworkResult.Error -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle(resources.getString(R.string.title))
                        .setMessage(resources.getString(R.string.supporting_text))
                        .setPositiveButton(resources.getString(R.string.accept)) { _, _ ->}
                        .show()
                }
                is NetworkResult.Loading -> {
                    // show a progress bar
                }

            }
        }
    }

    private fun initRecycler(coverages: List<Coverage>?) {
        adapterCoverage = CoverageAdapter(mainViewModel,R.layout.item_coverage)
        _binding.rvAddress.apply {
            adapter = adapterCoverage
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        }
        adapterCoverage.setCoverageList(coverages)
    }
}