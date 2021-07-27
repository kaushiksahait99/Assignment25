package com.example.myappnew

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FavAdapter(private val context: Context,private val listener:FavClick): RecyclerView.Adapter<FavAdapter.FavViewHolder>() {
    val allFav=ArrayList<Fav>()
    inner class FavViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){


        val textView=itemView.findViewById<TextView>(R.id.name2)
        val textView2=itemView.findViewById<TextView>(R.id.email2)
        val buttn=itemView.findViewById<ImageButton>(R.id.smt2)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavViewHolder {
        val viewHolder=FavViewHolder( LayoutInflater.from(context).inflate(R.layout.row_2,parent,false))
        return viewHolder

    }

    override fun onBindViewHolder(holder: FavViewHolder, position: Int) {
        val currentFav=allFav[position]
       holder.textView.text=currentFav.name;
        holder.textView2.text=currentFav.email;
        holder.buttn.setOnClickListener {
            val intent = Intent(context, MapsActivity::class.java)
            intent.putExtra("street",currentFav.street)
            intent.putExtra("suite",currentFav.suite)
            intent.putExtra("city",currentFav.city)
            intent.putExtra("zipcode",currentFav.zipcode)
            intent.putExtra("lat",currentFav.lat)
            intent.putExtra("lng",currentFav.lng)
            intent.putExtra("name",currentFav.name)
            context.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {
        return allFav.size
    }
    fun updateList(newList:List<Fav>){
        allFav.clear()
        allFav.addAll(newList)
        notifyDataSetChanged()
    }
}
interface FavClick{
    fun onItemClicked(fav: Fav)
}
