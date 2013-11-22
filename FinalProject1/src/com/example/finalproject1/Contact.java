package com.example.finalproject1;




import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import android.provider.ContactsContract;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.PhoneLookup;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.LoaderManager;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;

import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.widget.SimpleCursorAdapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;


public class Contact extends Activity implements OnClickListener {
	
	@SuppressLint("InlinedApi")
	private final static String[] FROM_COLUMNS = {
		
		Build.VERSION.SDK_INT 
		>= Build.VERSION_CODES.HONEYCOMB ?
				Contacts.DISPLAY_NAME_PRIMARY :
				Contacts.DISPLAY_NAME
	};
	
	private final static int[] TO_IDS = {
		android.R.id.text1	
	};
	
	ListView mContactsList; 
	long mContactId; 
	String mContactKey; 
	Uri mContactUri; 
	private SimpleCursorAdapter mCursorAdapter; 
	TextView txtview; 
	Button btn;
	TextView txt;
	CheckBox checkBox; 
	
	Button searchButton; 
	Button favoriteButton; 
	Button groupButton; 
	
	Button contactsTab; 
	Button groupsTab;
	Button addGroup; 
	
	String Name;
	String Number;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact);
		
		searchButton = (Button) findViewById(R.id.button1); 
		favoriteButton = (Button) findViewById(R.id.button2); 
		groupButton = (Button) findViewById(R.id.button3); 
		
		groupsTab = (Button) findViewById(R.id.button4); 
		contactsTab = (Button) findViewById(R.id.button5); 
		addGroup = (Button) findViewById(R.id.button6); 
		
		searchButton.setOnClickListener(this);
		favoriteButton.setOnClickListener(this); 
		groupButton.setOnClickListener(this);
		
		groupsTab.setOnClickListener(this);
		contactsTab.setOnClickListener(this); 
		addGroup.setOnClickListener(this); 
		
		searchButton.setId(1);
		favoriteButton.setId(2); 
		groupButton.setId(3); 
		
		groupsTab.setId(4);
		contactsTab.setId(5);
		addGroup.setId(6);
		
		
		
		
		Bundle extras = getIntent().getExtras(); // get Bundle of extras
		
		Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
		
		 

		 

		
		TableLayout tablelayout = (TableLayout) findViewById(R.id.TableLayout1);
		tablelayout.setOrientation(TableLayout.VERTICAL);
		
		while(phones.moveToNext()){
			
			String Name = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
			String Number = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
			
			TableLayout row = new TableLayout(this); 
			row.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT)); 
			
			checkBox = new CheckBox(this); 
			checkBox.setOnClickListener(this);
			checkBox.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
			checkBox.setText(Name+ "   " + Number );
//			txt.setId(nameIndex);
	        row.addView(checkBox);
			tablelayout.addView(row);
			
//			String nameID = extras.getString(Name); 
			

			

	         
			
		}
		
		
		
	}
	
//	public ContactsFragment() {}
//	
//	@Override
//	public View onCreateView(LayoutInflator inflator, ViewGroup container, Bundle savedInstanceState) {
//		return inflator.inflate(R.layout.contacts_list_layout, container, false);
//	}
//	
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.groups, menu);
		getMenuInflater().inflate(R.menu.menu_add, menu);
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
		
		else if (buttonId == 5){
			Intent intent = new Intent(this, Groups.class);
			startActivity(intent);
			
		}
		
		else if (buttonId == 6){
			
	         if (checkBox.isChecked()) {
                 saveGroup(); // save course to the database
	            Toast.makeText(this, Name, Toast.LENGTH_SHORT).show(); 
	         }

			
		}
		
		
	}
	
	
	public void saveGroup() {
		
		DatabaseConnector databaseConnector = new DatabaseConnector(this); 
		
        databaseConnector.insertGroup( 
        		
        		Name.toString(),
        		Number.toString(), null, null, null
        		
        		); 
		
	}
	

}
