package com.example.artplay.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.artplay.R
import com.example.artplay.adapter.ArtRecyclerAdapter
import com.example.artplay.databinding.FragmentArtListBinding
import com.example.artplay.viewModel.ArtViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [ArtList.newInstance] factory method to
 * create an instance of this fragment.
 */
class ArtList(artRecyclerAdapter: ArtRecyclerAdapter) : Fragment() {
    private var _binding: FragmentArtListBinding? = null
    private val binding get() = _binding!!
    private val sharedViewModel: ArtViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentArtListBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_art_list_to_artplay)
        }
    }


}