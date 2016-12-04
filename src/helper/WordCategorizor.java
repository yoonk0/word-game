package helper;

/**
*
* @author Wen Zhong
*/

import java.io.*;
import java.util.*;

public class WordCategorizor {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		ArrayList<ArrayList<String>> lessons = new ArrayList<>();
		ArrayList<String> wordlist = new ArrayList<>();
		
		FileReader fr = new FileReader(new File("words/wordlist.txt"));
		BufferedReader br = new BufferedReader(fr);
		
		String tmp;
		
		while((tmp = br.readLine()) != null){
			wordlist.add(tmp);
		}
		
		for(int i = 0; i < 5; i++){
			ArrayList<String> temp = new ArrayList<>();
			lessons.add(temp);
		}
		
		Random rand = new Random();
		int randnum = 0;
		
		for(int i = 0; i < wordlist.size(); i++){
			randnum = rand.nextInt(5);
			while(lessons.get(randnum).size() >= 25){
				randnum = rand.nextInt(5);
			}
			lessons.get(randnum).add(wordlist.get(i) + "\n");
		}
		
		File[] lessonsFile = new File[5];
		
		for(int i = 0; i < 5; i++){
			lessonsFile[i] = new File("words/lesson" + i + ".txt");
			if(!lessonsFile[i].exists()){
				lessonsFile[i].createNewFile();
			}
			FileWriter fw = new FileWriter(lessonsFile[i]);
			BufferedWriter bw = new BufferedWriter(fw);
			for(int j = 0; j < lessons.get(i).size(); j++){
				bw.write(lessons.get(i).get(j));
			}
			bw.close();
		}
		
	}

}
