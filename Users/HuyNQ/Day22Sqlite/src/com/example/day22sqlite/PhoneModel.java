package com.example.day22sqlite;

public class PhoneModel {
	String phoneName;
	int quantity;
	int id;
	
	public PhoneModel(int id, String phoneName, int quantity){
		this.id = id;
		this.phoneName = phoneName;
		this.quantity = quantity;
	}
}
