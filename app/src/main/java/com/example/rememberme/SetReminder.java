package com.example.rememberme;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SetReminder extends Activity implements View.OnClickListener{
	Button search;
	Button setrem;
	EditText name;
	EditText birthday,cellnum;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setreminder);
		search= (Button) findViewById(R.id.bdaysearch);
		setrem= (Button) findViewById(R.id.setreminder);
		name= (EditText) findViewById(R.id.etname);
		birthday= (EditText) findViewById(R.id.etbday);
		cellnum= (EditText) findViewById(R.id.etcellnum);
		
		search.setOnClickListener(this);
		setrem.setOnClickListener(this);
		name.setOnClickListener(this);
		birthday.setOnClickListener(this);
			
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch (v.getId()){
		
		case R.id.bdaysearch:
			String N_ame = name.getText().toString();
			database ser = new database(SetReminder.this);
			ser.open();
			String cellNo = ser.getCellbyName(N_ame);
			String bday = ser.getBdaybyName(N_ame);
			birthday.setText(bday);
			cellnum.setText(cellNo);
			ser.close();
			break;
		
		case R.id.setreminder:
			
			break;
			
		case R.id.etname:	
			name.setText("");
			break;
		
		case R.id.etbday:
			//etName.setText("");
			break;
		}
		
	}
	
	
}
