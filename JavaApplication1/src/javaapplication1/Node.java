
package javaapplication1;

public class Node<T> {
    T Data;
    Node next;
    Node prev;
    
    public Node(T d) {
        this.Data = d;
    }
    public T getData() {
        return this.Data;
    }
}
