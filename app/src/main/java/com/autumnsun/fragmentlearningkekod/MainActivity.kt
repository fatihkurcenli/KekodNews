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

    private val haberTurkLogo =
        "https://seeklogo.com/images/H/haberturk-tv-ve-gazete-logo-E6E5B3CEE6-seeklogo.com.png"
    private lateinit var binding: ActivityMainBinding
    private val firstFragment = FirstFragment.newInstance(
        haberTurkLogo,
        "Koronavirüse karşı 3. doz BionTech aşısı ne zaman başlayacak? İşte 'hatırlatma' dozu planı",
        "https://i4.hurimg.com/i/hurriyet/75/750x422/613acf0d4e3fe10e80151830.jpg"
    )
    private val firstFragment2 = FirstFragment.newInstance(
        haberTurkLogo,
        "Son dakika: Lionel Messi'nin gözyaşları! Pele'nin rekorunu kırıp tarihe geçtikten sonra...",
        "https://i4.hurimg.com/i/hurriyet/75/750x422/613b0ce64e3fe10e80151c68.jpg"
    )
    private val firstFragment3 = FirstFragment.newInstance(
        haberTurkLogo,
        "Suyumuz ne zaman bitecek? Tabloyu değiştiremezsek tarih belli...",
        "https://i4.hurimg.com/i/hurriyet/75/750x422/6129f9a74e3fe11814ddf81a.jpg"
    )
    private val secondFragment = SecondFragment()
    private val thirdFragment = ThirdFragment.newInstance(
        "Lamborghini, 8 Temmuz'da bir tanıtım yapacak\n" +
                "Lamborghini, büyük merak uyandırdı.",
        "https://www.yenikoymotors.com/img/araclar/1160/k/119.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a1/2011-03-04_Autosalon_Genf_1230.JPG/1200px-2011-03-04_Autosalon_Genf_1230.JPG",
        "https://www.sofauto.bg/uploads/import/Pic_XL/Img632853.jpg"
    )

    private val thirdFragment2 = ThirdFragment.newInstance(
        "Bugatti Hangi Ülkenin Markası Ve Nerede Üretiliyor? Bugatti Ne Zaman Kuruldu, Sahibi Kim Ve Kısaca Tarihçesi",
        "https://cdn.motor1.com/images/mgl/zMVLE/s6/bugatti-divo.jpg",
        "https://i20.haber7.net/resize/1240x720//haber/haber7/photos/2020/50/bugatti_chiron_modellerinde_dikkat_ceken_ariza_1607779157_7062.jpg",
        "https://iaahbr.tmgrup.com.tr/db2e74/806/378/0/178/800/553?u=https://iahbr.tmgrup.com.tr/2018/05/29/1527588840450.jpg"
    )
    private lateinit var fragmentFour: FourFragment
    private lateinit var fragmentThird: FourFragment
    private lateinit var fragmentFive: FourFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        settingsTitle()
        var firstDetailsNews: String = getString(R.string.detail_news_haber)
        var secondDetailNews: String = getString(R.string.detail_news_haber_second)
        var thirdDetailNews: String = getString(R.string.detail_news_water)
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()

        transaction.add(R.id.fragmentFirst, firstFragment)
        transaction.add(R.id.fragmentSecond, secondFragment)
        transaction.add(R.id.fragmentThird, firstFragment2)
        transaction.add(R.id.fragmentFour, thirdFragment)
        transaction.add(R.id.fragmentFive, firstFragment3)
        transaction.add(R.id.fragmentSix, thirdFragment2)
        transaction.commit()
        binding.fragmentFirst.setOnClickListener {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportFragmentManager.beginTransaction().remove(firstFragment).commit()
            supportFragmentManager.beginTransaction().remove(firstFragment2).commit()
            supportFragmentManager.beginTransaction().remove(secondFragment).commit()
            supportFragmentManager.beginTransaction().remove(thirdFragment).commit()
            supportFragmentManager.beginTransaction().remove(thirdFragment2).commit()
            supportFragmentManager.beginTransaction().remove(firstFragment3).commit()
            fragmentFour = FourFragment.newInstance(
                "https://i4.hurimg.com/i/hurriyet/75/750x422/613acf0d4e3fe10e80151830.jpg",
                "Koronavirüse karşı 3. doz BionTech aşısı ne zaman başlayacak? İşte 'hatırlatma' dozu planı",
                firstDetailsNews,
                "Koronavirüs Haberi"
            )
            supportFragmentManager.beginTransaction().add(R.id.detailFrameLayout, fragmentFour)
                .commit()
        }

        binding.fragmentThird.setOnClickListener {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportFragmentManager.beginTransaction().remove(firstFragment).commit()
            supportFragmentManager.beginTransaction().remove(firstFragment2).commit()
            supportFragmentManager.beginTransaction().remove(secondFragment).commit()
            supportFragmentManager.beginTransaction().remove(thirdFragment).commit()
            supportFragmentManager.beginTransaction().remove(thirdFragment2).commit()
            supportFragmentManager.beginTransaction().remove(firstFragment3).commit()
            fragmentThird = FourFragment.newInstance(
                "https://i4.hurimg.com/i/hurriyet/75/750x422/613b0ce64e3fe10e80151c68.jpg",
                "Son dakika: Lionel Messi'nin gözyaşları! Pele'nin rekorunu kırıp tarihe geçtikten sonra...",
                secondDetailNews,
                "Ankara Messi"
            )
            supportFragmentManager.beginTransaction().add(R.id.detailFrameLayout, fragmentThird)
                .commit()
        }

        binding.fragmentFive.setOnClickListener {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportFragmentManager.beginTransaction().remove(firstFragment).commit()
            supportFragmentManager.beginTransaction().remove(firstFragment2).commit()
            supportFragmentManager.beginTransaction().remove(secondFragment).commit()
            supportFragmentManager.beginTransaction().remove(thirdFragment).commit()
            supportFragmentManager.beginTransaction().remove(thirdFragment2).commit()
            supportFragmentManager.beginTransaction().remove(firstFragment3).commit()
            fragmentFive = FourFragment.newInstance(
                "https://i4.hurimg.com/i/hurriyet/75/750x422/6129f9a74e3fe11814ddf81a.jpg",
                "Suyumuz ne zaman bitecek? Tabloyu değiştiremezsek tarih belli...",
                thirdDetailNews,
                "Susuzluk Problemi"
            )
            supportFragmentManager.beginTransaction().add(R.id.detailFrameLayout, fragmentFive)
                .commit()
        }

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                settingsTitle()
                supportActionBar?.setDisplayHomeAsUpEnabled(false)
                if (this::fragmentFour.isInitialized) {
                    supportFragmentManager.beginTransaction().remove(fragmentFour)
                        .commit()
                }
                if (this::fragmentThird.isInitialized) {
                    supportFragmentManager.beginTransaction().remove(fragmentThird)
                        .commit()
                }
                if (this::fragmentFive.isInitialized) {
                    supportFragmentManager.beginTransaction().remove(fragmentFive)
                        .commit()
                }
                supportFragmentManager.beginTransaction().add(R.id.fragmentFirst, firstFragment)
                    .commit()
                supportFragmentManager.beginTransaction().add(R.id.fragmentSecond, secondFragment)
                    .commit()
                supportFragmentManager.beginTransaction().add(R.id.fragmentThird, firstFragment2)
                    .commit()
                supportFragmentManager.beginTransaction().add(R.id.fragmentFour, thirdFragment)
                    .commit()
                supportFragmentManager.beginTransaction().add(R.id.fragmentFive, firstFragment3)
                    .commit()
                supportFragmentManager.beginTransaction().add(R.id.fragmentSix, thirdFragment2)
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
