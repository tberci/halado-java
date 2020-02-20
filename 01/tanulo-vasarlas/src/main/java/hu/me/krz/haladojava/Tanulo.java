package hu.me.krz.haladojava;

public class Tanulo {

		private  String nev;
		private static  int penz;
		private static  int tanulok;
		
		


		public int osszestanulo() {
			return tanulok;
		}



		public int penz() {
			return penz;
		}
		
		


		public Tanulo(String nev, int penz, int tanulok) {
			super();
			this.nev = nev;
			this.penz = penz;
			this.tanulok = tanulok;
		}



		public Tanulo(String nev) {
			this(nev, penz, tanulok);
			this.penz = 10000;
			this.nev = nev;
		}



		
		
		public int fogyasztas(int csokkentes) {
			
			
			
			if(penz() - csokkentes <= 0) {
				return 0;
				
			}else {
				return  csokkentes;
			}
			
			
		}



		@Override
		public String toString() {
			return "Tanulo [nev=" + nev + ", penz=" + penz() + "]";
		}
		
		
	
		
		
		
}
