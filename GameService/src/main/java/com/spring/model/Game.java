package com.spring.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Game {

	@Id
    private int id;
    private  String GName;
	
	public Game() {
		
	}
	
	public Game(int id,String GName) {
		this.id = id;
		this.GName = GName;
	}

	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getGName() {
		return this.GName;
	}
	public void setGName(String GName) {
		this.GName = GName;
	}
}
