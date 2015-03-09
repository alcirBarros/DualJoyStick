package com.selfsystem.proxy;

import java.io.Serializable;

public abstract class RequisicaoClienteRest implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public static final int JOYSTICK = 1;
	
	private int tipo;
	private Long joyStickId = 111l;
	
	public RequisicaoClienteRest(int tipo){
		this.tipo = tipo;
	}

	public Long getJoyStickId() {
		return joyStickId;
	}

	public void setJoyStickId(Long joyStickId) {
		this.joyStickId = joyStickId;
	}

	public int getTipo() {
		return tipo;
	}
}
