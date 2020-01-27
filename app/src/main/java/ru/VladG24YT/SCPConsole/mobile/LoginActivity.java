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
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.CompoundButton;

public class LoginActivity extends AppCompatActivity {
	
	
	private Toolbar _toolbar;
	
	private LinearLayout main;
	private ImageView logo;
	private EditText login;
	private EditText password;
	private CheckBox system_stay;
	private Button enter;
	
	private Intent activityChanger = new Intent();
	private AlertDialog.Builder confirmStaying;
	private SharedPreferences config;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.login);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		_toolbar = (Toolbar) findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		main = (LinearLayout) findViewById(R.id.main);
		logo = (ImageView) findViewById(R.id.logo);
		login = (EditText) findViewById(R.id.login);
		password = (EditText) findViewById(R.id.password);
		system_stay = (CheckBox) findViewById(R.id.system_stay);
		enter = (Button) findViewById(R.id.enter);
		confirmStaying = new AlertDialog.Builder(this);
		config = getSharedPreferences("cfg.cfg", Activity.MODE_PRIVATE);
		
		system_stay.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					confirmStaying.create().show();
				}
			}
		});
		
		enter.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				config.edit().putString("login", login.getText().toString()).commit();
				activityChanger.setClass(getApplicationContext(), GameActivity.class);
				activityChanger.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
				startActivity(activityChanger);
				finish();
			}
		});
	}
	private void initializeLogic() {
		confirmStaying.setTitle("Внимание");
		confirmStaying.setMessage("Если вы выберете пункт 'оставаться в системе', функция входа будет полностью отключена. Вы уверены что хотите оставаться в системе?");
		confirmStaying.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				config.edit().putString("isAutoLogin", "true").commit();
			}
		});
		confirmStaying.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				
			}
		});
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
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
