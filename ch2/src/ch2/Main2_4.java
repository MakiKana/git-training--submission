package ch2;

public class Main2_4 {

	public static void main(String[] args) {
		// コード2-4  テキストブロックを用いた複数行の文字列
		String prof1 = "名前：朝香あゆみ\n      (あさかあゆみ)";
		String prof2 = """
				名前：湊雄輔
				      (みなとゆうすけ)
				""";
		System.out.println(prof1);
		System.out.println(prof2);
	}

}
