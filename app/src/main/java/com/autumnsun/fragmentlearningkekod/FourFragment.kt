package com.autumnsun.fragmentlearningkekod

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import com.autumnsun.fragmentlearningkekod.databinding.FragmentFourBinding
import com.autumnsun.fragmentlearningkekod.databinding.FragmentSecondBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val ARG_PARAM3 = "param3"
private const val ARG_PARAM4 = "param4"

class FourFragment : BaseFragmentApplication() {
    private var imagePhoto: String? = null
    private var titleText: String? = null
    private var descriptionText: String? = null
    private var titleActionBar: String? = null
    private var _binding: FragmentFourBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            imagePhoto = it.getString(ARG_PARAM1)
            titleText = it.getString(ARG_PARAM2)
            descriptionText = it.getString(ARG_PARAM3)
            titleActionBar = it.getString(ARG_PARAM4)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFourBinding.inflate(inflater, container, false)

        binding.detailNewsFourFragment.load(imagePhoto) {
            crossfade(true)
            crossfade(1000)
        }

        binding.detailNewsTitleFourFragment.text=descriptionText


        titleActionBar?.let { setToolBarTitle(it) }


        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(
            imagePhoto: String,
            titleText: String,
            descriptionText: String,
            titleActionBar: String
        ) =
            FourFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, imagePhoto)
                    putString(ARG_PARAM2, titleText)
                    putString(ARG_PARAM3, descriptionText)
                    putString(ARG_PARAM4, titleActionBar)
                }
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}