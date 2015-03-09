package com.selfsystem.activity;

import com.selfsystem.joystick.DualJoyStickView;
import com.selfsystem.joystick.JoystickView;
import com.selfsystem.joystick.JoystickView.OnJoystickMoveListener;
import com.selfsystem.joystick.R;
import com.selfsystem.joystick.R.layout;
import com.selfsystem.joystick.R.menu;
import com.selfsystem.proxy.rest.ProxyClienteRest;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity {
	
	private DualJoyStickView dualJoyStickView;
	private ProxyClienteRest proxyClienteRest = new ProxyClienteRest(); 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		final Button buttonA = (Button) findViewById(R.id.button_A);
		final Button buttonB = (Button) findViewById(R.id.button_B);
		final Button buttonC = (Button) findViewById(R.id.button_C);
		
		
		dualJoyStickView = (DualJoyStickView) findViewById(R.id.dualjoystickView);
		
		dualJoyStickView.getJoyStickL().setOnJoystickMoveListener(new OnJoystickMoveListener() { 
			public void onValueChanged(int angle, int power, int direction) {
        	   proxyClienteRest.joyStickRest(angle, power, direction, "stickL"); 
            }
        }, JoystickView.DEFAULT_LOOP_INTERVAL);
		
		dualJoyStickView.getJoyStickR().setOnJoystickMoveListener(new OnJoystickMoveListener() {
           public void onValueChanged(int angle, int power, int direction) {
        	   proxyClienteRest.joyStickRest(angle, power, direction, "stickR");         	   
            }
        }, JoystickView.DEFAULT_LOOP_INTERVAL);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
