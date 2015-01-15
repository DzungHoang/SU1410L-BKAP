package com.example.day22sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBController extends SQLiteOpenHelper{
	public static final String DB_NAME="devices.db";
	public static final int DB_VERSION=1;
	
	/*create device table*/
	public static String DEVICE_TABLE="devices";
	public static String ID_COL="id";
	public static String NAME_COL="phone";
	public static String QUANTITY_COL="quantity";
	
	public static String CREATE_TABLE_DEVICES_SQL="CREATE TABLE "+DEVICE_TABLE+" ("
			+ID_COL+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+NAME_COL+" TEXT, "
			+QUANTITY_COL+" INTEGER );";
	
	SQLiteDatabase mDatabase;
	
	public DBController (Context context){
		super(context, DB_NAME,null, DB_VERSION);
		mDatabase = getWritableDatabase();
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_TABLE_DEVICES_SQL);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
	public long insert(ContentValues values){
		long ret=-1;
		if(mDatabase==null)mDatabase = getWritableDatabase();
		ret = mDatabase.insert(DEVICE_TABLE, null, values);
		return ret;
	}
	
	public Cursor query(String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy){
		Cursor ret;
		if(mDatabase==null)mDatabase=getWritableDatabase();
		ret = mDatabase.query(DEVICE_TABLE, columns, selection, selectionArgs, groupBy, having, orderBy);
		
		return ret;
	}
	
	public int update(ContentValues values, String whereClause, String[] whereArgs){
		int ret=-1;
		if(mDatabase==null)mDatabase=getWritableDatabase();
		ret = mDatabase.update(DEVICE_TABLE, values, whereClause, whereArgs);
		
		return ret;
	}
}
