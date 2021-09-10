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

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val ARG_PARAM3 = "param3"

class FirstFragment : BaseFragmentApplication() {
    private var newsLogo: String? = null
    private var newsTitle: String? = null
    private var newsPhoto: String? = null
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private var isFallowing = false;
    private var likeCounter: Short = 0;
    private var isLiked = false;
    private val bottomSheetFragment = BottomSheetFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            newsLogo = it.getString(ARG_PARAM1)
            newsTitle = it.getString(ARG_PARAM2)
            newsPhoto = it.getString(ARG_PARAM3)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        binding.newsAgencyImageView.load(newsLogo) {
            crossfade(true)
        }
        binding.newsImageView.load(newsPhoto) {
            crossfade(true)
            crossfade(1000)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.newsTitle.text = newsTitle

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

    }

    companion object {

        @JvmStatic
        fun newInstance(newsLogo: String, newsTitle: String, newsPhoto: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, newsLogo)
                    putString(ARG_PARAM2, newsTitle)
                    putString(ARG_PARAM3, newsPhoto)
                }
            }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}