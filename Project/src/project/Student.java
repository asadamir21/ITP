
package project;

public class Student {
    String name;
    int id;
    Student next;
    DaysList list;
    
    public Student(String name, int id){
        this.name = name;
        this.id = id;
        list = new DaysList();
    }   
    
    public void setDay(String day, int from, int to){
        list.insert(day);
    }
    
    public String toString(){
        String str = "";
        str = str + "Name: " + this.name + "  Id:    " + this.id + "\n";
        return str + list + "\n";
    }
}
