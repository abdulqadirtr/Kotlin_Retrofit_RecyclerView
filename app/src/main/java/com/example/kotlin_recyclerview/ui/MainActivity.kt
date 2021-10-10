package com.example.kotlin_recyclerview.ui
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.kotlin_recyclerview.R
import com.example.kotlin_recyclerview.ui.fragments.ShowValues

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(ShowValues())
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager!!.beginTransaction()
        transaction.replace(R.id.container, fragment, "fragment1")
        transaction.addToBackStack("fragment1")
        transaction.commit()
    }

    override fun onStop() {
        super.onStop()
    }
}