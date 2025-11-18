package ch8;

public class Main8_14 {

	public static void main(String[] args) {
		// コード8-14 手書き型で作った勇者の冒険プログラム
	    int yusha_hp = 100;
	    int matango1_hp = 50;
	    int matango2_hp = 48;
	    String yusha_name = "ミナト";
	    int matango1_level = 10;
	    int matango2_level = 10;
	    System.out.println(yusha_name + "は5秒座った！");
	    yusha_hp += 5;
	    System.out.println("HPが5ポイント回復した");
	}

}
