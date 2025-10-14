package ch14;

public class Main14_11 {

	public static void main(String[] args) {
		// コード14-11 インスタンスから静的フィールドを利用する
	    Hero h1 = new Hero();
	    Hero h2 = new Hero();
	    Hero.money = 100;
	    System.out.println(Hero.money);
	    System.out.println(h1.money);
	    h1.money = 300;
	    System.out.println(h2.money);
	  }
	}
