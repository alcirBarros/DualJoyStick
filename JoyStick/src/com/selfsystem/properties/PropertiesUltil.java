package com.selfsystem.properties;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;


public class PropertiesUltil {
	
	private static PropertiesUltil me;
	private Properties properties;
	
	private PropertiesUltil(){
		properties = new Properties();
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("joyStick.properties");
		try {
			InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
			properties.load(reader);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static PropertiesUltil getInstance(){
		if(me == null){
			me = new PropertiesUltil();
		}
		return me;
	}
	
	public String getProperty(String name){
		return properties.getProperty(name);
	}

}
