package ch17;

import java.io.FileWriter;
import java.io.IOException;

public class Main17_2 {

	public static void main(String[] args) {
		// コード17-2 try-catch文でException系例外の発生に備える
	    try {
	        FileWriter fw = new FileWriter("data.txt");
	      } catch (IOException e) {
	        System.out.println("エラーが発生しました。");
	      }
	    }
	  }
