package com.example.ammaruts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter (val userList: ArrayList<Data>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val user: Data=userList[position]
        holder?.textViewNama?.text = user.nama
        holder?.textViewTtl?.text = user.ttl
        holder?.textViewHp?.text = user.hp
        holder?.textViewAlamat?.text = user.alamat

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v= LayoutInflater.from(parent?.context).inflate(R.layout.list_layout, parent, false)
        return  ViewHolder(v)

    }


    override fun getItemCount(): Int {

        return userList.size
    }



    class  ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val textViewNama = itemView.findViewById(R.id.textViewNama) as TextView
        val textViewTtl = itemView.findViewById(R.id.textViewTTL) as TextView
        val textViewHp = itemView.findViewById(R.id.textViewHP) as TextView
        val textViewAlamat = itemView.findViewById(R.id.textViewAlamat) as TextView

    }
}