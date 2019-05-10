package Shapes;

public class Triangle extends Shape{

	private double side1;
	private double side2;
	private double side3;
	
	public Triangle (double s1, double s2, double s3) {
		this.side1 = s1;
		this.side2 = s2;
		this.side3 = s3;
	}
	
	@Override
	public double area() {
		double half_perimeter = (this.side1 + this.side2 + this.side3) / 2;
		double area = Math.sqrt( half_perimeter * (half_perimeter - this.side1) * (half_perimeter - this.side2)
				* (half_perimeter - this.side3) );
		return area;
	}

	@Override
	public double perimeter() {
		return this.side1 + this.side2 + this.side3;
	}
	
	@Override
	public String shapeName() {
		return "Triangle";
	}
	

}

