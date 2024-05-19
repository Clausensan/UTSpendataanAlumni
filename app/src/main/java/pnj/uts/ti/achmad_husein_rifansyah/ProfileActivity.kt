package pnj.uts.ti.achmad_husein_rifansyah

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

class ProfileActivity : ComponentActivity() {

    lateinit var btnout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_profile)

        val data = getSharedPreferences("Profile", Context.MODE_PRIVATE)

        val email = data.getString("email", "No email")
        val nim = data.getString("nim", "No NIM")
        val nama = data.getString("nama", "No name")
        val kelas = data.getString("kelas", "No class")

        val profileEmail = findViewById<TextView>(R.id.profile_email)
        val profileNim = findViewById<TextView>(R.id.profile_nim)
        val profileNama = findViewById<TextView>(R.id.profile_nama)
        val profileKelas = findViewById<TextView>(R.id.profile_kelas)

        profileEmail.text = "Email: $email"
        profileNim.text = "NIM: $nim"
        profileNama.text = "Nama: $nama"
        profileKelas.text = "Kelas: $kelas"

        btnout = findViewById(R.id.btnout)

        btnout.setOnClickListener() {
        val intentDestination= Intent (this@ProfileActivity, HomeFragment::class.java)
        startActivity(intentDestination)
        }
    }
}