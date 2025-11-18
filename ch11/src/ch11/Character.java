package ch11;

public abstract class Character {

	// コード11-8 Characterを抽象クラスとして宣言する
	  String name;
	  int hp;
	  
	  public void run() {
	    System.out.println(this.name + "は逃げ出した");
	  }
	  
	  public abstract void attack(Matango m) ;
	}
