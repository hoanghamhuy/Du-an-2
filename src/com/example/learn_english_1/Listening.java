package com.example.learn_english_1;

import java.io.IOException;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

import android.app.Dialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.media.*;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

public class Listening extends ListActivity {
	MediaPlayer player;
    public static ProgressDialog pd;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		player = new MediaPlayer();
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
		ArrayAdapter<String> adapter = new ArrayAdapter<>(Listening.this, android.R.layout.simple_list_item_1, unit);
		getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		getListView().setDividerHeight(2);
		setListAdapter(adapter);
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		final Dialog dialog = new Dialog(Listening.this);
		dialog.setContentView(R.layout.listening);
		dialog.setTitle("Now playing .... ");
		final ImageButton playPause = (ImageButton) dialog.findViewById(R.id.imageButton1);
		final ImageButton stop = (ImageButton) dialog.findViewById(R.id.imageButton2);
		playPause.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(!player.isPlaying()) {
					player.start();
					pd = ProgressDialog.show(Listening.this, null, "Waiting for a moment ... ", true);
					pd.setCanceledOnTouchOutside(true);
					playPause.setImageResource(R.drawable.button46);
				}
				else {	
					playPause.setImageResource(R.drawable.play128);
					pd = ProgressDialog.show(Listening.this, null, "Waiting for a moment ... ", true);
					player.pause();
					pd.setCanceledOnTouchOutside(true);
				}
			}
		});
		stop.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					if(player.isPlaying()) {
						player.stop();
						player.seekTo(0);
						pd = ProgressDialog.show(Listening.this, null, "Waiting for a moment ... ", true);
						pd.setCanceledOnTouchOutside(true);
						playPause.setImageResource(R.drawable.play128);
					}
				Toast.makeText(Listening.this, "Touch on list again to play", Toast.LENGTH_SHORT).show();
				}
				catch(Exception e) {
					e.printStackTrace();
					}
				}
		});
		
		player.setAudioStreamType(AudioManager.STREAM_MUSIC);
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
			catch (IllegalArgumentException | SecurityException
					| IllegalStateException | IOException e) {
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
			catch (IllegalArgumentException | SecurityException
					| IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dialog.show();
		}
		
		final Object item3 = l.getItemAtPosition(3);
		if(main.equals(item3)) {
			String e3 = "http://androidaudio.weebly.com/uploads/6/5/2/4/65244517/1-04_b_rhythm_and_intona_p04.mp3";
			try {
				player.setDataSource(e3);
				player.prepareAsync();
				player.prepare();
			} 
			catch (IllegalArgumentException | SecurityException
					| IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dialog.show();
		}
		
		final Object item4 = l.getItemAtPosition(4);
		if(main.equals(item4)) {
			String e4 = "http://androidaudio.weebly.com/uploads/6/5/2/4/65244517/1-05_a_pronunciation_p05.mp3";
			try {
				player.setDataSource(e4);
				player.prepareAsync();
				player.prepare();
			} 
			catch (IllegalArgumentException | SecurityException
					| IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dialog.show();
		}
		
		final Object item5 = l.getItemAtPosition(5);
		if(main.equals(item5)) {
			String e5 = "http://androidaudio.weebly.com/uploads/6/5/2/4/65244517/1-06_a_vocabulary_p06.mp3";
			try {
				player.setDataSource(e5);
				player.prepareAsync();
				player.prepare();
			} 
			catch (IllegalArgumentException | SecurityException
					| IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dialog.show();
		}
		
		final Object item6 = l.getItemAtPosition(6);
		if(main.equals(item6)) {
			String e6 = "http://androidaudio.weebly.com/uploads/6/5/2/4/65244517/1-07_b_listening_compreh_p07.mp3";
			try {
				player.setDataSource(e6);
				player.prepareAsync();
				player.prepare();
			} 
			catch (IllegalArgumentException | SecurityException
					| IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dialog.show();
		}
		
		final Object item7 = l.getItemAtPosition(7);
		if(main.equals(item7)) {
			String e7 = "http://androidaudio.weebly.com/uploads/6/5/2/4/65244517/1-08_a_conversation_mode_p07.mp3";
			try {
				player.setDataSource(e7	);
				player.prepareAsync();
				player.prepare();
			} 
			catch (IllegalArgumentException | SecurityException
					| IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dialog.show();
		}
		
		final Object item8 = l.getItemAtPosition(8);
		if(main.equals(item8)) {
			String e8 = "http://androidaudio.weebly.com/uploads/6/5/2/4/65244517/1-09_b_rhythm_and_intona_p07.mp3";
			try {
				player.setDataSource(e8);
				player.prepareAsync();
				player.prepare();
			} 
			catch (IllegalArgumentException | SecurityException
					| IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dialog.show();
		}
		
		final Object item9 = l.getItemAtPosition(9);
		if(main.equals(item9)) {
			String e9 = "http://androidaudio.weebly.com/uploads/6/5/2/4/65244517/1-10_reading_p08.mp3";
			try {
				player.setDataSource(e9);
				player.prepareAsync();
				player.prepare();
			} 
			catch (IllegalArgumentException | SecurityException
					| IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dialog.show();
		}
		
		final Object item10 = l.getItemAtPosition(10);
		if(main.equals(item10)) {
			String e10 = "http://androidaudio.weebly.com/uploads/6/5/2/4/65244517/1-11_a_vocabulary_p10.mp3";
			try {
				player.setDataSource(e10);
				player.prepareAsync();
				player.prepare();
			} 
			catch (IllegalArgumentException | SecurityException
					| IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dialog.show();
		}
		
		final Object item11 = l.getItemAtPosition(11);
		if(main.equals(item11)) {
			String e11 = "http://androidaudio.weebly.com/uploads/6/5/2/4/65244517/1-12_a_listen_to_associa_p10.mp3";
			try {
				player.setDataSource(e11);
				player.prepareAsync();
				player.prepare();
			} 
			catch (IllegalArgumentException | SecurityException
					| IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dialog.show();
		}
		
		final Object item12 = l.getItemAtPosition(12);
		if(main.equals(item12)) {
			String e12 = "http://androidaudio.weebly.com/uploads/6/5/2/4/65244517/1-13_b_listen_for_detail_p11.mp3";
			try {
				player.setDataSource(e12);
				player.prepareAsync();
				player.prepare();
			} 
			catch (IllegalArgumentException | SecurityException
					| IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dialog.show();
		}

		final Object item13 = l.getItemAtPosition(13);
		if(main.equals(item13)) {
			String e13 = "http://androidaudio.weebly.com/uploads/6/5/2/4/65244517/1-14_a_listening_compreh_p12.mp3";
			try {
				player.setDataSource(e13);
				player.prepareAsync();
				player.prepare();
			} 
			catch (IllegalArgumentException | SecurityException
					| IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dialog.show();
		}
		
		final Object item14 = l.getItemAtPosition(14);
		if(main.equals(item14)) {
			String e14 = "http://androidaudio.weebly.com/uploads/6/5/2/4/65244517/1-15_song_greetings_and_p12.mp3";
			try {
				player.setDataSource(e14);
				player.prepareAsync();
				player.prepare();
			} 
			catch (IllegalArgumentException | SecurityException
					| IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dialog.show();
		}
		
		final Object item15 = l.getItemAtPosition(15);
		if(main.equals(item15)) {
			String e15 = "http://androidaudio.weebly.com/uploads/6/5/2/4/65244517/1-16_karaoke_greetings_a_p12.mp3";
			try {
				player.setDataSource(e15);
				player.prepareAsync();
				player.prepare();
			} 
			catch (IllegalArgumentException | SecurityException
					| IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dialog.show();
		}
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		pd = ProgressDialog.show(Listening.this, null, "Connecting ... ", true);
		pd.setCancelable(true);
	}
}
		
        
/*        List<String> unit = new ArrayList<String>();
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
 
        List<String> u3 = new ArrayList<String>();
        u3.add("A : Vocabulary - Page 26");
        u3.add("C : Photo story - Page 27");
        u3.add("A : Read & listen - Page 29");
        u3.add("B : Rhythm & intonation - Page 29");
        u3.add("C : Listening comprehension - Page 29");
        u3.add("A : Read & listen - Page 30");
        u3.add("B : Rhythm & intonation - Page 30");
        u3.add("C : Listening comprehension - Page 31");
        u3.add("A : Pronunciation - Page 31");
        u3.add("A : Vocabulary - Page 32");
        u3.add("A : Listening comprehension - Page 32");
        u3.add("B : Listening comprehension - Page 32");
        u3.add("Reading - Page 34");
        u3.add("A : Listening comprehension - Page 36");
        u3.add("Unit 3 pop song");*/
