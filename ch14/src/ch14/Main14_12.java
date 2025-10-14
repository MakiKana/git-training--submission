package ch14;

public class Main14_12 {

	public static void main(String[] args) {
		// コード14-12 newしなくても静的フィールドは利用できる
	    // 1人も勇者を生み出していない状況で…
	    Hero.money = 100;
	    System.out.println(Hero.money);
	  }
	}
