package ch8;

public class Main8_12 {

	public static void main(String[] args) {
		// コード8-12 勇者インスタンスを生成して初期値を代入
	    // 1.勇者を生成
	    Hero h = new Hero();
	    
	    // 2.フィールドに初期値をセット
	    h.name = "ミナト";
	    h.hp = 100;
	    System.out.println("勇者" + h.name + "を生み出しました！");
	}

}
