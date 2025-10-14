package ch12;

public class Main12_7 {

	public static void main(String[] args) {
		// コード12-7 多態性と配列を組み合わせて宿屋に泊まる

	    Character[] c = new Character[5];
	    c[0] = new Hero();
	    c[1] = new Hero();
	    c[2] = new Hero();
	    c[3] = new Hero();
	    c[4] = new Hero();
	    // 宿屋に泊まる
	    for (Character ch : c) {
	      ch.hp += 50;
	    }
	  }

}
