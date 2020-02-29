
package javaapplication11;

public class ArrDict {
    NodeU Head;
    NodeU Tail;
    int length = 0;
    LinkList [] Arr;
     
    public ArrDict(){
        Arr = new LinkList[26];
            for(int j = 0; j < Arr.length; j++){
                Arr[j]= new LinkList();
        }
    }
     
    
    public void insert(String text, String URL) {
        NodeU N;
        NodeU Temporary;
        boolean flag = false;
        
        if (this.length == 0) {
            N = new NodeU(text);
            N.url.insert(URL);
            this.Head = N;
            this.Tail = N;
            this.length++;
        } 
        
        else {
            Temporary = this.Head;
            
            for (int i = 0; i < this.length; i++) {
                if (Temporary.d.equals(text)) {
                    Temporary.url.insert(URL);
                    flag = true;
                }
                Temporary = Temporary.next;
            }
            if (!flag) {
                N = new NodeU(text);
                N.url.insert(URL);
                this.Tail.next = N;
                this.Tail = N;
                this.length++;
            }
        }
    }

    public void Find(String word) {
        NodeU Temporary = this.Head;
        while (Temporary != null) {
            if (Temporary.d.equals(word)) {
                System.out.println("Word = " + word);
                System.out.println("URL's ; ");
                Temporary.url.display();
            }
            Temporary = Temporary.next;
        }
    }
    
    
    public String toString() {
        NodeU Temporary = this.Head;
        for (int i = 1; i < this.length; i++) {
            System.out.println("Word = " + Temporary.d);
            System.out.println("URL's :");
            Temporary.url.display();
            Temporary = Temporary.next;
        }
        return "";
    }
}
