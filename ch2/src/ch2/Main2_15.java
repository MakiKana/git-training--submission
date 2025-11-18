package ch2;

public class Main2_15 {

	public static void main(String[] args) {
		// コード2-15  ランダムな数を生成する命令
	    int r = new java.util.Random().nextInt(90);
	    System.out.println("あなたはたぶん、" + r + "歳ですね？");
	}

}
