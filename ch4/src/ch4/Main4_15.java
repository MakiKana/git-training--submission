package ch4;

public class Main4_15 {

	public static void main(String[] args) {
		// コード4-15 実行結果は？
	    int[] arrayA = {1, 2, 3};
	    int[] arrayB;
	    arrayB = arrayA;
	    arrayB[0] = 100;
	    System.out.println(arrayA[0]);
	}

}
