
package question1;

public class Question1 {

    public static void main(String[] args) {
        
        Queue q = new Queue(20);
        
        
        for (int i = 1; i < 19; i++) {
            q.CustomerEnter(i);
        }
        
        q.ShowAll();
        q.CancelAll();
        q.ShowAll();
        
        for (int i = 1; i < 19; i++) {
            q.CustomerEnter(i);
        }
        
        q.ShowAll();
        
        q.CancelAll();
        
        q.HomeDelivery();
    }
}
