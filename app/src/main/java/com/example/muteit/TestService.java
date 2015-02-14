package com.example.muteit;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.widget.Toast;

public class TestService extends Service {

	SharedPreferences pref;
	String hourFrom,hourTo,minuteFrom,minuteTo;
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		pref = getSharedPreferences("MuteItPref", MODE_PRIVATE);
		hourFrom=pref.getString("hourFrom", "");
		minuteFrom=pref.getString("minuteFrom", "");
		hourTo=pref.getString("hourTo", "");
		minuteTo=pref.getString("minuteTo", "");

		Toast.makeText(TestService.this, hourFrom+":"+minuteFrom+" , "+hourTo+":"+minuteTo,
				Toast.LENGTH_LONG).show();

		return super.onStartCommand(intent, flags, startId);

	}

}
