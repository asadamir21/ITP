
package question1;

public class Queue{
    Customer[] arr;
    int F;
    int R;
    
    public Queue(int size){
        arr = new Customer[size];
        F = size - 1;
        R = size - 1;
    }
    
    public void CustomerEnter(int id){
        if (isFull()){
            System.out.println("None can enter, Queue is Full"); 
        }
        else{
            R = (R + 1) % (arr.length - 1);
            arr[R] = new Customer(id);
        }
    }
 
    public Customer ServeCustomer(){
        if (isEmpty()){
            System.out.println("None to Serve, Queue is Empty"); 
            return null;
        }
        else{
            F = (F + 1)% (arr.length - 1);
        }
        return arr[F];
    }
    
    public void CancelAll(){
        if (isEmpty()){
            System.out.println("Nothing to Cancel, Queue is Empty");
            
        }
        else{
            for (int i = arr.length - R - 1; i < arr.length - 1; i++) {
                arr[i] = null;
            }
            F = arr.length - 1;
            R = arr.length - 1;
        }
    }
    
    public void ShowAll(){
        if (isEmpty()){
            System.out.println("Nothing to show, Queue is Empty");         
        }
        else{
            for (int i = arr.length - R - 1; i < arr.length - 1; i++) {
                System.out.print(arr[i].id + " ");
            }
            System.out.println("");
        }
    }
    
    public void HomeDelivery(){
        if (isFull()){
            System.out.println("Home Delivery not available");         
        }
        else{
            System.out.println("Home Delivery Available");
        }
    }
    
    public boolean isEmpty(){
        if(F == R){
            return true;
        }
        else return false;
    }

    public boolean isFull(){
        if((R + 1) % arr.length == F){
            return true;
        }
        else return false;
    }
}
