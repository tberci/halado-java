package hu.me.krz.haladojava;

public class Proba {

	public static void main(String[] args) {
	
		//int db = Integer.parseInt(args[0]);
		//db=5;
		
		if(args.length > 1) {
			System.err.println("Mor than 1 parameters detected.");
			System.exit(0);
		}else {
			
			
			Diak[] diaktomb = new Diak[5];
			Diak diak1 = new Diak("diak1", 18, 0);
			Diak diak2 = new Diak("diak2", 21, 4);
			Diak diak3 = new Diak("diak3", 23, 3);
			Diak diak4 = new Diak("diak4", 21, 5);
			Diak diak5 = new Diak("diak5", 18, 3);
			
			diaktomb[0] = diak1;
			diaktomb[1] = diak2;
			diaktomb[2] = diak3;
			diaktomb[3] = diak4;
			diaktomb[4] = diak5;
			
		
				for(int i= 0; i<diaktomb.length;i++) {
					
					diaktomb[i].compareTo(diaktomb[i]);
					
					System.out.println(diaktomb[i].toString());
				}
				 
				
			
		}
	}
}


