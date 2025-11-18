package ch18;

import java.io.FileWriter;

public class Main18_2 {

	  public static void main(String[] args) throws Exception {
		// コード18-2 ファイルに1文字ずつ書き込む
		    FileWriter fw = new FileWriter("data.txt");
		    fw.write('そ');
		    fw.write('れ');
		    fw.write('で');
		    fw.write('は');
		    fw.close();
		  }
		}
