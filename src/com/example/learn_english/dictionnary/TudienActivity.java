package com.example.learn_english.dictionnary;


import com.example.learn_english.R;
import com.example.learn_english.R.id;
import com.example.learn_english.R.layout;
import com.example.learn_english.R.menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class TudienActivity extends Activity {
	ImageView giupdo,menuchinh;
	Button tracuu;
	EditText formtracuu;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tudien);
		
		
		tracuu=(Button)findViewById(R.id.buttontracuu);
		formtracuu=(EditText)findViewById(R.id.formtracuu);
		
		giupdo=(ImageView)findViewById(R.id.hinhgiupdo);
		menuchinh=(ImageView)findViewById(R.id.hinhbackmenu);
		
		
		
		tracuu.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String tukhoa=formtracuu.getText().toString();
				
				finish();
				Intent i=new Intent(getApplicationContext(),TracuuActivity.class);
				i.putExtra("tukhoa", tukhoa);
				startActivity(i);
			}
		});
		
		menuchinh.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
//				Intent i=new Intent(getApplicationContext(),MainActivity.class);
//				startActivity(i);
				
			}
		});
	}
	

}
