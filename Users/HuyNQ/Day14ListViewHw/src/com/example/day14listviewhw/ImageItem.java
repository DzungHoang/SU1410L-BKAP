package com.example.day14listviewhw;

public class ImageItem {
	private String name;
	private int price;
	private int indexPath;
	private int likeCount;
	private boolean isLike;
	
	public ImageItem(String name, int price, int indexPath, int likeCount, boolean isLike){
		this.name = name;
		this.price = price;
		this.indexPath = indexPath;
		this.likeCount = likeCount;
		this.isLike = isLike;
	}
	
	public String GetName(){
		return name;
	}
	
	public int GetPrice(){
		return price;
	}
	
	public int GetIndexPath(){
		return indexPath;
	}
	
	public int GetLikeCount(){
		return likeCount;
	}
	
	public boolean GetIsLike(){
		return isLike;
	}
	
	public void SetIsLike(boolean value){
		isLike = value;
	}
}
