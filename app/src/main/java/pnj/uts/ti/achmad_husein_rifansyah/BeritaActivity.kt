package pnj.uts.ti.achmad_husein_rifansyah

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class BeritaActivity : AppCompatActivity() {

    lateinit var btnout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_berita)

        btnout = findViewById(R.id.btnout)
        btnout.setOnClickListener() {
            val intentDestination = Intent(this@BeritaActivity, HomeFragment::class.java)
            startActivity(intentDestination)
        }
        // Dummy data for the ListView
        val newsData = listOf(
            "Berita 1: Konten Berita 1 dari detik.com",
            "Berita 2: Konten Berita 2 dari detik.com",
            "Berita 3: Konten Berita 3 dari detik.com",
            "Berita 4: Konten Berita 4 dari detik.com",
            "Berita 5: Konten Berita 5 dari detik.com",
            "Berita 6: Konten Berita 6 dari detik.com",
            "Berita 7: Konten Berita 7 dari detik.com",
            "Berita 8: Konten Berita 8 dari detik.com",
            "Berita 9: Konten Berita 9 dari detik.com",
            "Berita 10: Konten Berita 10 dari detik.com"
        )

        // Find the ListView by its ID
        val listView = findViewById<ListView>(R.id.listview)

        // Create an ArrayAdapter to bind the data to the ListView
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, newsData)

        // Set the adapter to the ListView
        listView.adapter = adapter

        // Handle item clicks
        listView.setOnItemClickListener { parent, view, position, id ->
            val newsContent = newsData[position]
            val detailIntent = Intent(this, DetailNewsActivity::class.java)
            detailIntent.putExtra("news_content", newsContent)
            startActivity(detailIntent)

        }
    }
}