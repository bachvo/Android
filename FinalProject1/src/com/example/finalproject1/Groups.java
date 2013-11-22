package com.example.finalproject1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Groups extends Activity implements OnClickListener {
	
	Button searchButton; 
	Button favoriteButton; 
	Button groupButton; 
	
	Button contactsTab; 
	Button groupsTab; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_groups);
		
		searchButton = (Button) findViewById(R.id.button1); 
		favoriteButton = (Button) findViewById(R.id.button2); 
		groupButton = (Button) findViewById(R.id.button3); 
		
		groupsTab = (Button) findViewById(R.id.button4); 
		contactsTab = (Button) findViewById(R.id.button5); 
		
		
		searchButton.setOnClickListener(this);
		favoriteButton.setOnClickListener(this); 
		groupButton.setOnClickListener(this);
		
		groupsTab.setOnClickListener(this);
		contactsTab.setOnClickListener(this); 
		
		searchButton.setId(1);
		favoriteButton.setId(2); 
		groupButton.setId(3); 
		
		groupsTab.setId(4);
		contactsTab.setId(5);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_add, menu);
		getMenuInflater().inflate(R.menu.groups, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		int buttonId = v.getId();
		
		if(buttonId == 1){
			Intent intent = new Intent(this, MainActivity.class); 
			startActivity(intent); 
			//Toast.makeText(this, "button 2 has been triggered", Toast.LENGTH_SHORT).show();
		}
		
		else if(buttonId == 2){
			Intent intent = new Intent(this, Favourite.class); 
			startActivity(intent); 
			//Toast.makeText(this, "button 3 has been triggered", Toast.LENGTH_SHORT).show();
		}
		
		else if (buttonId == 4){
			Intent intent = new Intent(this, Contact.class);
			startActivity(intent);
			
		}
		
	}

}
