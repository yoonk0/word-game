package helper;

/**
*
* @author Wen Zhong
*/

import java.io.*;
import java.util.ArrayList;

public class FileNamesDealer {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FileReader fr = new FileReader(new File("names.txt"));
		BufferedReader br = new BufferedReader(fr);
		
		ArrayList<String> names = new ArrayList<>();
		String temp;
		
		while((temp = br.readLine()) != null){
			names.add(temp);
		}
		
		for(int i = 0; i < names.size(); i++){
			names.set(i, names.get(i).substring(0, names.get(i).length()-4));
			System.out.println(names.get(i));
		}
		
		File file = new File("words/wordlist.txt");
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		for(int i = 0; i < names.size(); i++)
			bw.write(names.get(i)+"\n");
		
		System.out.println(names.size());
		bw.close();
	}

}
