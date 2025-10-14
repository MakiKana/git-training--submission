package ch11;

public class Fool extends Character implements Human {
	  // Characterからhpやnameなどのフィールドを継承している
	  // Characterから継承した抽象メソッドattack()を実装
	  public void attack(Matango m) {
	    System.out.println(this.name + "は戦わず遊んでいる");
	  }
	  // さらにHumanから継承した4つの抽象メソッドを実装
	  public void talk(Matango m) {
	    System.out.println(this.name + "は戦わずしゃべっている");
	  }
	  public void watch(Matango m) {
	    System.out.println(this.name + "は戦わずに見ている");
	  }
	  public void hear(Matango m) {
	    System.out.println(this.name + "は戦わず聴いている");
	  }
	  public void run(Matango m) {
	    System.out.println(this.name + "は戦わずに逃げた！");
	  }
	}
