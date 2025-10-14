package ch12;

public abstract class Character {
	  String name;
	  int hp;
	  public void run(Matango m) {
	  System.out.println(this.name + "は戦わずに逃げた！");
	  }
	  public abstract void attack(Matango m);
	}
