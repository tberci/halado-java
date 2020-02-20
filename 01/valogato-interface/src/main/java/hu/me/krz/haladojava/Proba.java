package hu.me.krz.haladojava;

public class Proba {

	public static void main(String[] args) {
		
	
		if(args.length > 1) {
			System.err.println("Mor than 1 parameters detected.");
			System.exit(0);
		}else {
			
			//int db = Integer.parseInt(args[0]);
			
			
			
			Diak[] diakok = new Diak[4];
			Tanar[] tanarok = new Tanar[4];
			
			Diak diak1 = new Diak("diak1", 18, 0);
			Diak diak2 = new Diak("diak2", 21, 4);
			Diak diak3 = new Diak("diak3", 23, 3);
			Diak diak4 = new Diak("diak4", 21, 5);
			
			Tanar tanar1 = new Tanar("tanar1", 48, 2);
			Tanar tanar2 = new Tanar("tanar2", 25, 4.4);
			Tanar tanar3 = new Tanar("tanar3", 34, 33.5);
			Tanar tanar4 = new Tanar("tanar4", 27, 5);
			
			diakok[0] = diak1;
			diakok[1] = diak2;
			diakok[2] = diak3;
			diakok[3] = diak4;
			
			tanarok[0] = tanar1;
			tanarok[1] = tanar2;
			tanarok[2] = tanar3;
			tanarok[3] = tanar4;
			
			for(int i= 0; i<diakok.length;i++) {
			
				System.out.println(diakok[i].toString()+  " Megfelel? : " + diakok[i].joAlanyE());
			}
			
			System.out.println("");
			
			for(int i= 0; i<tanarok.length;i++) {
				
				System.out.println(tanarok[i].toString() +" Megfelel? : " +tanarok[i].joAlanyE());
			}
			
			}
			
		}
	}


