package Final;
import java.util.*;
import java.io.*;

public class finalProject {
    static class Student{
        private String name;
        private String address;
        private double gpa;

        public Student(String name, String address, double gpa){
            this.name = name;
            this.address = address;
            this.gpa = gpa;
        }
        public String getName(){
            return name;
        } 
        @Override
        public String toString(){
            return "Name: "+name+"\nAddress: "+address+"\nGPA: "+gpa;
        }
    }
    public static void main(String[] args){
        LinkedList<Student> studentList = new LinkedList<>();
        Scanner s = new Scanner(System.in);
        System.out.print(" Student Manager \n");
        System.out.print("-----------------\n");
        System.out.print("1: Enter Student Information\n");
        System.out.print("2: Exit Program & Output to file\n");
        int input=0;
        while(input != 2){
            System.out.print("Make a selection(1-2): ");
            input=s.nextInt();
            s.nextLine();
            switch(input){
                case 1: 
                    Student student = inputStudent(s);
                    studentList.add(student);
                    System.out.println(student.getName()+" added successfully");
                    break;
                case 2:
                    if(studentList.isEmpty()){
                        System.out.println("No students to output. Exiting program.");
                    }
                    else{
                        System.out.println("Writing to file and exiting.")
                        toFile(studentList);
                        break;
                    }
                default:
                    System.out.print("Invalid input. Enter 1-2\n");
            }
        }
    }
    public static Student inputStudent(Scanner s){
        System.out.print("Enter Student Name: ");
        String name = s.nextLine();
        System.out.print("Enter Student Address: ");
        String address = s.nextLine();
        double gpa;
        while(true){
            try{
                System.out.print("Enter Student GPA: ");
                gpa = Double.parseDouble(s.nextLine());
                if(gpa <0.0 || gpa > 4.0){
                    throw new IllegalArgumentException("GPA needs to be between 0.0 and 4.0");
                }
                break;
            }catch (NumberFormatException e){
                System.out.println("Invalid input. Please enter GPA.");
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            
        }
        return new Student(name, address, gpa);
    }
    public static void toFile(LinkedList<Student> studentList){
        try(PrintWriter writer = new PrintWriter(new FileWriter("students.txt"))){
            for(Student student : studentList){
                writer.println(student.toString());
            }
        }catch (IOException e){
            System.out.println("Error occured writing to file."+e.getMessage());
        }
    }
}
