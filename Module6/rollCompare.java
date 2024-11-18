package Module6;
import java.util.*;
public class rollCompare implements Comparator <Student> {
    public int compare(Student s1, Student s2){
        return Integer.compare(s1.getRollno(), s2.getRollno());
    }
}
