package com.example.dailypaper

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import android.widget.Toolbar
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.dailypaper.databinding.ActivityMainBinding
import androidx.databinding.DataBindingUtil
import com.example.dailypaper.viewmodel.TheViewModel
import com.google.android.material.navigation.NavigationView
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private val mBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
        // 获取当前日期并将其格式化为所需的字符串格式
        val sdf = SimpleDateFormat("MM月dd日", Locale.getDefault())
        val currentDate = sdf.format(Date())

// 找到 Toolbar 中的 Button 并设置当前日期
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val dateBtn = toolbar.findViewById<Button>(R.id.date_btn)
        dateBtn.text = currentDate
        setSupportActionBar(toolbar)

    }


}
