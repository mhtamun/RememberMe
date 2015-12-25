package com.example.rememberme;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddInfo extends Activity implements View.OnClickListener{
	Button addInfo;
	TextView tvName,tvRelation,tvBD,tvCell,tvEmail,tvAddress;
	EditText etName,etRelation,etBD,etCell,etEmail,etAddress;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addinfo);
		initialize();
		addInfo.setOnClickListener(this);
		
		etName.setOnClickListener(this);
		etRelation.setOnClickListener(this);
		etBD.setOnClickListener(this);
		etCell.setOnClickListener(this);
		etEmail.setOnClickListener(this);
		etAddress.setOnClickListener(this);
	}

	private void initialize() {
		// TODO Auto-generated method stub
			addInfo= (Button) findViewById(R.id.btAddInfo);
			
			etName= (EditText) findViewById(R.id.etAddName);
			etRelation= (EditText) findViewById(R.id.etAddRelation);
			etBD= (EditText) findViewById(R.id.etAddBD);
			etCell= (EditText) findViewById(R.id.etAddCell);
			etEmail= (EditText) findViewById(R.id.etAddEmail);
			etAddress= (EditText) findViewById(R.id.etAddAddress);
			
			tvName = (TextView) findViewById(R.id.tvAddName);
			tvRelation = (TextView) findViewById(R.id.tvAddRelation);
			tvBD = (TextView) findViewById(R.id.tvAddBD);
			tvCell = (TextView) findViewById(R.id.tvAddCell);
			tvEmail = (TextView) findViewById(R.id.tvAddEmail);
			tvAddress = (TextView) findViewById(R.id.tvAddAddress);
			
			//addInfo.setOnClickListener(this);
			
 		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
switch(v.getId()){
		
		case R.id.btAddInfo:
			boolean diditwork = true;
			try {
				String name = etName.getText().toString();
				String relation = etRelation.getText().toString();
				String birthday = etBD.getText().toString();
				String cell = etCell.getText().toString();
				String email = etEmail.getText().toString();
				String address = etAddress.getText().toString();
				
				database entry = new database(AddInfo.this);
				entry.open();
				entry.createEntry(name, relation, birthday,cell,email,address);
				entry.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				diditwork = false;
				String error = e.toString();
				Dialog d = new Dialog(AddInfo.this);
				d.setTitle("Problem");
				TextView tv = new TextView(AddInfo.this);
				tv.setText(error);
				d.setContentView(tv);
				d.show();
				
				
			}finally{
				if(diditwork){
					Dialog d = new Dialog(AddInfo.this);
					d.setTitle("oh yeah!");
					TextView tv = new TextView(AddInfo.this);
					tv.setText("success");
					d.setContentView(tv);
					d.show();
					
					Intent i= new Intent(AddInfo.this, ClassMenu.class);
					startActivity(i);	
	
				}
				
			}
			//Intent i= new Intent("com.example.rememberme.VIEWFRIENDS");
			//startActivity(i);
			
			break;
			
		case R.id.etAddName:
			etName.setText("");
			break;
		
		case R.id.etAddRelation:
			etRelation.setText("");

			break;
			
		case R.id.etAddBD:
			etBD.setText("");

			break;
			
		case R.id.etAddCell:
			etCell.setText("");

			break;
			
		case R.id.etAddEmail:
			etEmail.setText("");

			break;
			
		case R.id.etAddAddress:
			etAddress.setText("");

			break;
		}
		
	
	}

	/*protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}*/
	
}
