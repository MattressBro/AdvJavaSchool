package Module6;

public class Student {
    //set up variables
    private int rollno;
    private String name;
    private String address;
    public Student(int rollno, String name, String address){
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }
    //getters
    public int getRollno(){
        return rollno;
    }
    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    //toString method
    @Override
    public String toString(){
        return "Roll number: " + rollno +"\nName: "+ name +"\nAddres: "+address;
    }
}
