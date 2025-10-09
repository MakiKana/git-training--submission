package ch12;

public class Main12_10 {

	public static void main(String[] args) {
		// 12-10 同じ動作で異なる動作をさせることができる
		Monster[] monsters = new Monster[3];
	    monsters[0] = new Slime();
	    monsters[1] = new Goblin();
	    monsters[2] = new DeathBat();
	    for (Monster m : monsters) {
	      m.run();
	    }
	}

}
