package com.example.rememberme;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SmsSender extends Activity implements View.OnClickListener{

    final Context context = this;
    Button btnStatus;
    
    String message = "Happy Birthday Dear";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sms);

         final EditText ed=(EditText) findViewById(R.id.editText);
         final TextView txtV=(TextView) findViewById(R.id.textView1);


        btnStatus = (Button) findViewById(R.id.btnGetStatus);
        btnStatus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            	final String name = ed.getText().toString();
            	
            	database ser = new database(SmsSender.this);
				ser.open();
				//String returnedname = ser.getName(l);
				//String returnedrelation = ser.getRelation(l);
				//String returnedbday = ser.getBday(l);
				
				String SearchData = ser.getNamebyName(name);
				
				ser.close();

                if(SearchData.length() == name.length())
                {

                    AlertDialog.Builder altBuilder= new AlertDialog.Builder(context);
                    altBuilder.setTitle("Warning !!!");
                    altBuilder
                            .setMessage("Match found ! Send SMS to "+ ed.getText().toString() + "..")
                            .setCancelable(false)
                            .setPositiveButton("Proceed", new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // TODO Auto-generated method stub
                                	
                    				//long l = Long.parseLong(name);
                    				database ser = new database(SmsSender.this);
                    				ser.open();
                    				//String returnedname = ser.getName(l);
                    				//String returnedrelation = ser.getRelation(l);
                    				//String returnedbday = ser.getBday(l);
                    				
                    				String cellNo = ser.getCellbyName(name);
                    				
                    				ser.close();
                                	
                                    dialog.cancel();
                                    txtV.setText("Cell No. - " + cellNo);
                                    //SmsManager smsManager = SmsManager.getDefault();
                                    SendSMS(cellNo,message);
                                }
                            })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // TODO Auto-generated method stub
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alertDialog = altBuilder.create();
                    alertDialog.show();


                    /*CharSequence text = "Your Request have been Sent !!";
                    // Shows a toast message....
                    Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
                    toast.show();
                    toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);*/
                }
                else if(SearchData!=name)
                {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                    alertDialogBuilder.setTitle("Warning !!!");
                    alertDialogBuilder
                            .setMessage("Enter a valid Name !!")
                            .setCancelable(false)
                            .setNegativeButton(" OK ",new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {
                                    // if this button is clicked, close the alert box.....
                                    dialog.cancel();
                                }
                              });
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                }
            }

            private void SendSMS(String phonenumber, String message) {

                /*SmsManager sms=SmsManager.getDefault();
                sms.sendTextMessage(phonenumber, null, message, null, null);*/
                //'''''''''''''''''''''''''''''''
                String SENT = "SMS_SENT";
                String DELIVERED = "SMS_DELIVERED";

                PendingIntent sentPI = PendingIntent.getBroadcast(context, 0,
                    new Intent(SENT), 0);

                PendingIntent deliveredPI = PendingIntent.getBroadcast(context, 0,
                    new Intent(DELIVERED), 0);

                //---when the SMS has been sent---
                registerReceiver(new BroadcastReceiver(){
                    @Override
                    public void onReceive(Context context, Intent intent) {
                        switch (getResultCode())
                        {
                            case Activity.RESULT_OK:
                                Toast.makeText(getBaseContext(), "Your SMS has been Sent !!", 
                                        Toast.LENGTH_SHORT).show();
                                break;
                            case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                                Toast.makeText(getBaseContext(), "Generic failure", 
                                        Toast.LENGTH_SHORT).show();
                                break;
                            case SmsManager.RESULT_ERROR_NO_SERVICE:
                                Toast.makeText(getBaseContext(), "No service", 
                                        Toast.LENGTH_SHORT).show();
                                break;
                            case SmsManager.RESULT_ERROR_NULL_PDU:
                                Toast.makeText(getBaseContext(), "Null PDU", 
                                        Toast.LENGTH_SHORT).show();
                                break;
                            case SmsManager.RESULT_ERROR_RADIO_OFF:
                                Toast.makeText(getBaseContext(), "Radio off", 
                                        Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                }, new IntentFilter(SENT));

                //---when the SMS has been delivered---
                registerReceiver(new BroadcastReceiver(){
                    @Override
                    public void onReceive(Context context, Intent intent) {
                        switch (getResultCode())
                        {
                            case Activity.RESULT_OK:
                                Toast.makeText(getBaseContext(), "SMS delivered", 
                                        Toast.LENGTH_SHORT).show();
                                break;
                            case Activity.RESULT_CANCELED:
                                Toast.makeText(getBaseContext(), "SMS not delivered", 
                                        Toast.LENGTH_SHORT).show();
                                break;                      
                        }
                    }
                }, new IntentFilter(DELIVERED));        

                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage(phonenumber, null, message, sentPI, deliveredPI);               
            }    

        });

    }

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}
}