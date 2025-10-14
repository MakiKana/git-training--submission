package ch14;

public class Main14_14 {

	public static void main(String[] args) {
		// コード14-14 newしなくても静的メソッドは呼び出せる
	    Hero.setRandomMoney();
	    System.out.println(Hero.money);
	    Hero h1 = new Hero();
	    System.out.println(h1.money);
	  }
	}