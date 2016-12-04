package helper;

import java.io.*;
import java.util.ArrayList;

/**
*
* @author Wen Zhong
*/

public class ImagesAllocator {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File srcFile = new File("/Users/zhongwen/git/cit-591-projects-fall-2016-word_game/WordGameForChildren/img");
		File aimFile = new File("images/lesson4");
		
		FileReader fr = new FileReader(new File("words/lesson4.txt"));
		BufferedReader br = new BufferedReader(fr);
		ArrayList<String> words = new ArrayList<>();
		String tmp;
		
		while((tmp = br.readLine()) != null){
			words.add(tmp);
		}
		
		File[] str = srcFile.listFiles();
		
		for(int i = 0; i < words.size(); i++){
			File oldFile = new File("/Users/zhongwen/git/cit-591-projects-fall-2016-word_game/WordGameForChildren/img/" + words.get(i) + ".jpg");
			File newFile = new File("images/lesson4/" + words.get(i) + ".jpg");
			
			DataInputStream dis=new DataInputStream(new FileInputStream(oldFile));
	        DataOutputStream dos=new DataOutputStream(new FileOutputStream(newFile));
		
	        int temp;
	        //读写数据
	        while((temp=dis.read())!=-1){//读数据
	           dos.write(temp);//把读到的数据写入到Temp文件中
	        }
	       
	        //关闭流
	        dis.close();
	        dos.close();
		}
	}

}
