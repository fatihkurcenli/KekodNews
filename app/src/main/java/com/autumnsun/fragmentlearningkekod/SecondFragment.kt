package com.autumnsun.fragmentlearningkekod

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import com.autumnsun.fragmentlearningkekod.databinding.FragmentFirstBinding
import com.autumnsun.fragmentlearningkekod.databinding.FragmentSecondBinding
import androidx.appcompat.app.AppCompatActivity


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class SecondFragment : BaseFragmentApplication() {
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentSecondBinding? = null
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

        _binding = FragmentSecondBinding.inflate(inflater, container, false)

        getPhotos()

        return binding.root
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SecondFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun getPhotos() {
        binding.haberCumhuriyet.load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS1LPY-Ac_LhQIBhufeLWdI_EVogUGCZKzlhA&usqp=CAU") {
            crossfade(true)
            crossfade(1000)
        }
        binding.haber53.load(
            "https://image.shutterstock.com/image-vector/3d-number-53-red-modern-260nw-1914600433.jpg"
        ) {
            crossfade(true)
            crossfade(1000)
        }
        binding.haberHurriyet.load("https://i.superhaber.tv/storage/files/images/2020/02/11/a611d793-1864-4963-a7e8-2c6e8b1fdbf-NpQB.jpg") {
            crossfade(true)
            crossfade(1000)
        }

        binding.haberNtv.load("https://pbs.twimg.com/profile_images/726845908445499396/sfGoyxMP.jpg") {
            crossfade(true)
            crossfade(1000)
        }

        binding.haberTrt.load("https://yt3.ggpht.com/AB76iwyVl_QpzZ-uDx2HiySWaf7w25-nU-LQrrFg4HAJssCXCG6BpMg5V9U8xlId_MYD24AP=s900-c-k-c0x00ffffff-no-rj") {
            crossfade(true)
            crossfade(1000)
        }

        binding.haberTurk.load(
            "https://im.haberturk.com/2016/09/14/ver1473850385/1296680_620x410.jpg"
        ) {
            crossfade(true)
            crossfade(1000)
        }
    }
}