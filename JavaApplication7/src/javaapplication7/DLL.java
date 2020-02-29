
package javaapplication7;


public class DLL <T extends Comparable<T>> {
    Node Head;
    Node Tail;
    
    public void InsertInOrder(T value) {
        Node<T> X = new Node<T>(value);
        if (Head == null){
            Head = X;
            Tail = X;
        }
        else {
            Node<T> Temporary = Head;            
            while(Temporary != null && X.Data.compareTo(Temporary.Data) > 0) {
                Temporary = Temporary.next;
            }
            if(Temporary == Head) {
                X.next = Head;
                Head.prev = X;
                Head = X;
            }
            else if (Temporary == null){
                Tail.next = X;
                X.prev = Tail;
                Tail = X;
            }
            else {
            Temporary.prev.next = X;
            Temporary.prev = X;
            X.prev = Temporary.prev;
            X.next = Temporary;
        }
      }
    }
    
    public String toString() {
        
        String Str = "";
        Node Temporary = Head;
            while (Temporary != null) {
                Str = Str + Temporary.getData() + " ";
                Temporary = Temporary.next;
            }        
        return Str;
    }
     
    public void clear() {
        Head = null;
    }
    
    public boolean find(T d) {
        Node Temporary = Head;
        while (Temporary != null) {
            if (Temporary.getData() == d)
                return true;
            else Temporary = Temporary.next;
        }
        return false;
    }
    
    public void delete(T d) {
        Node Temporary = Head;
        
        while (Temporary.getData() == d) {
                if (Temporary == Head) {
                    Head.next.prev = null;
                    Head = Head.next;
                }
                else if (Temporary == Tail) {
                    Tail.prev.next = null;
                    Tail = Tail.prev;
                    System.out.println("Delete");
                }
                else {
                    Temporary.prev.next = Temporary.next;
                    Temporary.next.prev = Temporary.prev;
                    Temporary = null;
                    System.out.println("Delete");
                }
                Temporary = Temporary.next;
        }
    }
    
    public void reverse(){
        if(Head == null){
            System.out.println("Empty List");
        }
        else{
            
        }
    }
}

