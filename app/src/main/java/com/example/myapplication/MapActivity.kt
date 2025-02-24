package com.example.myapplication

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import org.osmdroid.config.Configuration
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker

class MapActivity : AppCompatActivity() {

    private lateinit var mapView: MapView
    private val locationPermissionRequestCode = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the osmdroid user agent (important for caching)
        Configuration.getInstance().userAgentValue = packageName

        // Set the layout for this activity (activity_maps.xml)
        setContentView(R.layout.activity_maps)

        // Set up the toolbar (optional)
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Initialize the MapView
        mapView = findViewById(R.id.map)
        mapView.setMultiTouchControls(true)

        // Configure the map: set zoom and center position
        val mapController = mapView.controller
        mapController.setZoom(15.0) // Adjust zoom level as needed
        val startPoint = GeoPoint(48.8583, 2.2944) // Example: Eiffel Tower coordinates
        mapController.setCenter(startPoint)

        // Add a marker at the example location
        val marker = Marker(mapView)
        marker.position = startPoint
        marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
        marker.title = "Example Location"
        mapView.overlays.add(marker)

        // Set up the Back to Home button to finish this activity
        val backButton = findViewById<Button>(R.id.btnBackToHome)
        backButton.setOnClickListener { finish() }

        // Request location permission if not already granted
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                locationPermissionRequestCode
            )
        }
    }

    // Handle location permission result (no additional action needed)
    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<out String>, grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        // No additional action needed when permission is granted.
    }

    // Manage the MapView's lifecycle
    override fun onResume() {
        super.onResume()
        mapView.onResume()  // Required for osmdroid
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()   // Required for osmdroid
    }
}
