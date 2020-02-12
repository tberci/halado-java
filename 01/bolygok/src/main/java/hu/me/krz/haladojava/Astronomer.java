package hu.me.krz.haladojava;

import java.util.List;
import java.util.Random;

public class Astronomer {

	private String name;
	
	private List<Planet> DiscoveredPLanets;

	public Astronomer(String name, List<Planet> DiscoveredPLanets) {
		super();
		this.name = name;
		this.DiscoveredPLanets = DiscoveredPLanets;
	}

	public List<Planet> getDiscoveredPLanets() {
		return DiscoveredPLanets;
	}

	public void observeTheSky(){
		
		Random rand = new Random();
		
		Planet[] planet = new Planet[10];
		
		for(int i = 0; i< 10; i++){
			
			System.out.println(planet[i].toString());
			 //planet[i].getRadius() = rand.nextLong();
		}
	}
	
	
	
	
	
}
