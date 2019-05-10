package ImplementingInterface;

import java.util.Enumeration;
import java.util.Vector;

public class ImplementingInterface {
	
	
	private static Enumeration<String> characters;

	public static void main(String args []) {
	
		Enumeration<String> characters = getEnumeration("Hello World!");
		while (characters.hasMoreElements()) {
	         System.out.println(characters.nextElement()); 
	    }
	}
	
	private static Enumeration<String> getEnumeration(String input){
		Vector<String> inputChar = new Vector<String>();
		
		for(int i=0;i<input.length();i++) {
			inputChar.add( String.valueOf(input.charAt(i)) );
		}
		characters = inputChar.elements();
		return characters;
	}
	
}
