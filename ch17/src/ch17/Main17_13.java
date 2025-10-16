package ch17;

public class Main17_13 {

	public static void main(String[] args) {
		// コード17-13 オリジナル例外を利用する
	    try {
	        // 試験的に例外を発生させる
	        throw new UnsupportedMusicFileException("未対応のファイルです");
	      } catch (Exception e) {
	        e.printStackTrace();
	      }
	    }
	  }
