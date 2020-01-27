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
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import android.app.AlertDialog;
import android.content.DialogInterface;
import java.util.Timer;
import java.util.TimerTask;
import android.view.View;
import android.text.Editable;
import android.text.TextWatcher;

public class GameActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private Toolbar _toolbar;
	private DrawerLayout _drawer;
	
	private LinearLayout main;
	private LinearLayout output_panel;
	private LinearLayout control_panel;
	private ScrollView output_line;
	private ScrollView logger_line;
	private TextView output;
	private TextView logger;
	private EditText command_line;
	private Button enter;
	private LinearLayout _drawer_drawer_main;
	private EditText _drawer_search;
	private ScrollView _drawer_vscroll1;
	private LinearLayout _drawer_linear2;
	private TextView _drawer_textview5;
	private TextView _drawer_textview7;
	private TextView _drawer_textview14;
	private TextView _drawer_textview8;
	private TextView _drawer_textview9;
	private TextView _drawer_textview10;
	private TextView _drawer_textview13;
	private TextView _drawer_textview24;
	private TextView _drawer_textview23;
	private TextView _drawer_textview22;
	private TextView _drawer_textview21;
	private TextView _drawer_textview11;
	private TextView _drawer_textview12;
	private TextView _drawer_textview15;
	private TextView _drawer_textview16;
	private TextView _drawer_textview17;
	private TextView _drawer_textview18;
	private TextView _drawer_textview19;
	private TextView _drawer_textview20;
	
	private Intent activityChanger = new Intent();
	private SharedPreferences config;
	private AlertDialog.Builder dialog;
	private TimerTask stateChecker;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.game);
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
		_drawer = (DrawerLayout) findViewById(R.id._drawer);ActionBarDrawerToggle _toggle = new ActionBarDrawerToggle(GameActivity.this, _drawer, _toolbar, R.string.app_name, R.string.app_name);
		_drawer.addDrawerListener(_toggle);
		_toggle.syncState();
		
		LinearLayout _nav_view = (LinearLayout) findViewById(R.id._nav_view);
		
		main = (LinearLayout) findViewById(R.id.main);
		output_panel = (LinearLayout) findViewById(R.id.output_panel);
		control_panel = (LinearLayout) findViewById(R.id.control_panel);
		output_line = (ScrollView) findViewById(R.id.output_line);
		logger_line = (ScrollView) findViewById(R.id.logger_line);
		output = (TextView) findViewById(R.id.output);
		logger = (TextView) findViewById(R.id.logger);
		command_line = (EditText) findViewById(R.id.command_line);
		enter = (Button) findViewById(R.id.enter);
		_drawer_drawer_main = (LinearLayout) _nav_view.findViewById(R.id.drawer_main);
		_drawer_search = (EditText) _nav_view.findViewById(R.id.search);
		_drawer_vscroll1 = (ScrollView) _nav_view.findViewById(R.id.vscroll1);
		_drawer_linear2 = (LinearLayout) _nav_view.findViewById(R.id.linear2);
		_drawer_textview5 = (TextView) _nav_view.findViewById(R.id.textview5);
		_drawer_textview7 = (TextView) _nav_view.findViewById(R.id.textview7);
		_drawer_textview14 = (TextView) _nav_view.findViewById(R.id.textview14);
		_drawer_textview8 = (TextView) _nav_view.findViewById(R.id.textview8);
		_drawer_textview9 = (TextView) _nav_view.findViewById(R.id.textview9);
		_drawer_textview10 = (TextView) _nav_view.findViewById(R.id.textview10);
		_drawer_textview13 = (TextView) _nav_view.findViewById(R.id.textview13);
		_drawer_textview24 = (TextView) _nav_view.findViewById(R.id.textview24);
		_drawer_textview23 = (TextView) _nav_view.findViewById(R.id.textview23);
		_drawer_textview22 = (TextView) _nav_view.findViewById(R.id.textview22);
		_drawer_textview21 = (TextView) _nav_view.findViewById(R.id.textview21);
		_drawer_textview11 = (TextView) _nav_view.findViewById(R.id.textview11);
		_drawer_textview12 = (TextView) _nav_view.findViewById(R.id.textview12);
		_drawer_textview15 = (TextView) _nav_view.findViewById(R.id.textview15);
		_drawer_textview16 = (TextView) _nav_view.findViewById(R.id.textview16);
		_drawer_textview17 = (TextView) _nav_view.findViewById(R.id.textview17);
		_drawer_textview18 = (TextView) _nav_view.findViewById(R.id.textview18);
		_drawer_textview19 = (TextView) _nav_view.findViewById(R.id.textview19);
		_drawer_textview20 = (TextView) _nav_view.findViewById(R.id.textview20);
		config = getSharedPreferences("cfg.cfg", Activity.MODE_PRIVATE);
		dialog = new AlertDialog.Builder(this);
		
		output.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		logger.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		enter.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_execute(command_line.getText().toString());
				command_line.setText("");
			}
		});
		
		_drawer_search.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (true) {
					
				}
				else {
					if (true) {
						
					}
					else {
						if (true) {
							
						}
						else {
							if (true) {
								
							}
							else {
								if (true) {
									
								}
								else {
									if (true) {
										
									}
									else {
										if (true) {
											
										}
										else {
											if (true) {
												
											}
											else {
												if (true) {
													
												}
												else {
													if (true) {
														
													}
													else {
														
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
	}
	private void initializeLogic() {
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
		SketchwareUtil.showMessage(getApplicationContext(), "Hello, ".concat(config.getString("login", "")));
		stateChecker = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						logger.setText(logger.getText().toString().concat("\nUser@active"));
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(stateChecker, (int)(0), (int)(1000));
	}
	
	@Override
	public void onStop() {
		super.onStop();
		
	}
	
	@Override
	public void onBackPressed() {
		if (_drawer.isDrawerOpen(GravityCompat.START)) {
			_drawer.closeDrawer(GravityCompat.START);
		}
		else {
			super.onBackPressed();
		}
	}
	private void _execute (final String _cmd) {
		if (_cmd.equals("info")) {
			output.setText(output.getText().toString().concat("\n--------------------\nДобро пожаловать в SCP Console Mobile.\n\nПриложение создано при помощи Sketchware, Google Firebase.\n\nАвтор приложения: PROGOI\n--------------------"));
			_log(1, "Command@info");
		}
		else {
			if (_cmd.equals("help")) {
				output.setText(output.getText().toString().concat("\n\nДоступные команды:\n~ info - Информация о приложении\n~ help - Вывод доступных команд\n~ quit - Выход из приложения"));
				_log(1, "Command@help");
			}
			else {
				if (_cmd.equals("quit")) {
					output.setText(output.getText().toString().concat("\n\nВыход..."));
					_log(1, "Command@quit");
					activityChanger.setClass(getApplicationContext(), LoginActivity.class);
					startActivity(activityChanger);
					finish();
				}
				else {
					if (_cmd.equals("tutorial")) {
						output.setText(output.getText().toString().concat("\n--------------------\nЗапускаю обучение...\n--------------------"));
						_log(1, "Command@tutorial");
						_startTutorial();
					}
					else {
						dialog.setTitle("ОШИБКА");
						dialog.setMessage("Команда не распознана");
						dialog.setPositiveButton("Ок", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								
							}
						});
						dialog.create().show();
					}
				}
			}
		}
	}
	
	
	private void _log (final double _level, final String _string) {
		logger.setText(logger.getText().toString().concat("\n".concat(_string)));
	}
	
	
	private void _startTutorial () {
		dialog.setTitle("1/6");
		dialog.setMessage("Добро пожаловать в SCP Console - текстовый квест по вселенной SCP Foundation от команды PROGOI");
		dialog.setPositiveButton("Next", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				control_panel.setBackgroundColor(0xFF4CAF50);
				dialog.setTitle("2/6");
				dialog.setMessage("Выделенная форма является полем ввода комманд. Все команды мнжно вывести с помощью команды help");
				dialog.setPositiveButton("Далее", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						control_panel.setBackgroundColor(0xFFFFFFFF);
						logger_line.setBackgroundColor(0xFF4CAF50);
						dialog.setTitle("3/6");
						dialog.setMessage("Выделенная форма является логгером. Он хранит память о действиях пользователя.");
						dialog.setPositiveButton("Далее", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								logger_line.setBackgroundColor(0xFFFFFFFF);
								output_line.setBackgroundColor(0xFF4CAF50);
								dialog.setTitle("4/6");
								dialog.setMessage("Выделенная форма является полем вывода. Здесь выводятся результаты работы команд");
								dialog.setPositiveButton("Далее", new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface _dialog, int _which) {
										output_line.setBackgroundColor(0xFF000000);
										_drawer.openDrawer(GravityCompat.START);
										dialog.setTitle("5/6");
										dialog.setMessage("Проведите пальцем по экрану слева направо. Откроется навигационная панель для перехода по папкам и просмотра их содержимого");
										dialog.setPositiveButton("Далее", new DialogInterface.OnClickListener() {
											@Override
											public void onClick(DialogInterface _dialog, int _which) {
												_drawer.closeDrawer(GravityCompat.START);
												dialog.setTitle("6/6");
												dialog.setMessage("На данный момент всё. Больше функционала будет добавлено в последующих обновлениях");
												dialog.setPositiveButton("Зввершить", new DialogInterface.OnClickListener() {
													@Override
													public void onClick(DialogInterface _dialog, int _which) {
														
													}
												});
												dialog.create().show();
											}
										});
										dialog.create().show();
									}
								});
								dialog.create().show();
							}
						});
						dialog.create().show();
					}
				});
				dialog.create().show();
			}
		});
		dialog.setNegativeButton("Выйти", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				
			}
		});
		dialog.create().show();
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
