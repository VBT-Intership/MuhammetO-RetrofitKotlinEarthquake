package com.mukireus.earthquakelistkotlin

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mukireus.earthquakelistkotlin.Core.AppConstants
import com.mukireus.earthquakelistkotlin.Core.Model.EarthquakeModel
import com.mukireus.earthquakelistkotlin.Core.Service.IApiEarthquake
import com.mukireus.earthquakelistkotlin.UI.QuakeDataAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private var quakeList: ArrayList<EarthquakeModel>? = null
    private var quakeDataAdapter: QuakeDataAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        recycler_view.layoutManager = layoutManager
        fetchData()
    }

    private fun fetchData() {
        val retrofit = Retrofit.Builder()
            .baseUrl(AppConstants.API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(IApiEarthquake::class.java)
        val call = service.getHttpEarthquakeList()


        call.enqueue(object : Callback<List<EarthquakeModel>> {
            override fun onFailure(call: Call<List<EarthquakeModel>>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(
                call: Call<List<EarthquakeModel>>,
                response: Response<List<EarthquakeModel>>
            ) {
                if (response.isSuccessful) {
                    Toast.makeText(this@MainActivity, "Successful!", Toast.LENGTH_SHORT).show()
                    response.body()?.let {
                        quakeList = ArrayList(it)
                        quakeList?.let {
                            quakeDataAdapter = QuakeDataAdapter(it)
                            recycler_view.adapter = quakeDataAdapter
                        }
                    }
                }
            }

        })
    }
}

