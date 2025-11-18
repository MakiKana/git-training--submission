package ch16;

import java.util.HashSet;
import java.util.Set;

public class Main16_3 {

	public static void main(String[] args) {
		// コード16-3 Setに重複した値を追加しようとすると…
	    Set<String> colors = new HashSet<String>();
	    colors.add("赤");
	    colors.add("青");
	    colors.add("黄");
	    colors.add("赤");
	    System.out.println("色は" + colors.size() + "種類");
	  }

}
