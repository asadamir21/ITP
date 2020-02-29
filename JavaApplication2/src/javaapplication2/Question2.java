
package javaapplication2;

public class Question2 {
    
    public static void main(String[] args) {
        Poly poly1 = new Poly();
        Poly poly2 = new Poly();
        
        Poly result = new Poly();
        
        poly1.insert(3, 2);
        poly1.insert(4, 1);
        poly1.insert(10, 0);
        
        poly2.insert(2, 2);
        poly2.insert(-2, 1);
        poly2.insert(4, 0);
        
        result = result.add(poly1, poly2);
       
        System.out.print("Polynomial 1 is   ");
        poly1.display();
        System.out.println();
        
        System.out.print("Polynomial 2 is   ");
        poly2.display();
        System.out.println();
        
        System.out.print("Result is :       ");
        result.display();
        System.out.println();
      
    }
}
