package ch17;

import java.io.FileWriter;

public class Main17_3 {

	public static void main(String[] args) {
		// コード17-3 ザックリと例外を捕捉する
	    try {
	        FileWriter fw = new FileWriter("data.txt");
	        fw.write("hello!");
	        fw.close();
	      } catch (Exception e) {
	        System.out.println("何らかの例外が発生しました");
	      }
	    }
	  }