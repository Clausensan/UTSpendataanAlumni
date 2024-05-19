package pnj.uts.ti.achmad_husein_rifansyah

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import pnj.uts.ti.achmad_husein_rifansyah.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var edituser: EditText
    lateinit var editpassword: EditText
    lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edituser = findViewById(R.id.edituser)
        editpassword = findViewById(R.id.editpassword)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {
            if (edituser.text.toString().equals("ahmadhuseinrifansyah@gmail.com") && editpassword.text.toString().equals("ayamgoreng")) {
                val data = getSharedPreferences("Profile", Context.MODE_PRIVATE)
                val edit = data.edit()
                edit.putString("email", "ahmadhuseinrifansyah@gmail.com")
                edit.putString("nim", "2207411016")
                edit.putString("nama", "Husein")
                edit.putString("kelas", "TI4A")
                edit.putBoolean("IsLogin", true)
                edit.commit()

                val pindah = Intent(applicationContext, home::class.java) // Assuming HomeActivity is the correct class name
                startActivity(pindah)
                finish()
            } else {
                Toast.makeText(applicationContext, "Login Salah", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
