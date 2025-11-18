package ch15;

public class Main15_4 {

	public static void main(String[] args) {
		// コード15-4 StringBuilderで文字列を1万回連結する

	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < 10000; i++) {
	      sb.append("Java");
	    }
	    String s = sb.toString();
	    System.out.println(s);
	  }

}
