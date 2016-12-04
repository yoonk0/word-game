package tools;

/**
*
* @author Wen Zhong
*/

import java.io.*;
import java.util.*;

public class ReviewList {
	File file;
	ArrayList<String> words;
	
	public ReviewList(String path) throws Exception{
		file = new File(path);
		words = new ArrayList<>();
		//readList();
	}
	
	public void readList() throws Exception{
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String tmp;
		
		while((tmp = br.readLine()) != null){
			words.add(tmp);
		}
		br.close();
	}
	
	public void addElement(String newWord) throws Exception{
		FileWriter fw = new FileWriter(file, true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(newWord + "\n");
		bw.close();
	}
	
//	public void deleteElement(String word) {
//		
//	}
	
	public ArrayList<String> getList(){
		return words;
	}
	
	public boolean existOrNot(String newWord){
		if(words.contains(newWord)) return true;
		return false;
	}
}
