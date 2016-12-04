package helper;

/**
 * 
 * @author Wen Zhong
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FilesNames {

    /**
     * 
     * @author Wen Zhong
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        getFileName();
    }

    public static void getFileName() throws IOException {
        String path = "/Users/zhongwen/git/cit-591-projects-fall-2016-word_game/WordGameForChildren/img"; // Â·¾¶
        File f = new File(path);
        File names = new File("words/names.txt");
        
        if(!names.exists()){
        	names.createNewFile();
        }
        
        if (!f.exists()) {
            System.out.println(path + " not exists");
            return;
        }
        
        FileWriter fw = new FileWriter(names);
        BufferedWriter bw = new BufferedWriter(fw);

        File fa[] = f.listFiles();
        for (int i = 0; i < fa.length; i++) {
            File fs = fa[i];
            if (fs.isDirectory()) {
                System.out.println(fs.getName() + " [directory]");
                bw.write(fs.getName()+"\n");
            } else {
                System.out.println(fs.getName());
                bw.write(fs.getName()+"\n");
            }
        }
        
        bw.close();
    }
}
