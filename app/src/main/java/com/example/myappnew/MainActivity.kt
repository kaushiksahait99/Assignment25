package com.example.myappnew

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var adapter: DetailAdapter
    lateinit var viewModel: FavViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)



        viewModel= ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(FavViewModel::class.java)
        getDetails(viewModel)//recieving viewModel.i.e FavViewModel Class object
    }

    private fun getDetails(viewModel: FavViewModel) {
      val userDet=UserDetails.userinstance.getDetails()/*Call getDetails methods which has been defined in User.kt interface
                                                         through userinstance object(which is a singleton object)
                                                          */
        userDet?.enqueue(object :Callback<List<WelcomeElement>>{
            override fun onResponse(
                call: Call<List<WelcomeElement>>, response: Response<List<WelcomeElement>>) {
                Toast.makeText(applicationContext,"Here is the Full List",Toast.LENGTH_SHORT).show()

                val userDet=response.body()//recieving the results from the api in the List form with type WelcomeElement(which is a model class)

                adapter= DetailAdapter(this@MainActivity,userDet,viewModel)/*Setting Up the Adapter*/
                rclv.adapter=adapter
                rclv.layoutManager=LinearLayoutManager(this@MainActivity)
                rclv.hasFixedSize()

            }

            override fun onFailure(call: Call<List<WelcomeElement>>, t: Throwable?) {

            }

        }

        )
    }
}