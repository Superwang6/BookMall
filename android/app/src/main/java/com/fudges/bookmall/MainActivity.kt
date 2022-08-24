package com.fudges.bookmall

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.fudges.bookmall.activity.BaseActivity
import com.fudges.bookmall.fragment.BestChooseFragment
import com.fudges.bookmall.fragment.BookShelfFragment
import com.fudges.bookmall.fragment.FindFragment
import com.fudges.bookmall.fragment.MineFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private lateinit var bookShelfFragment: BookShelfFragment
    private lateinit var bestChooseFragment: BestChooseFragment
    private lateinit var findFragment: FindFragment
    private lateinit var mineFragment: MineFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bookShelfFragment = BookShelfFragment()
        bestChooseFragment = BestChooseFragment()
        findFragment = FindFragment()
        mineFragment = MineFragment()
        addFragment(bookShelfFragment,bookShelfFragment.tag.toString())

        bottom_nav_view.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.nav_bookshelf -> {
                    replaceFragment(bookShelfFragment)
                    return@setOnItemSelectedListener true
                }
                R.id.nav_best_choose -> {
                    replaceFragment(bestChooseFragment)
                    return@setOnItemSelectedListener true
                }
                R.id.nav_find -> {
                    replaceFragment(findFragment)
                    return@setOnItemSelectedListener true
                }
                R.id.nav_mine -> {
                    replaceFragment(mineFragment)
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }

    private fun addFragment (fragment: Fragment,tag:String) {
        val fragmentManager = supportFragmentManager
        val beginTransaction = fragmentManager.beginTransaction()
        beginTransaction.add(R.id.fragment_container,fragment,tag)
        beginTransaction.commit()
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManger = supportFragmentManager
        val transaction = fragmentManger.beginTransaction()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.commit()
    }


}
