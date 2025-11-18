package ch9;

public class Main9_13 {

	public static void main(String[] args) {
		// コード9-13 コンストラクタをオーバーロードしたクラスの利用
	    Hero h1 = new Hero("ミナト");
	    System.out.println(h1.name);
	    Hero h2 = new Hero();
	    System.out.println(h2.name);
	}

}
