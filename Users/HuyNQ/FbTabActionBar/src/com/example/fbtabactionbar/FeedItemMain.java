package com.example.fbtabactionbar;

public class FeedItemMain {
	String name;
	String time;
	String content;
	int imgProfileIndex;
	int imgContentIndex;
	int countLike;
	int countComment;
	
	public FeedItemMain(String name, String time, String content, int imgProfileIndex, int imgContentIndex, int countLike, int countComment){
		this.name=name;
		this.time=time;
		this.content = content;
		this.imgProfileIndex = imgProfileIndex;
		this.imgContentIndex = imgContentIndex;
		this.countLike = countLike;
		this.countComment = countComment;
	}
}
