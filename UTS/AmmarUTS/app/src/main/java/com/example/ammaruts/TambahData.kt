package com.example.ammaruts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import kotlinx.android.synthetic.main.activity_tambah_data.*
import org.json.JSONArray

class TambahData : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_data)

        val context = this

        btnTambah.setOnClickListener {
            var data_nama: String = editNama.text.toString()
            var data_ttl: String = editTTL.text.toString()
            var data_hp: String = editHP.text.toString()
            var data_alamat: String = editAlamat.text.toString()

            postkeserver(data_nama,data_ttl,data_hp,data_alamat)

        }

        btnBackHome2.setOnClickListener {
            var intent = Intent(context,Dashboard::class.java)
            startActivity(intent)
            finish()
        }

    }

    fun postkeserver(data1:String, data2:String, data3:String, data4:String){
        AndroidNetworking.post("http://192.168.1.88/project-uts/proses-penduduk.php")
            .addBodyParameter("nama_penduduk", data1)
            .addBodyParameter("ttl_penduduk", data2)
            .addBodyParameter("hp_penduduk", data3)
            .addBodyParameter("alamat_mahasiswa", data4)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONArray(object : JSONArrayRequestListener {
                override fun onResponse(response: JSONArray?) {
                }

                override fun onError(anError: ANError?) {
                }
            })
    }
}
