package com.autumnsun.fragmentlearningkekod

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentTransaction
import com.autumnsun.fragmentlearningkekod.databinding.ActivityMainBinding
import androidx.annotation.NonNull


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val firstFragment = FirstFragment.newInstance("fatih", "senamı çok seviyo")
    private val firstFragment2 = FirstFragment()
    private val secondFragment = SecondFragment()
    private val fourFragment = FourFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        settingsTitle()
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()

        transaction.add(R.id.fragmentFirst, firstFragment)
        transaction.add(R.id.fragmentSecond, secondFragment)
        transaction.add(R.id.fragmentThird, firstFragment2)
//        transaction.add(R.id.fragmentSecond, secondFragment)
//        transaction.add(R.id.fragmentThird, thirdFragment)
        transaction.commit()
        binding.fragmentFirst.setOnClickListener {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            Toast.makeText(this, "first click event", Toast.LENGTH_SHORT).show()
//            transaction.replace(R.id.fragmentSecond,secondFragment).addToBackStack(null).commit()
            supportFragmentManager.beginTransaction().remove(firstFragment).commit()
            supportFragmentManager.beginTransaction().remove(firstFragment2).commit()
            supportFragmentManager.beginTransaction().remove(secondFragment).commit()
            supportFragmentManager.beginTransaction().add(R.id.detailFrameLayout, fourFragment)
                .commit()
        }

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                settingsTitle()
                supportActionBar?.setDisplayHomeAsUpEnabled(false)
                supportFragmentManager.beginTransaction().remove(fourFragment)
                    .commit()
                supportFragmentManager.beginTransaction().add(R.id.fragmentSecond, firstFragment)
                    .commit()
                supportFragmentManager.beginTransaction().add(R.id.fragmentFirst, firstFragment2)
                    .commit()

                supportFragmentManager.beginTransaction().add(R.id.fragmentThird, secondFragment)
                    .commit()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }


    private fun settingsTitle() {
        //@Nullable !! return olarak ActionBar dönmekte !
        supportActionBar?.let {
            it.title = "Kekod Haber"

        }
    }
}
