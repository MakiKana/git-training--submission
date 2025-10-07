package ch4;

public class main4_10 {

	public static void main(String[] args) {
		// コード4-10 点数管理プログラム（for文の利用）
	    int[] scores = {20, 30, 40, 50, 80};
	    int sum = 0;
	    for (int i = 0; i < scores.length; i++) {
	      sum += scores[i];
	    }
	    int avg = sum / scores.length;
	    System.out.println("合計点:" + sum);
	    System.out.println("平均点:" + avg);
	}

}
