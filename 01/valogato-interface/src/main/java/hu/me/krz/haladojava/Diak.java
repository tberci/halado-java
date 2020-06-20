package hu.me.krz.haladojava;

public class Diak extends Szemely implements Valogato {

	private int puska;
	
	public Diak(String nev, int kor, int puska) {
		super(nev, kor);
		this.puska = puska;
	}

	@Override
	public boolean joAlanyE() {
		
		
		if(this.puska == 0 ) {
			
			return true;
		}else {
			return false;
		}
		
		
	}

	@Override
	public String toString() {
		return "Diak [név =" + getNev() + ", kor = :" + getKor() + ", puska =" + puska + "]";
	}

	
}
