package ch17;

import java.io.FileWriter;

public class Main17_10 {

	public static void main(String[] args) {
		// コード17-10 try-with-resources文の利用
	    try (FileWriter fw = new FileWriter("data.txt");) {
	        fw.write("hello!");
	      } catch (Exception e) {
	        System.out.println("何らかの例外が発生しました");
	      }
	    }
	  }
