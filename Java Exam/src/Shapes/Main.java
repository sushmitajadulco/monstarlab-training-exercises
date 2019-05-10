package Shapes;

public class Main {
	
	public static void main(String args []) {
		Rectangle rec = new Rectangle(3, 4);
		Circle circ = new Circle(3.4);
		Triangle tri = new Triangle(6,4,7);
		
		Shape[] shape_list = { rec, circ, tri};
			
		System.out.println("Total Area: " + getTotalArea(shape_list) );
		System.out.println("Total Perimeter: " + getTotalPerimeter(shape_list) );
		System.out.println("Shape with largest area: " + getLargestArea(shape_list));
	}
	
	private static double getTotalArea(Shape [] list ) {
		double total = 0.0;
		for(Shape elem : list) {
			total += elem.area();
		}
		return total;
	}
	
	private static double getTotalPerimeter(Shape [] list ) {
		double total = 0.0;
		for(Shape elem : list) {
			total += elem.perimeter();
		}
		return total;
	}
	
	private static String getLargestArea(Shape [] list ) {
		double largestArea = 0.0;
		String shape = "";
		for(Shape elem : list) {
			if(largestArea < elem.area()) {
				largestArea = elem.area();
				shape = elem.shapeName();
			}
		}
		
		return shape;
	}
}
