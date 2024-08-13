package com.example.e2logy_sahil.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.e2logy_sahil.R

class DetailsFragment : Fragment() {

    private var imageUrl: String? = null
    private var storeName: String? = null
    private var title: String? = null
    private var validityStart: String? = null
    private var validityEnd: String? = null
    private var categoryName: String? = null
    private var description: String? = null
    private var promoCode: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            imageUrl = it.getString("imageUrl")
            storeName = it.getString("storeName")
            title = it.getString("title")
            validityStart = it.getString("validityStart")
            validityEnd = it.getString("validityEnd")
            categoryName = it.getString("categoryName")
            description = it.getString("description")
            promoCode = it.getString("promoCode")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Find views in the fragment
        val imgDetails: ImageView = view.findViewById(R.id.imgDetails)
        val txtTitle: TextView = view.findViewById(R.id.titles)
        val txtValidityStart: TextView = view.findViewById(R.id.validityStart)
        val txtValidityEnd: TextView = view.findViewById(R.id.validityEnd)
        val txtCategoryName: TextView = view.findViewById(R.id.categoryName)
        val txtDescription: TextView = view.findViewById(R.id.description)
        val txtPromoCode: TextView = view.findViewById(R.id.promoCode)


        (activity as? MainActivity)?.supportActionBar?.title = storeName

        // Load image with Glide
        imageUrl?.let {
            Glide.with(requireContext()).load(it).into(imgDetails)
        }

        // Set text values to TextViews
        title?.let { txtTitle.text = it }
        validityStart?.let { txtValidityStart.text = it }
        validityEnd?.let { txtValidityEnd.text = it }
        categoryName?.let { txtCategoryName.text = it }
        description?.let { txtDescription.text = it }
        promoCode?.let { txtPromoCode.text = it }
    }

    companion object {
        // Create a new instance of DetailsFragment with passed arguments
        fun newInstance(
            imageUrl: String,
            storeName: String,
            title: String,
            validityStart: String,
            validityEnd: String,
            categoryName: String,
            description: String,
            promoCode: String
        ) =
            DetailsFragment().apply {
                arguments = Bundle().apply {
                    putString("imageUrl", imageUrl)
                    putString("storeName", storeName)
                    putString("title", title)
                    putString("validityStart", validityStart)
                    putString("validityEnd", validityEnd)
                    putString("categoryName", categoryName)
                    putString("description", description)
                    putString("promoCode", promoCode)
                }
            }
    }
}
