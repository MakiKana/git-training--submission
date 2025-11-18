package ch4;

public class Main4_17 {

	public static void main(String[] args) {
		// コード4-17 nullの利用（エラー）
	    int[] array = {1, 2, 3};
	    array = null;
	    array[0] = 10;
	}

}
