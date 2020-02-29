
package bstd;

public class BST <T extends Comparable<T>> {
    Node Root;
    private Node T;

    public void insert(String word, String meaning){
        Node n = new Node(word, meaning);
        if(Root == null){
            Root = n;
        }
        else{
            Node Temp = Root;
            Node parent = Root;
            
            while(Temp != null){
                if(word.compareToIgnoreCase(Temp.word) < 0){
                    parent = Temp;
                    Temp = Temp.left;
                }
                else{
                    parent = Temp;
                    Temp = Temp.right;
                }
            }
        
            if(word.compareToIgnoreCase(parent.word) < 0){
                parent.left = n;
            }
            else
                parent.right = n;
        }
    }
      
    public String find(String word){
        Node Temp = Root;
        
        if(Root == null){
            System.out.println("Dictionary is Empty");
        }
        else {
            while(Temp!= null){
                if(word.compareToIgnoreCase(Temp.word) == 0){
                    return "Meaning : \n" +  Temp.meaning;
                }
                else if(word.compareToIgnoreCase(Temp.word) < 0){
                    Temp = Temp.left;
                }
                else{
                    Temp = Temp.right;
                } 
            }
        }
        return "No Such Word";
    }   
    
    public void LNR(Node R){
        if(R != null){
            LNR(R.left);
            System.out.print(R.word + ", ");
            LNR(R.right);
        }
    }
    
    public void Deletion(String word){
        if(this.find(word).equals("No Such Word")){       // if not in the list
            System.out.println("Could not Find");
        }
        else{
            Node Temp = Root;
            Node prev = null;
            
            while(Temp != null & word.compareToIgnoreCase(Temp.word) != 0){ 
                prev = Temp;
                if(word.compareToIgnoreCase(Temp.word) < 0){
                   Temp = Temp.left;
                }
                else{
                    Temp = Temp.right;
                }
            }
            
            if(Temp != null && word.compareToIgnoreCase(Temp.word) == 0){   
                if(Temp.left == null && Temp.right == null){
                    if(prev.word.compareToIgnoreCase(Temp.word) > 0){   //  no child
                       prev.left = null;
                    }
                    else 
                       prev.right = null;
                }
                
                else if((Temp.left == null || Temp.right == null)){     //  one child
                    if(Temp.left == null){
                        if(prev.word.compareToIgnoreCase(Temp.word) > 0){
                            prev.left = Temp.right;
                        }
                    }
                    else{
                        if(prev.word.compareToIgnoreCase(Temp.word) < 0){
                            prev.right = Temp.left;
                        }
                        
                    }
                }
                else{       //  two child
                    Node N = Temp;
                    Node M = prev;
                    
                    if(Temp == Root){
                        M = null;
                    }
                    
                    M = N;
                    N = N.right;
                    
                    while(N.left != null){
                        M = N;
                        N = N.left;
                    }
                    
                    if(Temp != Root){              
                        if(prev.right == Temp){
                            prev.right = N;
                        }
                        else{
                            prev.left = N;
                        }
                        if(M.left == N){
                            M.left = N.right;
                        }
                        else{
                            
                            M.right = null;
                        }
                        N.left = Temp.left;
                        N.right = Temp.right;
                    }
                    else{
                        if(M.left == N){
                            M.left = N.right;
                        }
                        else{
                            M.right = null;
                        }
                        N.left = Root.left;
                        N.right = Root.right;
                        Root = N;
                    }
                }   
            }
        }
    }
}