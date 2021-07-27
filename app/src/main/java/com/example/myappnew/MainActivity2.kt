package com.example.myappnew

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() , FavClick{
    lateinit var viewModel: FavViewModel
    override fun onCreate(savedInstanceState: Bundle?) {

       /*Activity for recieving favourite items which are being stored locally*/



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        recylerView.layoutManager= LinearLayoutManager(this)
        val adapter=FavAdapter(this,this)
        recylerView.adapter=adapter
        recylerView.hasFixedSize()
        viewModel= ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(FavViewModel::class.java)
        /*Recieving ViewModel object



        * */

        viewModel.allFav.observe(this, Observer {list-> /*Observer method will be called which will return live data,
        whaterve changes happen in livedata will be observed through the observer method*/
            list?.let {
                adapter.updateList(it)//List gets updates as soon as the new data been in inserted in the database


            }


        })


    }

    override fun onItemClicked(fav: Fav) {
        TODO("Not yet implemented")
    }
}