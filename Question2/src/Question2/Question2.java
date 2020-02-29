
package Question2;

public class Question2 {

    public static void main(String[] args) {
        String input = "[(A+B)/B+A-C+(B-C)]";
        
        StackExp s1 = new StackExp();
        
        System.out.println(s1.infixtoPostfix(input));
     
    } 
}
