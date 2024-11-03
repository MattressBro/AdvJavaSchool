package Module4;

public class Triangle extends Shape {
    //initialize variables
    private double length1, length2, length3;
    public Triangle(double length1, double length2, double length3){
        this.length1 = length1;
        this.length2 = length2;
        this.length3 = length3;
    }
    //overrided methods
    //area
    @Override
    public double area() {
        //area calculated using Heron's formula sp refers to semi perimeter
        double sp = perimeter() / 2;
        return Math.sqrt(sp * (sp-length1)*(sp-length2)*(sp-length3));
    }
    //perimeter
    @Override
    public double perimeter() {
        return length1+length2+length3;
    }
    //toString override method
    @Override
    public String toString() {
        return String.format("Area of Triangle: %.2f \nPerimeter of Triangle: %.2f\n",area(), perimeter());
    }
}
