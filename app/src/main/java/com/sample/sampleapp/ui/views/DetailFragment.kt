package com.sample.sampleapp.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import coil.load
import com.sample.sampleapp.R
import com.sample.sampleapp.databinding.FragmentDetailBinding
import com.sample.sampleapp.ui.viewmodel.MainViewModel
import com.sample.sampleapp.utility.getName

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.characterDetails.observe(this.viewLifecycleOwner) {
            binding.tvTitle.text = getName(it.firstURL)
            binding.tvDetail.text = it.text
            if (it.icon.uRL.isNotBlank()) {
                val url = "https://i.duckduckgo.com${it.icon.uRL}"
                binding.charImage.load(url)
            } else {
                binding.charImage.load(R.drawable.no_image_icon)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.characterUrl = ""
        _binding = null
    }
}