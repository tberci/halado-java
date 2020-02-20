package hu.me.krz.haladojava;

public abstract class Szemely {

	private final String name;
	private final int age;
	
	
	public Szemely(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	
	
	
}
