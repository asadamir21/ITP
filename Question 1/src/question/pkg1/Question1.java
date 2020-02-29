
package question.pkg1;

public class Question1 {

    public static void main(String[] args) {
        
        DLL List = new DLL();
        List.Insert(20);
        List.Insert(10);
        List.Insert(30);
        List.Insert(60);
       
        System.out.println(List);
        
        List.Reverse();   
    }
}
