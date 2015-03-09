# DualJoyStick
Projetos-JoyStick
=============

![zerokol.com](http://2.bp.blogspot.com/-5iIoZXBw2bg/T1n753kamDI/AAAAAAAAAxo/CjU5hGy4QbY/s400/joystickview-screen.png)

## JoystickView - Android

Android JoystickView is a Custom View that simulates a Joystick for interactive applications for Android, 
as simple aim is allows access values ​​of angle and power of the virtual Joystck movement.

### Advanced Usage

If you want to change or upgrade some feature of the library, you should do:

1º Step: Clone the project or download this project to your workspace eclipse IDE, then:

2º Step Go to eclipse' menu FILE, after IMPORT.

![zerokol.com](http://3.bp.blogspot.com/-JyhVCfOVVsU/T1kcx_mHozI/AAAAAAAAAwg/vCR7wNkH0r8/s320/fig02.jpg)

3º Step: Now click in "Existing Project into Workspace"

![zerokol.com](http://1.bp.blogspot.com/---LpF1fGsb0/T1kcyoeRt4I/AAAAAAAAAwo/lPH4FOd3lsc/s400/fig03.jpg)

4º Step: Click in Browse e search the source code folder where you placed after clone ou download.

![zerokol.com](http://1.bp.blogspot.com/-cjLe2ZmRPyo/T1kczcBbfdI/AAAAAAAAAww/hYVnWf9mtEE/s320/fig04.jpg)

5º Step: Setup with Next or/and Finish, ant the JoystickView is ready to you use in your applications.

![zerokol.com](http://3.bp.blogspot.com/-w6ETTjggahI/T1kc0IDonsI/AAAAAAAAAw4/2r6r-WIxmLU/s320/fig05.jpg)

6º Step: Import JoystickView in your applications.

To use JoystickView in your applications, simply add the lib to the classpath of your application:

7º Passo: Click with right button on your project go to PROPERTIES -> ANDROID and the ADD.

![zerokol.com](http://2.bp.blogspot.com/-w7W8Gb8kh0I/T1kfgqoNrQI/AAAAAAAAAxA/_0cHWx-ox2E/s320/imp.png)

8º Step: Select JoystickView lib and click OK to finish.

![zerokol.com](http://1.bp.blogspot.com/-E7M8dJuemEU/T1kfhcZoWmI/AAAAAAAAAxI/Lurmtt5p8l0/s320/imp2.png)

### SHOW THE CODE

From this point you can inflate the JoystickView in your layouts or referencing it in your Activities.

```java
import com.zerokol.views.JoystickView;
import com.zerokol.views.JoystickView.OnJoystickMoveListener;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class JoystickViewDemoActivity extends Activity {
	private TextView angleTextView;
	private TextView powerTextView;
	private TextView directionTextView;
	// Importing also other views
	private JoystickView joystick;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		angleTextView = (TextView) findViewById(R.id.angleTextView);
		powerTextView = (TextView) findViewById(R.id.powerTextView);
		directionTextView = (TextView) findViewById(R.id.directionTextView);
		//Referencing also other views
		joystick = (JoystickView) findViewById(R.id.joystickView);
        
        //Event listener that always returns the variation of the angle in degrees, motion power in percentage and direction of movement
		joystick.setOnJoystickMoveListener(new OnJoystickMoveListener() {

			@Override
			public void onValueChanged(int angle, int power, int direction) {
				// TODO Auto-generated method stub
				angleTextView.setText(" " + String.valueOf(angle) + "°");
				powerTextView.setText(" " + String.valueOf(power) + "%");
				switch (direction) {
				case JoystickView.FRONT:
					directionTextView.setText(R.string.front_lab);
					break;
				case JoystickView.FRONT_RIGHT:
					directionTextView.setText(R.string.front_right_lab);
					break;
				case JoystickView.RIGHT:
					directionTextView.setText(R.string.right_lab);
					break;
				case JoystickView.RIGHT_BOTTOM:
					directionTextView.setText(R.string.right_bottom_lab);
					break;
				case JoystickView.BOTTOM:
					directionTextView.setText(R.string.bottom_lab);
					break;
				case JoystickView.BOTTOM_LEFT:
					directionTextView.setText(R.string.bottom_left_lab);
					break;
				case JoystickView.LEFT:
					directionTextView.setText(R.string.left_lab);
					break;
				case JoystickView.LEFT_FRONT:
					directionTextView.setText(R.string.left_front_lab);
					break;
				default:
					directionTextView.setText(R.string.center_lab);
				}
			}
		}, JoystickView.DEFAULT_LOOP_INTERVAL);
	}
}
```

This is an implementation of a custom android view that works like a Joystick, this view controls two variables, angle motion and power motion of the screen touch.

[![Creative Commons](http://i.creativecommons.org/l/by-sa/3.0/88x31.png)](http://creativecommons.org/licenses/by-sa/3.0/)

JoystickView by [AJ Alves](https://github.com/alcirBarros) is licensed under a [Creative Commons Attribution-ShareAlike 3.0 Unported License](http://creativecommons.org/licenses/by-sa/3.0/).
Based on a work at [github.com](https://github.com/alcirBarros/Projetos-Base/blob/master/Android/JoystickView-master) and page.
Permissions beyond the scope of this license may be available at [https://github.com/alcirBarros](https://github.com/alcirBarros).
