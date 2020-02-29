
package Question2;

public class Stack<T extends Comparable<T>> {	
    T[] arr;
    int top;
    
    public Stack() {
        arr = (T[]) new Comparable[10];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == arr.length - 1;
    }

    public void push(T data) {
        if (isFull()) {
            System.out.println("Overflow :( ");
        }
        else
            arr[++top] = data;
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("Underflow");
            return null;
	}
        else
            return arr[top--];
    }

    public String toString() {
	String str = "";
        int count = top;
        while(count != -1){
            str = str + arr[count] + " ";
            count--;
        }
        return str;
    }
}
