package pnj.uts.ti.achmad_husein_rifansyah

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "alumni.db"
        private const val DATABASE_VERSION = 1

        private const val TABLE_NAME = "alumni"
        private const val COLUMN_ID = "id"
        private const val COLUMN_NIM = "nim"
        private const val COLUMN_NAMA = "nama"
        private const val COLUMN_TEMPAT_LAHIR = "tempat_lahir"
        private const val COLUMN_TANGGAL_LAHIR = "tanggal_lahir"
        private const val COLUMN_ALAMAT = "alamat"
        private const val COLUMN_AGAMA = "agama"
        private const val COLUMN_NO_TELEPON = "no_telepon"
        private const val COLUMN_TAHUN_MASUK = "tahun_masuk"
        private const val COLUMN_TAHUN_LULUS = "tahun_lulus"
        private const val COLUMN_PEKERJAAN = "pekerjaan"
        private const val COLUMN_JABATAN = "jabatan"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = ("CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NIM + " TEXT,"
                + COLUMN_NAMA + " TEXT,"
                + COLUMN_TEMPAT_LAHIR + " TEXT,"
                + COLUMN_TANGGAL_LAHIR + " TEXT,"
                + COLUMN_ALAMAT + " TEXT,"
                + COLUMN_AGAMA + " TEXT,"
                + COLUMN_NO_TELEPON + " TEXT,"
                + COLUMN_TAHUN_MASUK + " TEXT,"
                + COLUMN_TAHUN_LULUS + " TEXT,"
                + COLUMN_PEKERJAAN + " TEXT,"
                + COLUMN_JABATAN + " TEXT" + ")")
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addAlumni(nim: String, nama: String, tempatLahir: String, tanggalLahir: String, alamat: String,
                  agama: String, noTelepon: String, tahunMasuk: String, tahunLulus: String, pekerjaan: String, jabatan: String): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COLUMN_NIM, nim)
        contentValues.put(COLUMN_NAMA, nama)
        contentValues.put(COLUMN_TEMPAT_LAHIR, tempatLahir)
        contentValues.put(COLUMN_TANGGAL_LAHIR, tanggalLahir)
        contentValues.put(COLUMN_ALAMAT, alamat)
        contentValues.put(COLUMN_AGAMA, agama)
        contentValues.put(COLUMN_NO_TELEPON, noTelepon)
        contentValues.put(COLUMN_TAHUN_MASUK, tahunMasuk)
        contentValues.put(COLUMN_TAHUN_LULUS, tahunLulus)
        contentValues.put(COLUMN_PEKERJAAN, pekerjaan)
        contentValues.put(COLUMN_JABATAN, jabatan)

        val success = db.insert(TABLE_NAME, null, contentValues)
        db.close()
        return success
    }
}
