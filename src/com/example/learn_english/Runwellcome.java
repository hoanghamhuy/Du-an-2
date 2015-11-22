package com.example.learn_english;


import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Runwellcome  extends Activity {
	MediaPlayer nhacnen;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_runwellcome);
		
		nhacnen=MediaPlayer.create(Runwellcome.this, R.raw.chaomung);
		nhacnen.start();
		
		Thread bamgio=new Thread(){
			public void run(){
				try{
					sleep(4000);
					
					
				} catch (Exception e){
					
				} finally{
					Intent activitymoi=
							new Intent(getApplicationContext(),MainActivity.class);
					startActivity(activitymoi);
				}
			}
		};
		bamgio.start();
		
	}
	
	protected void onPause(){
		super.onPause();
		nhacnen.release();
		finish();
	}
}
