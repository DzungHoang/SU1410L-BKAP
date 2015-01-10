package com.example.savefileapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import android.os.Environment;
import android.util.Log;

public class FileUtils {
	public static String DataPath = Environment.getExternalStorageDirectory().getAbsolutePath()+"/SaveFileAppDir";
	
	public static ArrayList<String> ListFileInFolder(String folderName){
		ArrayList<String> result = new ArrayList<String>();
		
		File folder = new File(folderName);
		if(!folder.exists()){
			folder.mkdir();
		}
		
		File[] lstFiles = folder.listFiles();
		if(lstFiles!=null){
			for(int i=0; i<lstFiles.length; i++){
				result.add(lstFiles[i].getName());
			}
		}
		
		return result;
	}
	
	public static boolean createFile(String folderName, String fileName, String content){
		boolean created = false;
		
		File folder = new File(folderName);
		if(!folder.exists()){
			folder.mkdir();
		}
		
		try{
			File file = new File(folderName+"/"+fileName);
			file.createNewFile();
			
			Log.d("huynq", "duong dan file: "+folderName+"/"+fileName);
			
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream);
			
			writer.append(content);
			writer.flush();
			writer.close();
			fileOutputStream.close();
			
			created = true;
		}
		catch(IOException e){
			e.printStackTrace();
			Log.d("huynq", "loi io exception khi tao file: "+e.getMessage());
		}
		
		return created;
	}
	
	public static String readFile(String folderName, String fileName){
		String ret="";
		String line="";
		
		File folder = new File(folderName);
		if(!folder.exists()){
			folder.mkdir();
		}

		
		try{
		
			File file = new File(folderName+"/"+fileName);
			
			//input stream
			FileInputStream fileInputStream = new FileInputStream(file);
			
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
			try{
				while((line=bufferedReader.readLine())!=null){
					ret+=line;
				}
				bufferedReader.close();
			}
			catch(IOException ex){
				ex.printStackTrace();
			}
		}
		catch(FileNotFoundException ex){
			ex.printStackTrace();
		}
		
		return ret;
		
	}
}
