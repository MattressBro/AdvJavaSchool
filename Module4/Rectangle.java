package Module4;

public class Rectangle extends Shape{
    //initialize variables
    private double length, width;
    public Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }
    //overrided methods
    //area
    @Override
    public double area() {
        return length * width;
    }
    //perimeter
    @Override
    public double perimeter() {
        return (length + width)*2;
    }
    //toString override method
    @Override
    public String toString() {
        return String.format("Area of Rectangle: %.2f \nPerimeter of Rectangle: %.2f\n",area(), perimeter());
    }
}