package pnj.uts.ti.achmad_husein_rifansyah

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class home : AppCompatActivity() {

    lateinit var bottomNav: BottomNavigationView
    lateinit var bottomNav1: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        loadFragment(HomeFragment())

        bottomNav = findViewById(R.id.bottomNav)
        bottomNav1 = findViewById(R.id.bottomNav1)

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.berita -> {
                    val intent = Intent(this, BeritaActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.profile -> {
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }

        bottomNav1.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.tmbhdata -> {
                    val intent = Intent(this, TambahDataActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.dataalumni -> {
                    val intent = Intent(this, DataAlumniActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.detaildata -> {
                    val intent = Intent(this, DetailDataActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.logout -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }
}
