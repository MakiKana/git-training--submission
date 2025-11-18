package ch16;

import java.util.HashSet;
import java.util.Set;

public class Main16_4 {

	public static void main(String[] args) {
		// コード16-4 Setから要素を取り出すと…
	    Set<String> colors = new HashSet<String>();
	    colors.add("赤");
	    colors.add("青");
	    colors.add("黄");
	    for (String s : colors) {
	      System.out.print(s + "→");
	    }
	  }

}
