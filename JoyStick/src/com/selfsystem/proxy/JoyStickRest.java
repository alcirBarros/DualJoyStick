package com.selfsystem.proxy;

public class JoyStickRest extends RequisicaoClienteRest {
	
	private static final long serialVersionUID = 1L;
	
	private int angle;
	private int power;
	private int direction;

	public JoyStickRest() {
		super(JOYSTICK);
	}

	public int getAngle() {
		return angle;
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
}
