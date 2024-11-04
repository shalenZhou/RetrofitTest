package com.example.retrofittest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofittest.databinding.ActivityMainBinding
import com.example.retrofittest.model.PlaceResponse
import com.example.retrofittest.service.PlaceService
import com.example.retrofittest.service.ServiceCreator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.getPlaceDataBtn.setOnClickListener {
            val placeService = ServiceCreator.create<PlaceService>()
            placeService.searchPlaces("北京").enqueue(object : Callback<PlaceResponse> {
                override fun onResponse(
                    call: Call<PlaceResponse>,
                    response: Response<PlaceResponse>
                ) {
                    val placeResponse = response.body()
                    if (placeResponse != null) {
                        Log.d(TAG, "response's status: ${placeResponse.status}")
                        val placesList = placeResponse.places
                        for (place in placesList) {
                            Log.d(
                                TAG,
                                "place's name: ${place.name}, place's address: ${place.address}, place's location: ${place.location.lat}, ${place.location.lng}"
                            )
                        }
                    }
                }

                override fun onFailure(call: Call<PlaceResponse>, t: Throwable) {
                    t.printStackTrace()
                }

            })
        }
    }

}