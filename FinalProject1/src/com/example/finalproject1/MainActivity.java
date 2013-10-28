package com.example.finalproject1;


import java.util.List;
import java.util.Locale;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;

import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener, LocationListener {
	
	
	LocationManager locationManager; 
	Location currentLocation; 
	private GoogleMap map; 
	Button searchButton; 
	Button favoriteButton; 
	Button groupButton; 
	TextView status; 

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		searchButton = (Button) findViewById(R.id.button1); 
		favoriteButton = (Button) findViewById(R.id.button2); 
		groupButton = (Button) findViewById(R.id.button3); 
		status = (TextView) findViewById(R.id.textView1); 
		
		searchButton.setOnClickListener(this);
		favoriteButton.setOnClickListener(this); 
		groupButton.setOnClickListener(this);
		
		searchButton.setId(1);
		favoriteButton.setId(2); 
		groupButton.setId(3); 
		
		//Location Service to locate current location of the user
		locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
		Criteria criteria = new Criteria(); 
		criteria.setAccuracy(Criteria.NO_REQUIREMENT); 
		criteria.setPowerRequirement(Criteria.NO_REQUIREMENT); 
		
		String bestProvider = locationManager.getBestProvider(criteria, true); 
		currentLocation = locationManager.getLastKnownLocation(bestProvider); 
		

		locationManager.requestLocationUpdates(bestProvider, 5000, 2.0f, this); 
		
		
		//set location on Google maps
		LatLng LOCATION_CURRENT= new LatLng(currentLocation.getLatitude() , currentLocation.getLongitude());
        GoogleMap map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        map.setMyLocationEnabled(true);
        map.addMarker(new MarkerOptions().position(LOCATION_CURRENT).title("Find me here!" + status  ));
        
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_CURRENT, 13));
   
        
       // map.addMarker(new MarkerOptions().title("Find me here!"));
		
//        LatLng sydney = new LatLng(-33.867, 151.206);
//
//        map.setMyLocationEnabled(true);
//        map.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 13));
//
//        map.addMarker(new MarkerOptions()
//                .title("Sydney")
//                .snippet("The most populous city in Australia.")
//                .position(sydney));
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int buttonId = v.getId();
		
		if(buttonId == 1){
			Intent intent = new Intent(this, Search.class); 
			startActivity(intent); 
			Toast.makeText(this, "button 1 has been triggered", Toast.LENGTH_SHORT).show();
		}
		
		else if(buttonId == 2){
			Intent intent = new Intent(this, Favourite.class); 
			startActivity(intent); 
			Toast.makeText(this, "button 2 has been triggered", Toast.LENGTH_SHORT).show();
		}
		
		else if(buttonId == 3){
			Intent intent = new Intent(this, Groups.class); 
			startActivity(intent); 
			Toast.makeText(this, "button 3 has been triggered", Toast.LENGTH_SHORT).show();
		}
		
		else {
			
			Toast.makeText(this, "Button Failed", Toast.LENGTH_SHORT).show();
		}
		

		
	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		Location currentLocation = location; 
		getAddress(currentLocation);
		//status.setText("Last Location LAT: " + currentLocation.getLatitude() + " LONG:" + currentLocation.getLongitude());
		
		
		
	}

	private void getAddress(Location location) {
		// TODO Auto-generated method stub
		
		List <Address> addresses;
		StringBuilder myAddressString; 
		
		try {
			Geocoder myGeocoder = new Geocoder(this, Locale.ENGLISH); 
			addresses = myGeocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
			
			if (addresses != null) {
				Address currentAddress = addresses.get(0); 
				myAddressString = new StringBuilder("Address: \n");
				
				
				for (int i = 0; i < currentAddress.getMaxAddressLineIndex(); i++) {
					myAddressString.append(currentAddress.getAddressLine(i)).append("\n");
					
				}
				
				status.setText(myAddressString.toString()); 
			}
			
		}
		
		catch(Exception e) {
			
			status.setText(e.getMessage());
		}
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}

}
