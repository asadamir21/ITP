
package project;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
public class Project {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StudentList S = new StudentList();
        boolean flag = true;
        do{
            int id = 0;
            String name = null;
            try{
                System.out.println("Enter Student Name and id");
                name = input.next();     
                id = input.nextInt();
                System.out.println("");
            }
            catch(Exception e){
                System.out.println("Enter Integers Format");
            }
            S.insert(name, id);
            System.out.println("");
               
            String Y;
            
            do{
                System.out.println("Is there any other Student? Press Y or N");
                Y = input.next(); 
                if(Y.equals("Y")){}
                else if(Y.equals("N")){
                    flag = true;
                }
                else{
                    System.out.println("Enter Y or N only");
                }
            }
            while(!Y.equals("Y") && !Y.equals("N"));
        }
        while(flag != true);
        System.out.println(S);
    }
}
