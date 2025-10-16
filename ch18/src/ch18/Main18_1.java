package ch18;

import java.io.FileReader;

public class Main18_1 {

	  public static void main(String[] args) throws Exception {
		// コード18-1 ファイルから1文字ずつ読み込む
	    FileReader fr = new FileReader("data.txt");
	    int input = fr.read();
	    while (input != -1) {
	      System.out.print((char)input);
	      input = fr.read();
	    }
	    fr.close();
	  }
	}
