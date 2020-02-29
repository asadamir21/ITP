
package question.pkg1;

public class DLL {
    Node Head;
    Node Tail;
        
    public void Insert(int data){
        Node N = new Node(data);
        if(this.Head == null){
            this.Head = N;
            this.Tail = N;
        }
        else {
            Node Temporary = this.Head;            
            
            while(Temporary != null) {
                Temporary = Temporary.next;
                       
            }
            
            if (Temporary == this.Head) {
                N.next = this.Head;
                this.Head.prev = N;
                this.Head = N;
            }
            
            else if (Temporary == null){
                this.Tail.next = N;
                N.prev = this.Tail;
                this.Tail = N;
            }
            
            else {
                N.prev = Temporary.prev;
                N.next = Temporary;
                Temporary.prev.next = N;
                Temporary.prev = N;
            }
            
        }
    }
    
    public String toString() {
        String S = "";
        Node Temporary = this.Head;
        while (Temporary != null) {
            S = S + Temporary.data + " ";
            Temporary = Temporary.next;
        }
        return S;
    }
   
    public void Reverse(){
        Node Temporary = this.Head;
        Node Temporary1 = this.Tail;
        Node Temporary2 = this.Tail;
    
        while (Temporary1 != null && Temporary != null) {
            Temporary = Temporary1;
            Temporary.next = Temporary1.prev;
            Temporary.prev = Temporary1.next;
            System.out.print(Temporary.data + " ");
            Temporary1 = Temporary1.prev;
                
            if(Temporary.next == null) {
                this.Tail = Temporary;
            }
        }
   }
}
