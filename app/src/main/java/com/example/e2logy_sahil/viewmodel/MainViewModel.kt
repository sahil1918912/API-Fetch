package com.example.e2logy_sahil.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.e2logy_sahil.model.Products
import com.example.e2logy_sahil.model.Result
import com.example.e2logy_sahil.repository.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = ProductRepository()
    private val _results = MutableLiveData<List<Result>>()
    val results: LiveData<List<Result>> get() = _results

    fun fetchProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            val call = repository.getProducts()

            call.enqueue(object : Callback<Products> {
                override fun onResponse(call: Call<Products>, response: Response<Products>) {
                    if (response.isSuccessful) {
                        _results.postValue(response.body()?.Result)
                    }
                }

                override fun onFailure(call: Call<Products>, t: Throwable) {
                    Toast.makeText(getApplication(), "Error ${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}
