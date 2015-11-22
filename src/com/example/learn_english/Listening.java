package com.example.learn_english;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import android.app.Dialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnShowListener;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

public class Listening extends ListActivity {
	MediaPlayer player;
    double start = 0;
    double stop = 0;
    Handler handler = new Handler();
    TextView view_time, view_all;
    ImageButton play, stop_bt, pause;
    Dialog dialog;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		player = new MediaPlayer();
		player.setAudioStreamType(AudioManager.STREAM_MUSIC);
		
		dialog = new Dialog(Listening.this);
		dialog.setContentView(R.layout.main_listening);
		dialog.setTitle("Now playing .... ");
		view_time = (TextView)dialog.findViewById(R.id.textView1);
		view_all = (TextView)dialog.findViewById(R.id.textView2);
		play = (ImageButton) dialog.findViewById(R.id.imageButton1);
		pause = (ImageButton) dialog.findViewById(R.id.imageButton2);
		stop_bt = (ImageButton) dialog.findViewById(R.id.imageButton3);
		
		List<String> unit = new ArrayList<String>();
		int limit = 200;
		if(unit.size() < limit) {
			unit.add("\t" + "\t" + "\t" + "Unit 1");
			unit.add("C : Photo story - Page 3");
			unit.add("A : Read & listen - Page 4");
			unit.add("B : Rhythm & intonation - Page 4");
			unit.add("A : Pronunciation - Page 5");
			unit.add("A : Vocabulary - Page 6");
			unit.add("B : Listening comprehension - Page 7");
			unit.add("A : Read & listen - Page 7");
			unit.add("B : Rhythm & intonation - Page 7");
			unit.add("Reading - Page 8");
			unit.add("A : Vocabulary - Page 10");
			unit.add("A : Listening comprehension - Page 10");
			unit.add("B : Listening comprehension - Page 11");
			unit.add("A : Listening comprehension - Page 12");
			unit.add("Unit 1 pop song");
			unit.add("\t" + "\t" + "\t" + "Unit 2");
			unit.add("C : Photo story - Page 15");
			unit.add("A : Read & listen - Page 16");
			unit.add("C : Listening comprehension - Page 17");
			unit.add("Pronunciation - Page 17");
			unit.add("A : Read & listen - Page 17");
			unit.add("B : Rhythm & intonation - Page 17");
			unit.add("A : Read & listen - Page 18");
			unit.add("C : Listening comprehension - Page 18");
			unit.add("A : Read & listen - Page 19");
			unit.add("B : Rhythm & intonation - Page 19");
			unit.add("A : Vocabulary - Page 20");
			unit.add("A : Listening comprehension - Page 20");
			unit.add("B : Listening comprehension - Page 20");
			unit.add("C : Listening comprehension - Page 20");
			unit.add("Reading - Page 22");
			unit.add("A : Listening comprehension - Page 24");
			unit.add("Unit 2 pop song");
		}
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(Listening.this, 
										R.layout.list, R.id.output, unit);
		setListAdapter(adapter);
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		dialog.setOnCancelListener(new OnCancelListener() {
			
			@Override
			public void onCancel(DialogInterface dialog) {
				// TODO Auto-generated method stub
				try {
				player.stop();
				player.reset();
				player.prepare();
				view_time.setVisibility(View.VISIBLE);
				view_all.setVisibility(View.VISIBLE);
				play.setEnabled(true);
				pause.setEnabled(true);
				} 
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		dialog.setOnShowListener(new OnShowListener() {
			
			@Override
			public void onShow(DialogInterface dialog) {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(3000);
				} 
				catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
				view_time.setVisibility(View.VISIBLE);
				view_all.setVisibility(View.VISIBLE);
				play.setEnabled(true);
				pause.setEnabled(true);
				} 
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		play.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
				player.start();
				start = player.getCurrentPosition();
				handler.postDelayed(UpdateTime, 100);
				stop = player.getDuration();
				start = player.getCurrentPosition();
				view_all.setText(String.format("%d min, %d sec", 
						TimeUnit.MILLISECONDS.toMinutes((long) stop), 
						TimeUnit.MILLISECONDS.toSeconds((long) stop) - 
					TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)stop))));
				
				view_time.setText(String.format("%d min, %d sec", 
						TimeUnit.MILLISECONDS.toMinutes((long) start), 
						TimeUnit.MILLISECONDS.toSeconds((long) start), 
					TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)start))));;
				handler.postDelayed(UpdateTime, 100);
				player.start();
					}
				catch(Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		stop_bt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
				player.stop();
				Toast.makeText(Listening.this, 
							"Touch a list again to play", Toast.LENGTH_SHORT).show();
				view_time.setVisibility(View.GONE);
				view_all.setVisibility(View.GONE);
				play.setEnabled(false);
				pause.setEnabled(false);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}	
		});
		pause.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				player.pause();
			}
		});
		
		// tạo object để click vào
		Object main = l.getItemAtPosition(position);
		// click  vào thành phần con
		 /*-------------- Start single item click --------------*/
		final Object item1 = l.getItemAtPosition(1);
		if(main.equals(item1)) {
String e1 = "http://androidaudio.weebly.com/uploads/6/5/2/4/65244517/1_02_c_photo_story_p03.mp3";
			try {
				player.setDataSource(e1);
				player.prepareAsync();
				player.prepare();
			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dialog.show();
		}
		
		final Object item2 = l.getItemAtPosition(2);
		if(main.equals(item2)) {
String e2 = "http://androidaudio.weebly.com/uploads/6/5/2/4/65244517/1-03_a_conversation_mode_p04.mp3";
			try {
				player.setDataSource(e2);
				player.prepareAsync();
				player.prepare();
			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dialog.show();
		}
		
		final Object item3 = l.getItemAtPosition(3);
		if(main.equals(item3)) {
String e3 = "";
			try {
				player.setDataSource(e3);
				player.prepareAsync();
				player.prepare();
			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dialog.show();
		}
		
		final Object item4 = l.getItemAtPosition(4);
		if(main.equals(item4)) {
String e4 = "";
			try {
				player.setDataSource(e4);
				player.prepareAsync();
				player.prepare();
			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dialog.show();
		}
		
		final Object item5 = l.getItemAtPosition(5);
		if(main.equals(item5)) {
String e5 = "";
			try {
				player.setDataSource(e5);
				player.prepareAsync();
				player.prepare();
			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dialog.show();
		}				
	}
	
	

	private Runnable UpdateTime	= new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			start = player.getCurrentPosition();
			view_time.setText(String.format("%d min, %d sec",
			         
			         TimeUnit.MILLISECONDS.toMinutes((long) start),
			         TimeUnit.MILLISECONDS.toSeconds((long) start) -
			         TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
			         toMinutes((long) start)))
			         );
			handler.postDelayed(UpdateTime, 100);
		}
	};	
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Toast.makeText(Listening.this, "Touch on list to play", Toast.LENGTH_SHORT).show();
	}
}
