package Module4;

public class Circle extends Shape {
    //initialize variables
    private double radius;
    public Circle(double radius){
        this.radius = radius;
    }
    //overrided methods
    //area
    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }
    //perimeter
    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
    //toString override method
    @Override
    public String toString() {
        return String.format("Area of Circle: %.2f \nPerimeter of Circle: %.2f\n",area(), perimeter());
    }
}

