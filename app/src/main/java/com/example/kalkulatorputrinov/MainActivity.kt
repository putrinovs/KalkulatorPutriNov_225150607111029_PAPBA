package com.example.kalkulatorputrinov
//putrinov
//225150607111029
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var edtAngka1: EditText
    private lateinit var edtAngka2: EditText
    private lateinit var txtHasil: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        edtAngka1 = findViewById(R.id.edt_angka1)
        edtAngka2 = findViewById(R.id.edt_angka2)
        txtHasil = findViewById(R.id.txt_hasil)


        findViewById<Button>(R.id.btn_tambah).setOnClickListener { tambah() }
        findViewById<Button>(R.id.btn_kurang).setOnClickListener { kurang() }
        findViewById<Button>(R.id.btn_kali).setOnClickListener { kali() }
        findViewById<Button>(R.id.btn_bagi).setOnClickListener { bagi() }
        findViewById<Button>(R.id.btn_modulus).setOnClickListener { modulus() }
        findViewById<Button>(R.id.btn_clear).setOnClickListener { clear() }
    }


    private fun getInput(): Pair<Double?, Double?> {
        val angka1 = edtAngka1.text.toString()
        val angka2 = edtAngka2.text.toString()

        val num1 = if (!TextUtils.isEmpty(angka1)) angka1.toDouble() else null
        val num2 = if (!TextUtils.isEmpty(angka2)) angka2.toDouble() else null

        return Pair(num1, num2)
    }


    private fun tambah() {
        val (num1, num2) = getInput()
        if (num1 != null && num2 != null) {
            val hasil = num1 + num2
            txtHasil.text = hasil.toString()
        } else {
            txtHasil.text = "Input tidak valid"
        }
    }


    private fun kurang() {
        val (num1, num2) = getInput()
        if (num1 != null && num2 != null) {
            val hasil = num1 - num2
            txtHasil.text = hasil.toString()
        } else {
            txtHasil.text = "Input tidak valid"
        }
    }

    private fun kali() {
        val (num1, num2) = getInput()
        if (num1 != null && num2 != null) {
            val hasil = num1 * num2
            txtHasil.text = hasil.toString()
        } else {
            txtHasil.text = "Input tidak valid"
        }
    }


    private fun bagi() {
        val (num1, num2) = getInput()
        if (num1 != null && num2 != null) {
            if (num2 != 0.0) {
                val hasil = num1 / num2
                txtHasil.text = hasil.toString()
            } else {
                txtHasil.text = "Tidak bisa dibagi dengan 0"
            }
        } else {
            txtHasil.text = "Input tidak valid"
        }
    }


    private fun modulus() {
        val (num1, num2) = getInput()
        if (num1 != null && num2 != null) {
            val hasil = num1 % num2
            txtHasil.text = hasil.toString()
        } else {
            txtHasil.text = "Input tidak valid"
        }
    }


    private fun clear() {
        edtAngka1.text.clear()
        edtAngka2.text.clear()
        txtHasil.text = "0"
    }
}
