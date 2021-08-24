package com.example.daggerhilt.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.example.daggerhilt.viewModel.CoverageVM
import com.example.models.Coverage
import javax.inject.Singleton


@Singleton
class CoverageAdapter (var coverageViewModel: CoverageVM, var resource: Int) : RecyclerView.Adapter<CoverageAdapter.ViewHolder>(){

    var coverage: List<Coverage>? = null

    fun setCoverageList(coverage: List<Coverage>?){
        this.coverage = coverage
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        var vBind : ViewDataBinding = DataBindingUtil.inflate(layoutInflater, viewType, parent, false)

        return ViewHolder(vBind, parent.context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setDataCoverage(coverageViewModel, position)

    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdPosition(position)
    }

    fun getLayoutIdPosition(position: Int): Int{
        return resource
    }


    override fun getItemCount(): Int {
        return if(coverage == null) 0 else coverage!!.size
    }

    inner class ViewHolder(vBind: ViewDataBinding, val context: Context): RecyclerView.ViewHolder(vBind.root){
        private var binding: ViewDataBinding? = null
        init {
            this.binding = vBind
        }

        fun setDataCoverage(coverageViewModel: CoverageVM, position: Int){
            binding?.setVariable(BR.model, coverageViewModel)
            binding?.setVariable(BR.position, position)



            binding?.executePendingBindings()
        }



    }
}
