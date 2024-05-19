package pnj.uts.ti.achmad_husein_rifansyah

import android.os.Bundle
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.*

class TambahDataActivity : AppCompatActivity() {

    lateinit var dbHelper: DatabaseHelper
    lateinit var etNim: EditText
    lateinit var etNama: EditText
    lateinit var etTempatLahir: EditText
    lateinit var etTanggalLahir: EditText
    lateinit var etAlamat: EditText
    lateinit var etAgama: EditText
    lateinit var etNoTelepon: EditText
    lateinit var etTahunMasuk: EditText
    lateinit var etTahunLulus: EditText
    lateinit var etPekerjaan: EditText
    lateinit var etJabatan: EditText
    lateinit var btnSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_tambah_data)

        dbHelper = DatabaseHelper(this)

        etNim = findViewById(R.id.etNim)
        etNama = findViewById(R.id.etNama)
        etTempatLahir = findViewById(R.id.etTempatLahir)
        etTanggalLahir = findViewById(R.id.etTanggalLahir)
        etAlamat = findViewById(R.id.etAlamat)
        etAgama = findViewById(R.id.etAgama)
        etNoTelepon = findViewById(R.id.etNoTelepon)
        etTahunMasuk = findViewById(R.id.etTahunMasuk)
        etTahunLulus = findViewById(R.id.etTahunLulus)
        etPekerjaan = findViewById(R.id.etPekerjaan)
        etJabatan = findViewById(R.id.etJabatan)
        btnSave = findViewById(R.id.btnSave)

        etTanggalLahir.setOnClickListener {
            showDatePickerDialog()
        }

        btnSave.setOnClickListener {
            saveData()
        }
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
            val formattedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
            etTanggalLahir.setText(formattedDate)
        }, year, month, day)
        datePickerDialog.show()
    }

    private fun saveData() {
        val nim = etNim.text.toString()
        val nama = etNama.text.toString()
        val tempatLahir = etTempatLahir.text.toString()
        val tanggalLahir = etTanggalLahir.text.toString()
        val alamat = etAlamat.text.toString()
        val agama = etAgama.text.toString()
        val noTelepon = etNoTelepon.text.toString()
        val tahunMasuk = etTahunMasuk.text.toString()
        val tahunLulus = etTahunLulus.text.toString()
        val pekerjaan = etPekerjaan.text.toString()
        val jabatan = etJabatan.text.toString()

        if (nim.isNotEmpty() && nama.isNotEmpty() && tempatLahir.isNotEmpty() && tanggalLahir.isNotEmpty() &&
            alamat.isNotEmpty() && agama.isNotEmpty() && noTelepon.isNotEmpty() && tahunMasuk.isNotEmpty() &&
            tahunLulus.isNotEmpty() && pekerjaan.isNotEmpty() && jabatan.isNotEmpty()) {

            val result = dbHelper.addAlumni(nim, nama, tempatLahir, tanggalLahir, alamat, agama, noTelepon, tahunMasuk, tahunLulus, pekerjaan, jabatan)

            if (result != (-1).toLong()) {
                Toast.makeText(this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Data gagal disimpan", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Harap isi semua data", Toast.LENGTH_SHORT).show()
        }
    }
}