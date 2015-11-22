package com.example.learn_english;

import com.example.learn_english.dictionnary.TudienActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MainActivity extends Activity {
	MediaPlayer nhacnen;
	ImageView tudien, listening, exit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//------------------------------------------
		tudien= (ImageView) findViewById(R.id.img_item5);
		listening = (ImageView) findViewById(R.id.img_item1);
		exit = (ImageView) findViewById(R.id.img_item8);
		//-------------------set nhac chon hcu nang------------------------
		nhacnen=MediaPlayer.create(MainActivity.this, R.raw.chonchucnang);
		nhacnen.start();
		//------------set su kien --------------------------------------
		tudien.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, TudienActivity.class );
				startActivity(intent);
				
			}
		});
		
		listening.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, Listening.class);
				startActivity(intent);
			}
		});
		
		exit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
				System.exit(0);
			}
		});
	}
	
}
