public class Student{
    private static int count = 0;
    private String name;
    private int id;
    public Student(String n){
        name = n;
        count++;
        id = count;
    }
    public static int getCount(){
        return count;
    }
}