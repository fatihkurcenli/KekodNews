package com.autumnsun.fragmentlearningkekod

import androidx.fragment.app.Fragment

abstract class BaseFragmentApplication : Fragment(){
    val mainActivity: MainActivity by lazy { activity as MainActivity }
    fun setToolBarTitle(title: String) {
        mainActivity.supportActionBar?.title = title
    }
}