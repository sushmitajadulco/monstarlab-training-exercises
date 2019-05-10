package Chemical_Element;

public class Main {
	public static void main(String args []) {
		
		ChemicalElement element = new ChemicalElement();
		
		System.out.println("isAlkali: " + element.isAlkali(80) );
		System.out.println("isTransition: " + element.isTransition(80) );
		System.out.println("isMetal: " + element.isMetal(80) );
	}
}
