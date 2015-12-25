package com.example.rememberme;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Viewfriends extends Activity {
/*	Button searchbt;
	EditText searchet;
	TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.view_friends);
		
		searchbt = (Button) findViewById(R.id.bsearch);
		searchet = (EditText) findViewById(R.id.etsearch);
		tv = (TextView) findViewById(R.id.tv);
		database info = new database(this);
		info.open();
		String data = info.getData();
		info.close();
		tv.setText(data);
		searchet.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				searchet.setText("");
			}
		});
		searchbt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String name = searchet.getText().toString();
				//long l = Long.parseLong(name);
				database ser = new database(Viewfriends.this);
				ser.open();
				//String returnedname = ser.getName(l);
				//String returnedrelation = ser.getRelation(l);
				//String returnedbday = ser.getBday(l);
				
				String SearchData = ser.getDatabyName(name);
				
				ser.close();
				
				//tv.setText(SearchData);
				
				//Dialog d = new Dialog(Viewfriends.this);
				//d.setTitle("info");
				//TextView tv = new TextView(Viewfriends.this);
				//tv.setText(returnedname);
				
				//tv.setText("Name: " + returnedname + "\n" +
							  // "Relation: " + returnedrelation + "\n" + 
						      // "Birthday: " + returnedbday );
			
				//d.setContentView(tv);
				//d.show();
				
				Dialog d = new Dialog(Viewfriends.this);
				d.setTitle("Personal Info");
				TextView tv1 = new TextView(Viewfriends.this);
				tv1.setText(SearchData);
				d.setContentView(tv1);
				d.show();
				
			
				
			}
		});
		
		
	}
	
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	
	*/
}
