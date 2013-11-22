package com.example.finalproject1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Favourite extends Activity implements OnClickListener {
	
	Button searchButton; 
	Button favoriteButton; 
	Button groupButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_favourite);
		
		searchButton = (Button) findViewById(R.id.button1); 
		favoriteButton = (Button) findViewById(R.id.button2); 
		groupButton = (Button) findViewById(R.id.button3); 
		
		searchButton.setOnClickListener(this);
		favoriteButton.setOnClickListener(this); 
		groupButton.setOnClickListener(this);
		
		searchButton.setId(1);
		favoriteButton.setId(2); 
		groupButton.setId(3); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.favourite, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		int buttonId = v.getId();
		
		if(buttonId == 1){
			Intent intent = new Intent(this, MainActivity.class); 
			startActivity(intent); 
			//Toast.makeText(this, "button 2 has been triggered", Toast.LENGTH_SHORT).show();
		}
		
		else if(buttonId == 3){
			Intent intent = new Intent(this, Contact.class); 
			startActivity(intent); 
			//Toast.makeText(this, "button 3 has been triggered", Toast.LENGTH_SHORT).show();
		}
		
	}

}
