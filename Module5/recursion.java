package Module4.Module5;
import java.util.Scanner;

public class recursion {
    public static void main(String[] args){
        System.out.println("Product Evaluator");
        System.out.println("-----------------");
        System.out.println("");
        System.out.println("Please enter 5 numbers to calculate their product.");
        //initiate scanner and array
        Scanner s = new Scanner(System.in);
        double prodArray[] = new double[5]; 
        for(int i=0;i <5;){
            //try catch to ensure only numbers
            try{
                System.out.print("Number "+(i+1)+": ");
                prodArray[i] = Double.parseDouble(s.nextLine());
                i++;
            } catch (NumberFormatException e){
                System.out.println("Invalid input.");
            }
        }
        double prod = calcProduct(prodArray, prodArray.length -1);
        System.out.println("Product of numbers is: "+ prod);
        for (int i=0; i <prodArray.length;i++){
            System.out.println(prodArray[i]);
        }
        s.close();
    }
    //recursive method
    public static double calcProduct(double[] arr, int index){
        if(index == 0 ){
            return arr[0];
        }
        return arr[index] * calcProduct(arr, index - 1);
    }
}
