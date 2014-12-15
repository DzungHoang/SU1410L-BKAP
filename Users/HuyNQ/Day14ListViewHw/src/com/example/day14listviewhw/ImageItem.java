package com.example.day14listviewhw;

public class ImageItem {
	private String name;
	private int price;
	private int indexPath;
	private int likeCount;
	
	public ImageItem(String name, int price, int indexPath, int likeCount){
		this.name = name;
		this.price = price;
		this.indexPath = indexPath;
		this.likeCount = likeCount;
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
}
