package com.example.artplay.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.RequestManager
import com.example.artplay.R
import com.example.artplay.databinding.FragmentArtListBinding
import com.example.artplay.databinding.FragmentArtplayBinding
import com.example.artplay.viewModel.ArtViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [ArtPlay.newInstance] factory method to
 * create an instance of this fragment.
 */
class ArtPlay(glide: RequestManager) : Fragment() {
    private var _binding: FragmentArtplayBinding? = null
    private val binding get() = _binding!!
    private val sharedViewModel: ArtViewModel by activityViewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentArtplayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.artImageView.setOnClickListener {
            findNavController().navigate(R.id.action_artplay_to_imageApi)
        }
        val callback = object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                findNavController().popBackStack()
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(callback)

    }
}