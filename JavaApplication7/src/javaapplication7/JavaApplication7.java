
package javaapplication7;


public class JavaApplication7 {


    public static void main(String[] args) {
        DLL<Integer> d1 = new DLL<Integer>();
        
        for (int i = 0; i < 10; i++) {
            d1.InsertInOrder(i);
        }
        
        
        System.out.println(d1);
        
        d1.clear();
        d1.reverse();
        
        System.out.println(d1);
        
    }
    
}
