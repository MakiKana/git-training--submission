package ch5;

public class Main5_3 {

		// コード5-3 mainメソッド以外からメソッドを呼び出す
		  public static void methodA() {
			    System.out.println("methodA");
			    methodB();
			  }
			  public static void methodB() {
			    System.out.println("methodB");
			  }
			  public static void main(String[] args) {
			    methodA();
	}

}
