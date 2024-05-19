package pnj.uts.ti.achmad_husein_rifansyah

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailNewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_news)

        val newsContent = intent.getStringExtra("news_content")
        val contentTextView = findViewById<TextView>(R.id.news_content)
        contentTextView.text = newsContent
    }
}
