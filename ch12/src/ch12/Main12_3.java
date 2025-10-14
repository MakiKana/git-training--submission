package ch12;

public class Main12_3 {

	public static void main(String[] args) {
		// 12-3 Wizardクラスを通常の方法でインスタンス化
	    Wizard w = new Wizard();
	    Matango m= new Matango();
	    w.name = "アサカ";
	    w.attack(m);
	    w.fireball(m);
	  }
	}
