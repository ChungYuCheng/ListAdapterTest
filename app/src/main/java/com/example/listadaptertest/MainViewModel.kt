package com.example.listadaptertest

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val _testList = MutableLiveData<MutableList<ItemWrapper>>()
    val testList: LiveData<MutableList<ItemWrapper>>
        get() = _testList

    private fun getTestList(): MutableList<ItemWrapper> {
        return _testList.value ?: mutableListOf()
    }

    fun initList() {
        _testList.value = mutableListOf(
            ItemWrapper("1", "Jelly Bean", Color.BLACK),
            ItemWrapper("2", "KitKat", Color.BLACK),
            ItemWrapper("3", "Lollipop", Color.BLACK),
            ItemWrapper("4", "MashMallow", Color.BLACK),
        )
    }

    fun addOneItem() {
        _testList.value = getTestList().apply {
            this.add(ItemWrapper("${_testList.value?.size?.plus(1) ?:0 }",
                "測試項目 ${_testList.value?.size?.plus(1) ?:0 }",
                Color.BLACK))
        }
    }

    fun clickItem(position: Int) {
        _testList.value = getTestList().onEachIndexed { index, itemWrapper ->
            itemWrapper.txtColor = when (index) {
                position -> Color.BLUE
                else -> Color.BLACK
            }
        }
    }
}