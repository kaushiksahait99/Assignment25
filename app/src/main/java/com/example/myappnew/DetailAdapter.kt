package com.example.myappnew

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class DetailAdapter(val context:Context,val details:List<WelcomeElement>,val viewModel: FavViewModel):
    RecyclerView.Adapter<DetailAdapter.DetailViewHolder>() {





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.row,parent,false)
        return DetailViewHolder(view)

    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        val det=details[position]
        val id=det.id
        val name=det.name
        val email=det.email
        val street=det.address.street
        val suite =det.address.suite
        val city =det.address.city
        val zipcode=det.address.zipcode
        val lat=det.address.geo.lat
        val lng=det.address.geo.lng
        holder.title.text=name
        holder.title2.text=email
        holder.bttn.setOnClickListener(View.OnClickListener {
            val fav= Fav(id,name,email,street,suite,city,zipcode,lat,lng)
            /*As soon as the fav button icon is clicked
            * data from the List<welComeElement> recieved from api will passed as Fav constructer parameters*/
            viewModel.InsertNote(fav)//this method is defined in dao interface(FaveDao)

             Toast.makeText(context, "Added to Favourites", Toast.LENGTH_SHORT).show()
            holder.bttn.setImageResource(R.drawable.ic_baseline_favorite_24)

















            // viewModel.InsertNote(fav)

               // Toast.makeText(context, "Inserted", Toast.LENGTH_SHORT).show()


            // val intent = Intent(context, MainActivity2::class.java)
            // start your next activity
         /*   intent.putExtra("name",name)
            intent.putExtra("email",email)
            intent.putExtra("street",street)
            intent.putExtra("suite",suite)
            intent.putExtra("city",city)
            intent.putExtra("zipcode",zipcode)
            intent.putExtra("lat",lat)
            intent.putExtra("lng",lng)
            intent.putExtra("position",position)

            context.startActivity(intent)*/


        })

    }

    override fun getItemCount(): Int {
        return details.size

    }
    class DetailViewHolder(itemVIew: View):RecyclerView.ViewHolder(itemVIew){
        var title=itemVIew.findViewById<TextView>(R.id.name)
        var title2=itemVIew.findViewById<TextView>(R.id.email)
        var bttn=itemVIew.findViewById<ImageButton>(R.id.smt)



    }
}
/*interface INotesRVAdapter{
    fun onItemClicked(fav: Fav)
}*/