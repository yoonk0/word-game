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
		readList();
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
		if(!words.contains(newWord)) {
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(newWord + "\n");
			bw.close();
			words.add(newWord);
		}
	}
	
	public void deleteElement(String word) throws IOException {
		File temp = new File("wordLists/temp.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		FileWriter fw = new FileWriter(temp);
		BufferedWriter bw = new BufferedWriter(fw);
		
		String tmp;
		while((tmp = br.readLine()) != null){
			if (!tmp.trim().equals(word)) {
				bw.write(tmp.trim() + "\n");
			}
		}
		br.close();
		bw.close();
		
		temp.renameTo(file);
		
		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).equals(word)) {
				words.remove(i);
			}
		}	
	}
	
	
	public ArrayList<String> getList(){
		return words;
	}
	
//	public boolean existOrNot(String newWord){
//		if(words.contains(newWord)) return true;
//		return false;
//	}
}
