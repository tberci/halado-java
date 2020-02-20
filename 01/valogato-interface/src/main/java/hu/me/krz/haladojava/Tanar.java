package hu.me.krz.haladojava;

public class Tanar extends Szemely implements Valogato {

	
	private double atlagVizsgajegy;
	
	public Tanar(String nev, int kor, double atlagVizsgajegy) {
		super(nev, kor);
		this.atlagVizsgajegy = atlagVizsgajegy;
	}

	@Override
	public boolean joAlanyE() {
		
		if(this.getKor() < 30 && atlagVizsgajegy > 4)
		return true;
		return false;
	}

	@Override
	public String toString() {
		return "Tanar[név =" + getNev() + ", kor = :" + getKor() + ", vizsga átlag =" + atlagVizsgajegy + "]";
	}
	
}
