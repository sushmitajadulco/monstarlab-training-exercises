package Shapes;

public class Circle extends Shape {
	
	private double radius;
	
	public Circle (double radius) {
		this.radius = radius;
	}

	@Override
	public double area() {
		return Math.PI*(Math.pow(this.radius, 2));
	}

	@Override
	public double perimeter() {
		return 2*(Math.PI*this.radius);
	}

	@Override
	public String shapeName() {
		return "Circle";
	}
}
