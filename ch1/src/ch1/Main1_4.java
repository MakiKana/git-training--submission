package ch1;

public class Main1_4 {

	public static void main(String[] args) {
		// コード1-4 書き換えてはいけない変数の値を上書きしてしまう
		double pi = 3.14;
		int pie = 5;
		System.out.println("半径" + pie + "cmのパイの面積は、");
		System.out.println(pie * pie * pi);
		System.out.println("パイの半径を倍にします");
		pi = 10;
		System.out.println("半径" + pie + "cmのパイの面積は、");
		System.out.println(pie * pie * pi);
	}

}
