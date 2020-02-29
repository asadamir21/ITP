
package project;

import java.util.Scanner;

public class StudentList {
    Student Head;
    Student Tail;
    int count = 0;
    String[] Days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    Boolean[] Check = {false, false, false, false, false, false, false};
    Scanner input = new Scanner(System.in);
    
    public void insert(String name, int id) {
        Student Temp = Head;
        
        Student N = new Student(name, id);
            
        if ( Head == null) {
            Head = N;            
            Tail = N;
	}
	else {
            Tail.next = N;
            Tail = N;
        }
        
        System.out.println("Is your Weekend Free? Press Y or N");   // Setting Weekend
        String Y;
        do{
            Y = input.next();
            if(Y.equals("Y")){
                Tail.list.weekend = true;
            }
            else if(Y.equals("N")){
                Tail.list.weekend = false;
            }
            else{
                System.out.println("Enter Y or N only");
            }
        }
        while(Y.equals("Y") || Y.equals("N"));
            
        System.out.println("");
        
        boolean flag = false;
        
        do{
            System.out.println("Enter Your Free Day");      // Setting DaysList of Student N
            try{
                String D = input.next();
                if(!Tail.list.weekend){
                    for (int i = 0; i < 5; i++) {
                        if(D.compareToIgnoreCase(Days[i]) == 0 && !Check[i]){
                            Check[i] = true;
                            break;
                        }  
                        else{
                            Exception e1 = new Exception();
                            throw e1;
                        }
                    }
                }
                else{
                    for (int i = 0; i < Days.length; i++) {
                        if(D.compareToIgnoreCase(Days[i]) == 0 && !Check[i]){
                            Check[i] = true;
                            break;
                        }  
                        else{
                            Exception e2 = new Exception();
                            throw e2;
                        }
                    }
                }
                N.list.insert(D);            
            }
            catch(Exception e){
                System.out.println("Either incorrect day or day already Busy");
            }
            
            System.out.println("Do you have any other free Day? Press Y or N");     // Asking if he has another free Day
            do{
                Y = input.next();
                if(Y.equals("Y")){}
                else if(Y.equals("N")){
                    flag = true;
                }
                else{
                    System.out.println("Enter Y or N only");
                }
            }
            while(Y.equals("Y") || Y.equals("N"));
        }
        while(flag != true); 
        count++;
    }
	
    public boolean find(String name) {
        Student N = Head;
	
        while (N != null) {
            if (N.name.compareTo(name) == 0){
		return true;
            }
            N = N.next;	
	}
	return false;
    }

    public int size(){
        return count;
    }
	
    public String toString() {
        Student Temp = Head;
	String str = "";
	
        while (Temp != null) {
            str = str + Temp;
            Temp = Temp.next;
	}
	return str;
    }
}
