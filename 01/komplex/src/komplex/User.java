package komplex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {

	private String uname;

	public User() {
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}
	
	public void mentes() {
		
		Scanner sc = new Scanner(System.in);  
		 System.out.println("Enter username");
		    
		  String uname = sc.nextLine();
		  
		  Pattern pattern = Pattern.compile("\\s");
		  Matcher matcher = pattern.matcher(uname);
		  boolean found = matcher.find();
		  
		  if(uname.length() >= 6 && !found)
		  System.out.println("Elmentve "+ uname);
		  else {
			 
			  System.out.println("your username is not correct.");
		  }
		  sc.close();
	
	}
	
}
