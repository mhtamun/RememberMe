package com.example.rememberme;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

public class ClassMenu extends Activity implements OnClickListener{

	ImageButton btaddfriend,btviewfriend;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		btaddfriend= (ImageButton) findViewById(R.id.addfriend);
		btviewfriend= (ImageButton) findViewById(R.id.viewfriend);
		btaddfriend.setOnClickListener(ClassMenu.this);
		btviewfriend.setOnClickListener(ClassMenu.this);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		
			case R.id.addfriend:
				Intent i= new Intent(ClassMenu.this, AddInfo.class);
				startActivity(i);
				
				break;
			case R.id.viewfriend:
				Intent J= new Intent(ClassMenu.this, Viewfriendlist.class);
				startActivity(J);
				break;
		}
		
	}
}
