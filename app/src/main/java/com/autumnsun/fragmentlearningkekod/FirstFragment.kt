package com.autumnsun.fragmentlearningkekod

import android.animation.Animator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.widget.Toast
import coil.load
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import com.autumnsun.fragmentlearningkekod.databinding.FragmentFirstBinding
import kotlinx.coroutines.delay

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FirstFragment : BaseFragmentApplication() {
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private var isFallowing = false;
    private var likeCounter: Short = 0;
    private var isLiked = false;
    private val bottomSheetFragment = BottomSheetFragment()

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
        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        binding.newsTitle.text =
            "Koronavirüse karşı 3. doz BionTech aşısı ne zaman başlayacak? İşte 'hatırlatma' dozu planı"
        binding.newsAgencyImageView.load("https://seeklogo.com/images/H/haberturk-tv-ve-gazete-logo-E6E5B3CEE6-seeklogo.com.png") {
            crossfade(true)
        }
        binding.newsImageView.load("https://i4.hurimg.com/i/hurriyet/75/750x422/613acf0d4e3fe10e80151830.jpg") {
            crossfade(true)
            crossfade(1000)
        }

        binding.followButton.setOnClickListener {
            if (!isFallowing) {
                binding.followButton.text = "Unfollow"
                isFallowing = true
            } else {
                binding.followButton.text = "Follow"
                isFallowing = false
            }
        }


        binding.likeImgBtn.setOnClickListener {
            if (!isLiked) {
                binding.lottieButtonLiked.visibility = View.VISIBLE
                binding.lottieButtonLiked.playAnimation()
                likeCounter = likeCounter.plus(1).toShort()
                binding.likeCounter.text = likeCounter.toString()

                binding.lottieButtonLiked.addAnimatorListener(
                    object : Animator.AnimatorListener {
                        override fun onAnimationRepeat(animation: Animator?) {
                        }

                        override fun onAnimationEnd(animation: Animator?) {
                            binding.likeImgBtn.setImageResource(R.drawable.ic_like_button_with_color)
                            binding.lottieButtonLiked.visibility = View.GONE
                            isLiked = true;
                        }

                        override fun onAnimationCancel(animation: Animator?) {
                        }

                        override fun onAnimationStart(animation: Animator?) {
                        }

                    }
                )
            } else {
                Toast.makeText(activity, "You already liked :)", Toast.LENGTH_SHORT).show()
            }
        }

        binding.commentChat.setOnClickListener {
            bottomSheetFragment.show(mainActivity.supportFragmentManager, "BottomSheetDialog")
        }


        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirstFragment().apply {
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