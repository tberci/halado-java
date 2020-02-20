package hu.me.krz.haladojava;

public class Diak extends Szemely implements Comparable<Diak> {
	
	private final int puska;
	
	public Diak(String name, int age, int puska) {
		super(name, age);
		this.puska = puska;
	}

	@Override
	public int compareTo(Diak a) {
		
	if(this.puska < a.puska)
		 return toString().compareTo(this.toString());
	return a.puska;
	
	}

	

	@Override
	public String toString() {
		return "Diak [ név=" + getName() + ", kor=" + getAge() + "  puska=" +  puska + "]";
	}

	public int getPuska() {
		return puska;
	}

	
	
}
