
package javaapplication9;

    
public class LinkList {
    
    NodeU Head;
    NodeU Tail;
    int length = 0;

    public void insert (String a){
        NodeU n = new NodeU (a) ;
        if (Head == null){
            Head = n;
            Tail = n;
            length++;
        }
        else {
            Tail.next = n;
            Tail = n;
            length++;
        }
    }
    
    public void display() {
        NodeU temp = Head;
        
        while(temp != null){
            System.out.println(temp.d);
            temp = temp.next;
        }

    }    
}
