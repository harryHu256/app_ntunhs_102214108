package com.example.jsonread
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL

class JsonViewModel: ViewModel() {
    val TAG = JsonViewModel::class.java.simpleName
    fun readJson(){
        viewModelScope.launch(Dispatchers.IO){
            val json = URL("https://api.jsonserve.com/7pn1o2").readText()
            Log.w(TAG, json)
            //parseJson(json)
            val singers = Gson().fromJson(json, kpop::class.java)
            for(w in singers.singers){
                Log.d(TAG, "onCreate: ${w.name}, ${w.agency}, ${w.year_of_debut}")
            }
        }

    }

}