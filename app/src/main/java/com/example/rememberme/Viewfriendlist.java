package com.example.rememberme;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Viewfriendlist extends Activity{
	
	database dbHelper; 
	
	SimpleCursorAdapter dataAdapter;
	
	public static long IdOnClick;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_friends);
		
		try{
		
		dbHelper = new database(this);
		
		}catch(SQLException e){
			
			e.printStackTrace();
		}
		
		dbHelper.open();
		
		displayListView();
	}

	private void displayListView() {


		Cursor cursor = dbHelper.fetchAllEntries();
		
		dbHelper.close();
		
		// The desired columns to be bound
		String[] columns = new String[] {
				    database.KEY_NAME,
				    database.KEY_EMAIL,
				    database.KEY_CELL	};
		// the XML defined views which the data will be bound to 
		int[] to = new int[]{
				 R.id.TV_name,
				 R.id.TV_email,
				 R.id.TV_cell,		 
		};
		
		//create the adapter using the cursor pointing to the desired data 
		//as well as the layout information
		
		dataAdapter = new SimpleCursorAdapter(this, R.layout.viewfriendlist_item, cursor, columns, to, 0);
		
		ListView listView = (ListView) findViewById(R.id.listView_FriendList);
		
		//listView.setEmptyView(findViewById(R.id.textView_HIstoryListforEmpty));
		 // Assign adapter to ListView
		listView.setAdapter(dataAdapter);
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> listView, View view, int position, long id) {

				//----------------------------------------------------------//
				
				IdOnClick = id;
				
				Intent OpenViewerActivity = new Intent(Viewfriendlist.this, FriendViewerActivity.class);
				startActivity(OpenViewerActivity);
				
			}
			
		});
		
	}

}
