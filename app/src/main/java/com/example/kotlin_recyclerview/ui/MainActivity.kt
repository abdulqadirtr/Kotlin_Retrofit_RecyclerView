package com.example.kotlin_recyclerview.ui
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.kotlin_recyclerview.R
import com.example.kotlin_recyclerview.ui.fragments.PostsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        window.setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN );
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(PostsFragment())
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager!!.beginTransaction()
        transaction.replace(R.id.container, fragment, "fragment1")
        transaction.addToBackStack("fragment1")
        transaction.commit()
    }
}