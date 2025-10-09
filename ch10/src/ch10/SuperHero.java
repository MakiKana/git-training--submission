package ch10;

public class SuperHero extends Hero {

		// コード10-5 SuperHeroクラスにrun()を再定義する
	  boolean flying;
	  public void fly() {
	    this.flying = true;
	    System.out.println("飛び上がった！");
	  }
	  public void land() {
	    this.flying = false;
	    System.out.println("着地した！");
	  }
	  public void run() {
	  System.out.println(this.name + "は撤退した");
	}

}
