
package javaapplication2;

public class Poly {
    Node Head;
    
    public void insert(int c, int p){
        Node N = new Node(c,p);
        if(Head == null){
            Head = N;
        }
        else{
            Node Temp = Head;
            while (Temp.Next != null){
                Temp = Temp.Next;
            }
        
            Temp.Next = N;
        }   
    }
    
    public int getDegree() {
        Node Temp = Head;
        int max = 0;
        while (Temp.Next != null) {
            if (Temp.Power > max) {
                max = Temp.Power;
            }
            Temp = Temp.Next;
        }
        return max;
    }
    
    public Poly add(Poly p1,Poly p2){
        int degree = 0;
        Node temp = p1.Head;
        Node temp1 = p2.Head;
        Poly result = new Poly();
        if (p1.getDegree() > p2.getDegree()) {
            degree = p1.getDegree();
            temp = p1.Head;
            temp1 = p2.Head;
        }
        
        else {
               degree = p2.getDegree();
               temp = p1.Head;
               temp1 = p2.Head;
        }
        while (temp.Power > temp1.Power) {
            temp = temp.Next;
            degree--;
        }
        
        while (degree >= 0) {
          if (temp.Power == temp1.Power) {
              int a = temp.coef + temp1.coef;
              result.insert(a, degree);
              temp = temp.Next;
              temp1 = temp1.Next;
          }
           degree--;
        }
        
        return result;
    }
    public void display(){        
       Node temp = Head;
       while (temp != null){
           System.out.print(temp.coef + " " + " ");
           temp = temp.Next;
       } 
    }
}