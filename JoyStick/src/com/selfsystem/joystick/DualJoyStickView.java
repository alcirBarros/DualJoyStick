package com.selfsystem.joystick;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class DualJoyStickView extends LinearLayout {

	private JoystickView joyStickL;
	private JoystickView joyStickR;

	private View pad;

	Context context;

	public DualJoyStickView(Context context) {
		super(context);
		joyStickL = new JoystickView(context);
		joyStickR = new JoystickView(context);
		this.context = context;
		initDualJoystickView();
	}

	public DualJoyStickView(Context context, AttributeSet attrs) {
		super(context, attrs);
		joyStickL = new JoystickView(context, attrs, false);
		joyStickR = new JoystickView(context, attrs, true);
		this.context = context;
		initDualJoystickView();
	}

	private void initDualJoystickView() {

		joyStickL.setbuttonColor(Color.rgb(0x70, 0x20, 0x20));
		joyStickR.setbuttonColor(Color.rgb(0x20, 0x50, 0x30));

		pad = new View(getContext());
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		removeView(joyStickL);
		removeView(joyStickR);

		float padW = getMeasuredWidth() - (getMeasuredHeight() * 2);
		int joyWidth = (int) ((getMeasuredWidth() - padW) / 2);
		LayoutParams joyLParams = new LayoutParams(joyWidth,
				getMeasuredHeight());

		joyStickL.setLayoutParams(joyLParams);
		joyStickR.setLayoutParams(joyLParams);

		addView(joyStickL);
		ViewGroup.LayoutParams padLParams = new ViewGroup.LayoutParams(
				(int) padW, getMeasuredHeight());

		removeView(pad);

		pad.setLayoutParams(padLParams);

		addView(pad);

		addView(joyStickR);
		//
		// Button button = new Button(context);
		// button.setText("Teste");
		//
		// addView(button);
	}

	public JoystickView getJoyStickL() {
		return joyStickL;
	}

	public JoystickView getJoyStickR() {
		return joyStickR;
	}
}
