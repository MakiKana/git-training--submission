package ch8;

public class Matango {

		// コード8-15 お化けキノコクラスの定義
			  int hp;
			  final int LEVEL = 10;
			  char suffix;
			  
			  public void run() {
			    System.out.println("お化けキノコ" + this.suffix + "は逃げ出した！");
	}
			  public static void main(String[] args) {
				    Matango m = new Matango();
				    m.hp = 50;
				    m.suffix = 'A';
				    m.run();
}
}
