package com.project.stayhook.location

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.project.stayhook.R
import com.project.stayhook.auth.OtpAuthActivity

class LocationPermissionActivity : AppCompatActivity() {
    private lateinit var locationAccess:TextView
    private val LOCATION_PERMISSION_REQUEST_CODE = 123 // You can choose any request code
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location_permission)
        locationAccess=findViewById(R.id.locationAccess)

        locationAccess.setOnClickListener {
            checkLocationPermission()
        }
    }


    private fun checkLocationPermission() {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION),LOCATION_PERMISSION_REQUEST_CODE)
        }
        else {
            // Permission is already granted, proceed with location-related operations
            // Your code here
            Toast.makeText(this, "Permission Granted.", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@LocationPermissionActivity,LocationActivity::class.java))
        }
    }

    // Override onRequestPermissionsResult to handle the permission request response
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray )
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //permission is granted
                Toast.makeText(this, "Permission Granted.", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this@LocationPermissionActivity,LocationActivity::class.java))
            } else {
                // Permission denied
                Toast.makeText(this, "Permission is required!!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}