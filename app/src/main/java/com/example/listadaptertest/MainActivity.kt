package com.example.listadaptertest

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listadaptertest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val listener = object : OnClickCallBack {
        override fun onClickItem(index: Int) {
            mainVm.clickItem(index)
        }
    }
    private val testAdapter by lazy { TestListAdapter(listener) }
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val mainVm: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        with(binding) {
            rvList.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = testAdapter
            }

            btnAddOne.setOnClickListener {
                mainVm.addOneItem()
            }
        }
        mainVm.initList()
        setContentView(binding.root)

        observeData()
    }

    private fun observeData() {
        mainVm.testList.observe(this, {
            testAdapter.submitList(it.toMutableList())
        })
    }
}