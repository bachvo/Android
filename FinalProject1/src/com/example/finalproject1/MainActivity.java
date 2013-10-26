package com.example.finalproject1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	
	Button searchButton; 
	Button favoriteButton; 
	Button groupButton; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	
		searchButton = (Button) findViewById(R.id.button1); 
		favoriteButton = (Button) findViewById(R.id.button2); 
		groupButton = (Button) findViewById(R.id.button3); 
		
		searchButton.setOnClickListener(this);
		favoriteButton.setOnClickListener(this); 
		groupButton.setOnClickListener(this); 
		
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
		}
		
		else if(buttonId == 2){
			Intent intent = new Intent(this, Favourite.class); 
			startActivity(intent); 
		}

		
	}

}
