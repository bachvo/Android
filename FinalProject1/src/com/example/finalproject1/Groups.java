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


public class Groups extends Activity implements OnClickListener {
	
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



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_groups);
		
		searchButton = (Button) findViewById(R.id.button1); 
		favoriteButton = (Button) findViewById(R.id.button2); 
		groupButton = (Button) findViewById(R.id.button3); 
		
		searchButton.setOnClickListener(this);
		favoriteButton.setOnClickListener(this); 
		groupButton.setOnClickListener(this);
		
		searchButton.setId(1);
		favoriteButton.setId(2); 
		groupButton.setId(3); 
		
		
		//Cursor people = getContentResolver().query(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, null, null, null, null);
		Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
		

		
		//Cursor people = getContentResolver().query(ContactsContract.PhoneLookupColumns, null, null, null, null);
     //   Uri lookupUri = Uri.withAppendedPath(PhoneLookup.CONTENT_FILTER_URI,Uri.encode(phoneNumber));
		
		TableLayout tablelayout = (TableLayout) findViewById(R.id.TableLayout1);
		tablelayout.setOrientation(TableLayout.VERTICAL);
		
		while(phones.moveToNext()){
			
			 String Name = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
			 String Number = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
			// String ID = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_THUMBNAIL_URI));
//			int nameIndex = people.getColumnIndex(PhoneLookup.DISPLAY_NAME);
//			int orderNumber = people.getColumnIndex(PhoneLookup._ID); 
		//	int phoneNumber = people.getColumnIndex(PhoneLookup.NUMBER);
	
			
//			String name = people.getString(nameIndex);
//			String order = people.getString(orderNumber);
		//	String phone = people.getString(phoneNumber);
			
			
			
			//Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
			
//			ListView row = new ListView(this); 
//			row.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT)); 
//			
//			txtview = new TextView(this); 
//			//txtview.setOnClickListener(this);
//			txtview.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
//		
//			txtview.setText("lolol");
//			//txtview.setId(i);
//	        row.addView(txtview);
			//tablelayout.addView(row);
			
//			Log.d("CONTACTS", name); 
			
			TableLayout row = new TableLayout(this); 
			row.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT)); 
			
			checkBox = new CheckBox(this); 
			checkBox.setOnClickListener(this);
			checkBox.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
			checkBox.setText(Name+ "   " + Number );
//			txt.setId(nameIndex);
	        row.addView(checkBox);
			tablelayout.addView(row);
			
	         if (checkBox.isChecked()) {
	             checkBox.setChecked(true);
	             
	         }
	         
			
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
		Toast.makeText(this, "triggered yo", Toast.LENGTH_SHORT).show();
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
		
		
	}

}
