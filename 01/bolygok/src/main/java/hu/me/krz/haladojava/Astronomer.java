package hu.me.krz.haladojava;

import java.util.List;
import java.util.Random;

public class Astronomer {

private String name;
	
	private List<Planet> DiscoveredPLanets;
	
	
	public Astronomer(String name) {
		super();
		this.name = name;
		this.DiscoveredPLanets = DiscoveredPLanets;
	}

	public List<Planet> getDiscoveredPLanets() {
		return DiscoveredPLanets;
	}

	public void observeTheSky(){
		
		
	
		Planet[] planet = new Planet[10];
		
		for(int i = 0; i< planet.length; i++){
			Astronomer astronomer = new Astronomer("Galileo");
			Point point = new Point(0, 0, 0);
			
			
			int radius = 0;
			int position = (int) (point.getX()+i*10);
			String name = astronomer.name + i*10 ;
			
			double random = Math.random() * 100 + 1;
			
			radius = (int)random;
			
			planet[i] = new Planet(position, radius, name);
			
			System.out.println(planet[i].toString());
			 
		}
	}
	
}
