package ru.VladG24YT.SCPConsole.mobile;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.graphics.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.text.*;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import java.util.Timer;
import java.util.TimerTask;
import android.content.Intent;
import android.net.Uri;
import android.media.MediaPlayer;

public class MainActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private double l = 0;
	
	private ImageView logo;
	
	private TimerTask logoChanger;
	private Intent activityChanger = new Intent();
	private MediaPlayer backgroundMusic;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		logo = (ImageView) findViewById(R.id.logo);
	}
	private void initializeLogic() {
		backgroundMusic = MediaPlayer.create(getApplicationContext(), R.raw.logos_theme);
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	@Override
	public void onStart() {
		super.onStart();
		backgroundMusic.start();
		l = 0;
		logoChanger = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						if (l == 0) {
							logo.setImageResource(R.drawable.sketchware_logo);
						}
						else {
							if (l == 1) {
								logo.setImageResource(R.drawable.built_with_firebase);
							}
							else {
								if (l == 2) {
									logo.setImageResource(R.drawable.progoi_logo);
								}
								else {
									if (l == 3) {
										activityChanger.setClass(getApplicationContext(), LoginActivity.class);
										activityChanger.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
										startActivity(activityChanger);
										finish();
									}
								}
							}
						}
						l++;
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(logoChanger, (int)(3000), (int)(2000));
	}
	
	@Override
	public void onStop() {
		super.onStop();
		backgroundMusic.pause();
		logoChanger.cancel();
	}
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}
