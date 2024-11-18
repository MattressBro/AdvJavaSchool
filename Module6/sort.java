package Module6;
import java.util.*;
public class sort {
    public static <T> void selectSort(List<T> students,  Comparator<? super T> comp){
        int size = students.size();
        for(int i=0; i < size; i++){
            int min = i;
            for(int j =i+1; j < size; j++){
                if(comp.compare(students.get(j), students.get(min)) <0){
                    min = j;
                }
            }
            if (min !=i){
                T temp = students.get(i);
                students.set(i, students.get(min));
                students.set(min, temp);
            }
            }
            
    }

}
