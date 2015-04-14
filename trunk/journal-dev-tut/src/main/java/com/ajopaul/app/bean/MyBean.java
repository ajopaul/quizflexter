package com.ajopaul.app.bean;

import java.io.Serializable;

public class MyBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1129402159048345204L;
	int id;
	String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
