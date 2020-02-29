
package project;

import java.util.Scanner;

public class DaysList {
    Days Head;
    Days Tail;
    int count = 0;
    boolean weekend = false;
    Scanner input = new Scanner(System.in);
    
    public void insert(String day) {
        Days N = new Days(day);
        N.time = new FreeList();
        
        
        if(count <= 5 && (!"Saturday".equals(day) && !"Sunday".equals(day))){
            if(!weekend){
                if (Head == null) {
                    Head = N;            
                    Tail = N;
                }
                else {
                    Tail.next = N;
                    Tail = N;
                }
            }
        }
        else if(weekend){
            if(count <= 7){
                if (Head == null) {
                    Head = N;            
                    Tail = N;
                }
                else {
                    Tail.next = N;
                    Tail = N;
                }
            }
        }
        else{
            System.out.println("Your Weekend is off");
            System.out.println("");
        }
        count++;
        
        boolean flag = false;
        do{
            System.out.println("Enter your Free Time on " + Tail.Days);
            try{
                int from = input.nextInt();
                int to = input.nextInt();
                N.time.insert(from, to);
                
            }
            catch(Exception e){
                System.out.println("Time can only be integer");
            }

            System.out.println("Do you have any other free Time? Press Y or N");
            String Y = input.next();
            if(Y.equals("Y")){}
            else if(Y.equals("N")){
                flag = true;
            }
            else{
                System.out.println("Enter Y or N only");
            }
        }
        while(flag != true);
    }
	
    public void Weekend(){
        weekend = true;
    }
    
    public boolean find(String days) {
        Days N = Head;
	
        while (N != null) {
            if (N.Days.compareTo(days) == 0){
		return true;
            }
            N = N.next;	
	}
	return false;
    }

    public String toString() {
        Days Temp = Head;
	String str = "";
	
        while (Temp != null) {
            str = str + "     Days:  " + Temp.Days + "   Timing: " + Temp.time + "\n";
            Temp = Temp.next;
	}
	return str;
    }
}

