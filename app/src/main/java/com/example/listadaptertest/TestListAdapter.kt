package com.example.listadaptertest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.listadaptertest.databinding.TestViewHolderBinding

class TestListAdapter(private val listener: (Int) -> Unit ) : ListAdapter<ItemWrapper, TestViewHolder>(object : DiffUtil.ItemCallback<ItemWrapper>() {
    override fun areItemsTheSame(oldItem: ItemWrapper, newItem: ItemWrapper): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ItemWrapper, newItem: ItemWrapper): Boolean {
        //TODO: 這邊好像有問題
//        return oldItem.id == newItem.id && oldItem.txtColor == newItem.txtColor
        return false
    }
}) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
        return TestViewHolder(listener, TestViewHolderBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        holder.bind(position, getItem(position))
    }
}