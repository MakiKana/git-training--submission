package ch5;

public class Main5_12 {

		// コード5-12 引数に配列を受け取るメソッド
	  // int型配列を受け取り、すべての要素を表示するメソッド
	  public static void printArray(int[] array) {
	    for (int element : array) {
	      System.out.println(element);
	    }
	  }
	  public static void main(String[] args) {
	    int[] array = {1, 2, 3};
	    printArray(array);
	}

}
