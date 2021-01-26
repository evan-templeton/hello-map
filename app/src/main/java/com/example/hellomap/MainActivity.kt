package com.example.hellomap

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.here.sdk.core.GeoCoordinates
import com.here.sdk.mapviewlite.MapStyle
import com.here.sdk.mapviewlite.MapViewLite


class MainActivity : AppCompatActivity() {

    private var mapView: MapViewLite? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get a MapViewLite instance from the layout.
        mapView = findViewById(R.id.map_view)
        mapView!!.onCreate(savedInstanceState)

        loadMapScene()
    }

    private fun loadMapScene() {
        // Load a scene from the SDK to render the map with a map style.
        mapView!!.mapScene.loadScene(
            MapStyle.NORMAL_DAY
        ) { errorCode ->
            if (errorCode == null) {
                mapView!!.camera.target = GeoCoordinates(52.530932, 13.384915)
                mapView!!.camera.zoomLevel = 14.0
            } else {
                Log.d("HereMaps Error", "onLoadScene failed: $errorCode")
            }
        }
    }

    override fun onPause() {
        super.onPause()
        mapView!!.onPause()
    }

    override fun onResume() {
        super.onResume()
        mapView!!.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView!!.onDestroy()
    }


}