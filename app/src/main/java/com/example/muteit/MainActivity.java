package com.example.muteit;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TimePicker;

public class MainActivity extends Activity {

	Button btnButton;
	TimePicker timeFrom,timeTo;
	SharedPreferences pref;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_setup_event);
		pref = getSharedPreferences("MuteItPref", MODE_PRIVATE);
//		btnButton = (Button) findViewById(R.id.button1);

		timeFrom = (TimePicker) findViewById(R.id.timePicker1);
		timeTo = (TimePicker) findViewById(R.id.timePicker2);

		btnButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				addSharedPreferences();
				startTestService();

			}
		});

	}

	protected void startTestService() {
		Intent service=new Intent(MainActivity.this,TestService.class);
		startService(service);
	}

	protected void addSharedPreferences() {
		SharedPreferences.Editor edit = pref.edit();
		// Storing Access Token using SharedPreferences
		edit.putString("hourFrom", timeFrom.getCurrentHour().toString());
		edit.putString("minuteFrom", timeFrom.getCurrentMinute().toString());
		edit.putString("hourTo", timeTo.getCurrentHour().toString());
		edit.putString("minuteTo", timeTo.getCurrentMinute().toString());
		edit.commit();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
