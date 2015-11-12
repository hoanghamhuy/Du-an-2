package com.example.learn_english_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Welcome extends Activity {
	public static int WELCOME = 4000;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.welcome_screen);
	      // chạy màn hình khởi động app
	      new Handler().postDelayed(new Runnable() {
	         @Override
	         public void run() {
	            Intent i = new Intent(Welcome.this, MainActivity.class);
	            startActivity(i);
	            finish();
	         }
	      }, WELCOME);
		}
	}	
