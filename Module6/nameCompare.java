package Module6;
import java.util.*;
public class nameCompare implements Comparator<Student> {
    public int compare(Student s1, Student s2){
        return s1.getName().compareTo(s2.getName());
    }
}
