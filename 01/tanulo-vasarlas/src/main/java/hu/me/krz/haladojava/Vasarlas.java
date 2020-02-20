package hu.me.krz.haladojava;

import java.util.ArrayList;

public class Vasarlas {

	public static void main(String[] args) {
		
		ArrayList<Tanulo> tanulok = new ArrayList<Tanulo>();

		Tanulo tanulo1 = new Tanulo("tanulo1");
		Tanulo tanulo2 = new Tanulo("tanulo2");
		Tanulo tanulo3 = new Tanulo("tanulo3");
		Tanulo tanulo4 = new Tanulo("tanulo4");
		Tanulo tanulo5 = new Tanulo("tanulo5");
	
		
		tanulok.add(tanulo1);
		tanulok.add(tanulo2);
		tanulok.add(tanulo3);
		tanulok.add(tanulo4);
		tanulok.add(tanulo5);
		
		
		//tanulok kiírása
		 for (int i = 0; i < tanulok.size(); i++) {
		      System.out.println(tanulok.get(i));
		    }
		 
		 
		 System.out.println("");
		 
		 //átlagolás	 
		 int sum = 0;
		 for(int i= 0; i< tanulok.size();i++) {
			    
			 sum = sum+ tanulok.get(i).penz(); 
			
			}
		 
			
		//össz költség
		 int fsum = tanulo1.fogyasztas(1500) +	tanulo2.fogyasztas(1500) +tanulo3.fogyasztas(1700) +tanulo4.fogyasztas(2000) +tanulo5.fogyasztas(3000);
		
		
		 int penz1 = 10000;
		 int penz2 = 10000;
		 int penz3 = 10000;
		 int penz4 = 10000;
		 int penz5 = 10000;
	
		 int atlag = 0;
		 
		 for(int i = 0; i < 6; i++) {
			 
			 
			int penzek[]=  {penz1,penz2,penz3,penz4,penz5};
			penz1 = penz1 - tanulo1.fogyasztas(1500);
			penz2 = penz2 - tanulo2.fogyasztas(1500);
			penz3 = penz3 - tanulo3.fogyasztas(1700);
			penz4 = penz4 - tanulo4.fogyasztas(2000);
			penz5 = penz5 - tanulo5.fogyasztas(3000);
		
		
			
			sum = sum- tanulok.get(1).fogyasztas(fsum);
			atlag = ( sum / tanulok.size());
			
			for(int j= 0; j < tanulok.size(); j++) {
				if(penzek[j] <= 0) {
				tanulok.remove(tanulok.get(j));
				System.out.println("a maradék tanulók : " +tanulok.toString());
				}
				
				if(penzek[j] > 0) {
				tanulok.get(j);
				System.out.println("a maradék tanulók száma  : " +tanulok.toString());
				System.out.println("a maradék tanulók száma  : " +tanulok.size());
					}
					
			}
			
			
			 
			 System.out.println("tanuló1 pénze az " +(i+1)+ " . körben " + penz1);
			 System.out.println("tanuló2 pénze az " +(i+1)+ " . körben " + penz2);
			 System.out.println("tanuló3 pénze az " +(i+1)+ " . körben " + penz3);
			 System.out.println("tanuló4 pénze az " +(i+1)+ " . körben " + penz4);
			 System.out.println("tanuló5 pénze az " +(i+1)+ " . körben " + penz5);
			
			 
			System.out.println("összpénz az " + (i+1) +". körben: "+ sum+ "FT");
			System.out.println("A maradék pénz " +(i+1)+ ". köri átlaga: "+  atlag);
			
				
	}
		 		
				
				
				
			
			
			
			
		
		
	}

}
