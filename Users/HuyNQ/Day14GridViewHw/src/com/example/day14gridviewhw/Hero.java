package com.example.day14gridviewhw;

public class Hero {
	String name;
	int price;
	int like;
	int pathIndex;
	boolean isLike;
	
	public Hero(String name, int price, int like, int pathIndex, boolean isLike){
		this.name = name;
		this.price = price;
		this.like = like;
		this.pathIndex = pathIndex;
	}
	
	public String GetName(){
		return name;
	}
	
	public int GetPrice(){
		return price;
	}
	
	public int GetLike(){
		return like;
	}
	
	public int GetPathIndex(){
		return pathIndex;
	}
	
	public boolean GetIsLike(){
		return isLike;
	}
	
	public void SetIsLike(boolean value){
		isLike = value;
	}
}
