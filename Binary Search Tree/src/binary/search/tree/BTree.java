
package binary.search.tree;

public class BTree<T extends Comparable<T>> {
    Node<T> Root;
    private Node<T> T;

    public void insert(T d){
        Node<T> n = new Node<>(d);
        if(Root == null){
            Root = n;
        }
        else{
            Node<T> temp = Root;
            Node<T> parent = Root;
            
            while(temp!=null){
                if(d.compareTo(temp.value) < 0){
                    parent = temp;
                    temp = temp.left;}
                else{
                    parent = temp;
                    temp = temp.right;
                }
            }
        
            if(d.compareTo(parent.value) < 0){
                parent.left = n;
            }
            else
                parent.right = n;
        }
    }
      
    
    

    public boolean find(T d){
        Node<T> Temp = Root;
        
        if(Root == null){
            return false;
        }
        else {
            while(Temp!= null){
                if(Temp.value.compareTo(d) == 0){
                    return true;
                }
                else if(d.compareTo(Temp.value) < 0){
                    Temp = Temp.left;
                }
                else{
                    Temp = Temp.right;
                } 
            }
        }
            
           
        return false;
    }   
    
    public void LNR(Node<T> R){
        if(R != null){
            LNR(R.left);
            System.out.print(R.value + ", ");
            LNR(R.right);
        }
    }
    
    public void NLR(Node<T> R){
        if(R != null){
            System.out.print(R.value + ", ");
            LNR(R.left);
            LNR(R.right);
        }
    }
    
    public void LRN(Node<T> R){
        if(R != null){
            LNR(R.left);
            LNR(R.right);
            System.out.print(R.value +  ", ");
        }
    }
    
    public void Deletion(T d){
        if(!this.find(d)){
            System.out.println("Could not Find");
        }
        else{
            Node<T> Temp = Root;
            Node<T> prev = null;
            
            while(Temp != null & d.compareTo(Temp.value) != 0){ 
                prev = Temp;
                if(d.compareTo(Temp.value) < 0){
                   Temp = Temp.left;
                }
                else{
                    Temp = Temp.right;
                }
            }
            
             if(Temp != null && d.compareTo(Temp.value) == 0){
                if(Temp.left == null && Temp.right == null){
                   if(prev.value.compareTo(Temp.value) < 0){
                       prev.right = null;
                   }
                   else 
                       prev.left = null;
                }
                else if((Temp.left == null || Temp.right == null)){
                
                }
            
             }
        }
    }
}
