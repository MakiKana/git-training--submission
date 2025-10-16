package ch15;

import java.util.Date;

public class Main15_11 {

	public static void main(String[] args) {
		// コード15-11 現在日時を表示する
	    Date now = new Date();
	    System.out.println(now);
	    System.out.println(now.getTime());
	    Date past = new Date(1694984000000L);
	    System.out.println(past);
	  }

}
