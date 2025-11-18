package ch16;

import java.util.Set;
import java.util.TreeSet;

public class Main16_5 {

	public static void main(String[] args) {
		// コード16-5 TreeSetから文字列を取り出すと…
	    Set<String> words = new TreeSet<String>();
	    words.add("dog");
	    words.add("cat");
	    words.add("wolf");
	    words.add("panda");
	    for (String s : words) {
	      System.out.print(s + "→");
	    }
	  }

}
