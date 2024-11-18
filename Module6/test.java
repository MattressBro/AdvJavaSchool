package Module6;
import java.util.*;
public class test {
    public static void main(String[] args){
        List<Student> students = new ArrayList<>();

        students.add(new Student(3, "John Doe", "OKC"));
        students.add(new Student(2, "John Smith", "Norman"));
        students.add(new Student(1, "Jane Smith", "Castle Rock"));
        System.out.println("List of Students");
        printList(students);
        System.out.println("\nList of Students ordered by name");
        sort.selectSort(students, new nameCompare());
        printList(students);
        System.out.println("\nList of Students ordered by Roll Number");
        sort.selectSort(students, new rollCompare());
        printList(students);
        
    }
    public static void printList(List<Student> students){
            for (int i = 0; i <students.size(); i++){
                System.out.println(students.get(i).toString());
        }
    }
}
