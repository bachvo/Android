package com.example.finalproject1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class DatabaseConnector {

	// database name
	   private static final String DATABASE_NAME = "Groups";
	   private SQLiteDatabase database; // database object
	   private DatabaseOpenHelper databaseOpenHelper; // database helper

	   // public constructor for DatabaseConnector
	   public DatabaseConnector(Context context) {
	      // create a new DatabaseOpenHelper
	      databaseOpenHelper = new DatabaseOpenHelper(context, DATABASE_NAME, null, 1);
	   } // end DatabaseConnector constructor

	   // open the database connection
	   public void open() throws SQLException {
	      // create or open a database for reading/writing
	      database = databaseOpenHelper.getWritableDatabase();
	   } // end method open

	   // close the database connection
	   public void close() {
	      if (database != null)
	         database.close(); // close the database connection
	   } // end method close

	   // inserts a new course in the database
	   public void insertGroup(String number, String name, String instructor, String location, String description) {
	      ContentValues newGroup = new ContentValues();
	      newGroup.put("number", number);
	      newGroup.put("name", name);


	      open(); // open the database
	      database.insert("groups", null, newGroup);
	      close(); // close the database
	   } // end method insertGroup

	   // inserts a new course in the database
	   public void updateGroup(long id, String number, String name, 
	      String instructor, String location, String description) {
	      ContentValues editGroup = new ContentValues();
	      editGroup.put("number", number);
	      editGroup.put("name", name);


	      open(); // open the database
	      database.update("groups", editGroup, "_id=" + id, null);
	      close(); // close the database
	   } // end method updateContact

	   // return a Cursor with all contact information in the database
	   public Cursor getAllGroups() {
	      return database.query("groups", new String[] {"_id", "number"}, 
	         null, null, null, null, "number");
	   } // end method getAllGroups

	   // get a Cursor containing all information about the contact specified
	   // by the given id
	   public Cursor getOneGroup(long id) {
	      return database.query("groups", null, "_id=" + id, null, null, null, null);
	   } // end method getOnCourse

	   // delete the contact specified by the given String name
	   public void deleteGroup(long id) {
	      open(); // open the database
	      database.delete("groups", "_id=" + id, null);
	      close(); // close the database
	   } // end method deleteContact
	   
	   private class DatabaseOpenHelper extends SQLiteOpenHelper {
	      // public constructor
	      public DatabaseOpenHelper(Context context, String name,
	         CursorFactory factory, int version) 
	      {
	         super(context, name, factory, version);
	      } // end DatabaseOpenHelper constructor

	      // creates the contacts table when the database is created
	      @Override
	      public void onCreate(SQLiteDatabase db) {
	         // query to create a new table named contacts
	         String createQuery = "CREATE TABLE groups" +
	            "(_id integer primary key autoincrement," +
	            "number TEXT, name TEXT, instructor TEXT," +
	            "location TEXT, description TEXT);";
	                  
	         db.execSQL(createQuery); // execute the query
	      } // end method onCreate

	      @Override
	      public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	      } // end method onUpgrade
	   } // end class DatabaseOpenHelper

}
