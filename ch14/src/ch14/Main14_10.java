package ch14;

public class Main14_10 {

	public static void main(String[] args) {
		// コード14-10 静的フィールドmoneyへのアクセス
	    Hero h1 = new Hero();
	    Hero h2 = new Hero();
	    System.out.println(h1.hp);
	    System.out.println(Hero.money);
	  }
	}
