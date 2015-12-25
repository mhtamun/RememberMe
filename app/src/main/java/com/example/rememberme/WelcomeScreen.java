package com.example.rememberme;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class WelcomeScreen extends Activity{
	
	MediaPlayer song;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);
		
		 song=MediaPlayer.create(WelcomeScreen.this,R.raw.transformer);
			song.start();
			
			 Thread timer= new Thread(){
					
					public void run(){
						
						try{
							
							sleep(5000);
						}catch(InterruptedException e){
							e.printStackTrace();
							
						}finally{
							Intent in=new Intent(WelcomeScreen.this,ClassMenu.class);
							
							startActivity(in);
						}
					}
				};
				
				timer.start();
			}

			@Override
			protected void onPause() {
				// TODO Auto-generated method stub
				super.onPause();
				song.release();
				finish();
			}
		
	}
	
