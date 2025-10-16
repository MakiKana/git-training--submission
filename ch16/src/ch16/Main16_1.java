package ch16;

import java.util.ArrayList;

public class Main16_1 {

	public static void main(String[] args) {
		// コード16-1 ラッパークラスをArrayListに格納する
	    ArrayList<Integer> points = new ArrayList<Integer>();
	    points.add(10);
	    points.add(80);
	    points.add(75);
	    for (int i : points) {
	      System.out.println(i);
	    }
	  }

}
