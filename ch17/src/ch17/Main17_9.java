package ch17;

import java.io.FileWriter;
import java.io.IOException;

public class Main17_9 {

	public static void main(String[] args) {
		// コード17-9 ファイルを開いた時だけ後片付けする
	    FileWriter fw = null;
	    try {
	      fw = new FileWriter("data.txt");
	      fw.write("hello!");
	    } catch (Exception e) {
	      System.out.println("何らかの例外が発生しました");
	    } finally {
	      if (fw != null) {
	        try {
	          fw.close();
	        } catch (IOException e) {
	            System.out.println("エラーが発生しました。");
	        }
	     }
	  }
	}
}
