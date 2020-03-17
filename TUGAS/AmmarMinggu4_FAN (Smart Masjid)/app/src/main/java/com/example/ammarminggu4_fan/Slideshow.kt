package com.example.ammarminggu4_fan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.txt1
import kotlinx.android.synthetic.main.activity_main.txt2
import kotlinx.android.synthetic.main.activity_pengumuman.*
import kotlinx.android.synthetic.main.activity_slideshow.*
import org.json.JSONArray
import org.json.JSONObject

class Slideshow : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slideshow)

        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView
        recyclerView.layoutManager= LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val users=ArrayList<DataSS>()

//        getdariserver()

        val context = this

        btnBack_home5.setOnClickListener {
            var intent = Intent(context,Home::class.java)
            startActivity(intent)
            finish()
        }

        AndroidNetworking.get("https://smartmasjid.000webhostapp.com/cobarepo-master/contoh_slideshow_json.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("judul_slideshow"))

                        // txt1.setText(jsonObject.optString("shubuh"))
                        var isi1=jsonObject.optString("judul_slideshow").toString()
                        var isi2=jsonObject.optString("url_slideshow").toString()

                        users.add(DataSS("$isi1", "$isi2"))
                    }

                    val adapter=CustomAdapter(users)
                    recyclerView.adapter=adapter
                }

                override fun onError(anError: ANError) {
                    Log.i("_err", anError.toString())
                }
            })

//        btnUpdate_slideshow.setOnClickListener {
//
//            var data_judulslideshow :String = edit_judulslideshow.text.toString()
//            var data_urlslideshow :String = edit_urlslideshow.text.toString()
//
//            postkeserver(data_judulslideshow,data_urlslideshow)
//
//            var intent = Intent(context,Home::class.java)
//            startActivity(intent)
//            finish()
//        }
    }

//    fun getdariserver(){
//
//        AndroidNetworking.get("https://smartmasjid.000webhostapp.com/cobarepo-master/contoh_slideshow_json.php")
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .getAsJSONObject(object : JSONObjectRequestListener {
//                override fun onResponse(response: JSONObject) {
//                    Log.e("_kotlinResponse", response.toString())
//
//                    val jsonArray = response.getJSONArray("result")
//                    for (i in 0 until jsonArray.length()) {
//                        val jsonObject = jsonArray.getJSONObject(i)
//                        Log.e("_kotlinTitle", jsonObject.optString("judul_slideshow"))
//
//                        txt1.setText(jsonObject.optString("judul_slideshow"))
//                        txt2.setText(jsonObject.optString("url_slideshow"))
//
//                    }
//                }
//
//                override fun onError(anError: ANError?) {
//                    Log.i("_err", anError.toString())
//                }
//            })
//
//    }

//    fun postkeserver(data1:String,data2:String)
//    {
//        AndroidNetworking.post("https://smartmasjid.000webhostapp.com/cobarepo-master/proses_slideshow.php")
//            .addBodyParameter("judul_slideshow", data1)
//            .addBodyParameter("url_slideshow", data2)
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .getAsJSONArray(object : JSONArrayRequestListener {
//                override fun onResponse(response: JSONArray?) {
//                }
//
//                override fun onError(anError: ANError?) {
//                }
//            })
//    }
}
