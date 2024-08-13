package com.example.e2logy_sahil.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e2logy_sahil.R
import com.example.e2logy_sahil.databinding.ActivityMainBinding
import com.example.e2logy_sahil.model.Result
import com.example.e2logy_sahil.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var myAdapter: MyAdapter
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = binding.recyclerView
        val toolbarBack = binding.toolbarBack

        recyclerView.layoutManager = LinearLayoutManager(this)

        mainViewModel = MainViewModel(application)
        mainViewModel.results.observe(this, Observer { results ->
            myAdapter = MyAdapter(this, results, ::onItemClick)
            recyclerView.adapter = myAdapter
        })

        mainViewModel.fetchProducts()

        toolbarBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun onItemClick(result: Result) {
        binding.recyclerView.visibility = View.GONE
        binding.container.visibility = View.VISIBLE
        binding.toolbarBack.visibility = View.VISIBLE

        binding.toolbarTitle.text = result.StoreName

        val fragment = DetailsFragment.newInstance(
            result.Image,
            result.StoreName,
            result.Title,
            result.ValidityStart,
            result.ValidityEnd,
            result.CategName,
            result.Description,
            result.PromoCode
        )
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
            binding.recyclerView.visibility = View.VISIBLE
            binding.container.visibility = View.GONE
            binding.toolbarBack.visibility = View.GONE
            binding.toolbarTitle.text = getString(R.string.offer_list)
        } else {
            super.onBackPressed()
        }
    }
}
