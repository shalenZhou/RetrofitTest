package com.example.retrofittest.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofittest.model.PlaceResponse
import com.example.retrofittest.service.PlaceService
import com.example.retrofittest.service.ServiceCreator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "RetrofitTest"

class MainViewModel : ViewModel() {

    private val _place = MutableLiveData<String>().apply {
        value = "北京"
    }

    fun showPlaceInfo() {
        val placeService = ServiceCreator.create<PlaceService>()
        _place.value?.let {
            placeService.searchPlaces(it).enqueue(object : Callback<PlaceResponse> {
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
                                "place's name: ${place.name}, " +
                                        "place's address: ${place.address}, " +
                                        "place's location: ${place.location.lat}, ${place.location.lng}"
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