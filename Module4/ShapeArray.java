package Module4;

public class ShapeArray {
    public static void main(String[] args){
        System.out.println("  Shape Array");
        System.out.println("----------------");
        //instantiate shapes
        Shape rectangle = new Rectangle(5,6);
        Shape circle = new Circle(6);
        Shape triangle = new Triangle(4, 5, 6);
        //create the array 
        Shape[] shapeArray = {rectangle,circle,triangle};
        for(Shape shape : shapeArray){
            System.out.println(shape.toString());
        }
    }
    
}
