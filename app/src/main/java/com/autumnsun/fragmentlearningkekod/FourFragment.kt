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

class FourFragment : BaseFragmentApplication() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentFourBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFourBinding.inflate(inflater, container, false)

        binding.detailNewsFourFragment.load("https://i4.hurimg.com/i/hurriyet/75/750x422/613acf0d4e3fe10e80151830.jpg") {
            crossfade(true)
            crossfade(1000)
        }

        setToolBarTitle("Koronavirüs")


        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FourFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}