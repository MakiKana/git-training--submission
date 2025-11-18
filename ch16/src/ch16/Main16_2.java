package ch16;

import java.util.ArrayList;
import java.util.Iterator;

public class Main16_2 {

	public static void main(String[] args) {
		// コード16-2 イテレータを使ったArrayListの繰り返し処理
	    ArrayList<String> names = new ArrayList<String>();
	    names.add("湊");
	    names.add("朝香");
	    names.add("菅原");
	    Iterator<String> it = names.iterator();
	    while (it.hasNext()) {
	      String e = it.next();
	      System.out.println(e);
	    }
	  }

}
