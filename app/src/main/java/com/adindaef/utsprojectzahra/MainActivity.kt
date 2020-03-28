package com.adindaef.utsprojectzahra

import android.content.Intent
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.MenuItem
import androidx.core.view.GravityCompat
import com.adindaef.utsprojectzahra.fragment.NowFragment
import com.adindaef.utsprojectzahra.fragment.ProfileFragment
import com.adindaef.utsprojectzahra.fragment.RecommendedFragment
import com.adindaef.utsprojectzahra.fragment.SoonFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_recommended,
                R.id.nav_now,
                R.id.nav_soon,
                R.id.nav_profile
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        navView.setNavigationItemSelectedListener(this)
    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.main, menu)
//        return true
//    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when (p0.itemId) {
            R.id.nav_recommended -> {
                val i = RecommendedFragment()
                supportFragmentManager.beginTransaction().replace(R.id.container, i).commit()
                supportFragmentManager.popBackStack()
                toolbar.title = "Recommended Movie"
            }

            R.id.nav_now -> {
                val i = NowFragment()
                supportFragmentManager.beginTransaction().replace(R.id.container, i).commit()
                supportFragmentManager.popBackStack()
                toolbar.title = "Now Showing"
            }

            R.id.nav_soon -> {
                val i = SoonFragment()
                supportFragmentManager.beginTransaction().replace(R.id.container, i).commit()
                supportFragmentManager.popBackStack()
                toolbar.title = "Coming Soon"
            }

            R.id.nav_profile -> {
                val i = ProfileFragment()
                supportFragmentManager.beginTransaction().replace(R.id.container, i).commit()
                supportFragmentManager.popBackStack()
                toolbar.title = "My Profile"
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
