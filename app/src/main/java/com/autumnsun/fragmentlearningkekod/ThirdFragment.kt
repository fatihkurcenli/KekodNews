package com.autumnsun.fragmentlearningkekod

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import com.autumnsun.fragmentlearningkekod.databinding.FragmentThirdBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val ARG_PARAM3 = "param3"
private const val ARG_PARAM4 = "param4"


class ThirdFragment : BaseFragmentApplication() {
    private var title: String? = null
    private var photo1: String? = null
    private var photo2: String? = null
    private var photo3: String? = null
    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            title = it.getString(ARG_PARAM1)
            photo1 = it.getString(ARG_PARAM2)
            photo2 = it.getString(ARG_PARAM3)
            photo3 = it.getString(ARG_PARAM4)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)

        binding.firstView.load(photo1) {
            crossfade(true)
            crossfade(1000)
        }

        binding.secondView.load(photo2) {
            crossfade(true)
            crossfade(1000)
        }

        binding.thirdView.load(photo3) {
            crossfade(true)
            crossfade(1000)
        }

        binding.titleCar.text = title



        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(title: String, photo1: String, photo2: String, photo3: String) =
            ThirdFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, title)
                    putString(ARG_PARAM2, photo1)
                    putString(ARG_PARAM3, photo2)
                    putString(ARG_PARAM4, photo3)
                }
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}