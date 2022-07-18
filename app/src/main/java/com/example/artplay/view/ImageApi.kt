package com.example.artplay.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.artplay.R
import com.example.artplay.adapter.ImageRecyclerAdapter
import com.example.artplay.databinding.FragmentArtListBinding
import com.example.artplay.databinding.FragmentImageApiBinding
import com.example.artplay.viewModel.ArtViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [ImageApi.newInstance] factory method to
 * create an instance of this fragment.
 */
class ImageApi(imageRecyclerAdapter: ImageRecyclerAdapter) : Fragment() {
    private var _binding: FragmentImageApiBinding? = null
    private val binding get() = _binding!!
    private val sharedViewModel: ArtViewModel by activityViewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentImageApiBinding.inflate(inflater, container, false)
        return binding.root
    }


}