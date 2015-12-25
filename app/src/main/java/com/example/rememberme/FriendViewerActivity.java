package com.example.rememberme;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class FriendViewerActivity extends Activity implements OnClickListener{
	
	ImageButton CallButton, SMSButton, DeleteButton, EditButton;
	
	TextView TV_Name, TV_Relation, TV_BirthDay, TV_Cell, TV_Email, TV_Address;
	
	String Name, Relation, BirthDay, Cell, Email, Address;
	
	database DBAccess;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_friend_viewer);
		
		TV_Name = (TextView) findViewById(R.id.textView_Viewer_Name);
		
		TV_Relation = (TextView) findViewById(R.id.textView_Viewer_Relation);
		
		TV_BirthDay = (TextView) findViewById(R.id.textView_Viewer_BirthDay);
		
		TV_Cell = (TextView) findViewById(R.id.textView_Viewer_Cell);
		
		TV_Email = (TextView) findViewById(R.id.textView_Viewer_Email);
		
		TV_Address = (TextView) findViewById(R.id.textView_Viewer_Address);
		
		
		CallButton = (ImageButton) findViewById(R.id.imageButton_Viewer_CallButton);
		CallButton.setOnClickListener(this);
		
		SMSButton = (ImageButton) findViewById(R.id.imageButton__Viewer_SMSButton);
		SMSButton.setOnClickListener(this);
		
		DeleteButton = (ImageButton) findViewById(R.id.imageButton_Viewer_DeleteButton);
		DeleteButton.setOnClickListener(this);
		
		EditButton = (ImageButton) findViewById(R.id.imageButton_Viewer_EditButton);
		EditButton.setOnClickListener(this);
		
		
		CallDataFromDataBase();
		
		
		TV_Name.setText(Name);
		
		TV_Relation.setText(Relation);
		
		TV_BirthDay.setText(BirthDay);
		
		TV_Cell.setText(Cell);
		
		TV_Email.setText(Email);
		
		TV_Address.setText(Address);
		
		
	}

	private void CallDataFromDataBase() {
		
		DBAccess = new database(this);
		
		DBAccess.open();
		
		Cursor CursorGetInfo = DBAccess.GetFriendInfo(Viewfriendlist.IdOnClick);
		
		DBAccess.close();
		
		if (CursorGetInfo.moveToFirst()) {
			Name = CursorGetInfo.getString(1);
			Relation = CursorGetInfo.getString(2);
			BirthDay = CursorGetInfo.getString(3);
			Cell = CursorGetInfo.getString(4);
			Email = CursorGetInfo.getString(5);
			Address = CursorGetInfo.getString(6);

		}
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.imageButton_Viewer_CallButton:
			
			break;
			
		case R.id.imageButton__Viewer_SMSButton:
			
			break;
			
		case R.id.imageButton_Viewer_DeleteButton:
			
			break;
			
		case R.id.imageButton_Viewer_EditButton:
			
			break;

		}
		
	}
	
	

}
