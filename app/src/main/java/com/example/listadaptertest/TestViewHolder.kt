package com.example.listadaptertest

import androidx.recyclerview.widget.RecyclerView
import com.example.listadaptertest.databinding.TestViewHolderBinding

class TestViewHolder(private val listener: (Int) -> Unit, private val binding: TestViewHolderBinding)
    : RecyclerView.ViewHolder(binding.root) {
    fun bind(position: Int, item: ItemWrapper) {

        with(binding) {
            clItem.setOnClickListener { listener.invoke(position) }
            tv1.text = item.id
            tv2.apply {
                text = item.name
                setTextColor(item.txtColor ?: R.color.black)
            }
        }
    }
}