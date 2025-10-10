package ch9;

public class Main9_6 {

	public static void main(String[] args) {
		// コード9-6 勇者と魔法使いを生み出す
	    Hero h1 = new Hero();
	    h1.name = "ミナト";
	    h1.hp = 100;
	    Hero h2 = new Hero();
	    h2.name = "アサカ";
	    h2.hp = 100;
	    Wizard w = new Wizard();
	    w.name = "スガワラ";
	    w.hp = 50;
	    w.heal(h1);
	    w.heal(h2);
	    w.heal(h2);
	}

}
