package ch17;

import java.io.FileWriter;
import java.io.IOException;

public class Main17_8 {

	public static void main(String[] args) {
		// コード17-8 後片付け処理もtry-catchする
	    FileWriter fw = null;
	    try {
	      fw = new FileWriter("data.txt");
	      fw.write("hello!");
	    } catch (Exception e) {
	      System.out.println("何らかの例外が発生しました");
	    } finally {
	      try {
	        fw.close();
	    } catch (IOException e) {
	      System.out.println("エラーが発生しました。");
	    }
	  }
	}
}
