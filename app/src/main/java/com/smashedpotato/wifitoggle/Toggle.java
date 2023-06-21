package com.smashedpotato.wifitoggle;

import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.Toast;
import android.app.Activity;
import android.content.Context;

public class Toggle extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

try {
	WifiManager wifiManager = (WifiManager) this.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
	//WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
	if (wifiManager == null) {
		end("\n   Wifi not found   \n");
	} else {
		if (wifiManager.isWifiEnabled()) {
			wifiManager.setWifiEnabled(false);
			end("\n   Wifi Disabled   \n");
		} else {
			wifiManager.setWifiEnabled(true);
			end("\n   Wifi Enabled   \n");
		}
	}
}
catch(Exception e){}
	}
	private void end(String result){
		try {
			Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
			finish();
		}
		catch(Exception e){}

	}
	protected void onFinish(){
		try {
		    Thread.sleep(1000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		android.os.Process.killProcess(android.os.Process.myPid());
	}
}



