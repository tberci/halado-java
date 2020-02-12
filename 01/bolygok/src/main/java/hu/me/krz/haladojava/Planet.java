package hu.me.krz.haladojava;

public final class Planet {

	private long position;
	private long radius;
	private String name;
	
	
	public Planet(int position, int radius, String name) {
		super();
		this.position = position;
		this.radius = radius;
		this.name = name;
	}
	public long getPosition() {
		return position;
	}
	
	public long getRadius() {
		return radius;
	}
	
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Planet [position=" + position + ", radius=" + radius + ", name=" + name + "]";
	}
	
	
	
}
