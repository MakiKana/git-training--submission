package ch15;

public class Main15_10 {

	public static void main(String[] args) {
		// コード15-10 処理時間を計測する
	    long start = System.currentTimeMillis();
	    // ここで何らかの時間がかかる処理
	    long end = System.currentTimeMillis();
	    System.out.println("処理にかかった時間は…" + (end - start) + "ミリ秒でした");
	  }
	}