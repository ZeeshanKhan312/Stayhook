package com.project.stayhook.location

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.project.stayhook.R
import com.project.stayhook.dashboard.DashboardActivity

class LocationActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var addressName: TextView
    private lateinit var useLocation: TextView

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private lateinit var map: GoogleMap
    private lateinit var currLocation : Location

//    companion object {
//        // Static variable
//        public lateinit var currAddress:String
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)

        addressName=findViewById(R.id.address)
        useLocation=findViewById(R.id.useLocation)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment //as keyword to typecast
        mapFragment.getMapAsync(this@LocationActivity)

        fusedLocationProviderClient= LocationServices.getFusedLocationProviderClient(this@LocationActivity)
        getLastLocation()

        useLocation.setOnClickListener {
            startActivity(Intent(this@LocationActivity,DashboardActivity::class.java))
            finish()
        }
    }

    private fun getLastLocation(){

        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return
        }
        fusedLocationProviderClient.lastLocation.addOnSuccessListener(this) { location->
            if(location!=null){
                map.isMyLocationEnabled = true
                map.uiSettings.isMyLocationButtonEnabled = true //for blue dots current location
                currLocation = location
                var you= LatLng(currLocation.latitude,currLocation.longitude)
                map.addMarker(MarkerOptions().position(you))
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(you,12f))  //for zooming into location

                val geocoder= Geocoder(this@LocationActivity)
                val address=geocoder.getFromLocation(currLocation.latitude,currLocation.longitude,1)
                val loc:String= address!![0].locality+", "+address[0].subLocality+", "+address[0].adminArea+", "+address[0].countryName
                addressName.text=loc

//                currAddress=address[0].locality+", "+address[0].countryName
            }
        }

    }

    override fun onMapReady(googleMap: GoogleMap) {
        map=googleMap
        map.uiSettings.isZoomControlsEnabled=true

    }
}