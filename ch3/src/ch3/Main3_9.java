package ch3;

public class Main3_9 {

	public static void main(String[] args) {
		// コード3-9  for文のループを2重にして九九の表を出力する
	    for (int i = 0; i < 10; i++) {
	        for (int j = 1; j < 10; j++) {
	          System.out.print(i * j);
	          System.out.print(" ");
	        }
	      System.out.println("");
	      }
	}

}
