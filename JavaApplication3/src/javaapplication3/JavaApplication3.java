
package javaapplication3;

public class JavaApplication3 {
    
    public static void main(String[] args){
       LinkList L1 = new LinkList();
       
       L1.insert("Don Quicote", 500);
       L1.insert("Harry Potter", 200);
       L1.insert("A Tale of Two Cities", 150);
       L1.insert("Lord of the Rings", 50);
       
       L1.display();
        
       System.out.println(L1.find("Harry Potter"));
        
       L1.removeLink("Harry Potter");
       
        System.out.println("");
       
       L1.display();
        
        
    }
}

class Link{
    public String bookName;
    public int millionSold;
    Link next;
    
    Link(String bookName, int millionSold){
        this.bookName = bookName;
        this.millionSold = millionSold;
    }
    
    public void display(){
        System.out.println(bookName + " :  " + this.millionSold + ",000,000");
    }
}

class LinkList{
    public Link firstLink;
    
    LinkList(){
        this.firstLink = null;
    }
    
    public boolean isEmpty(){
        if(this.firstLink == null){
            return true;
        }
        else return false;
    }
    
    public void insert(String bookName, int millionSold){
        Link temp = new Link(bookName, millionSold);

        temp.next = firstLink;
        this.firstLink = temp;
    }
    
    public Link removeFirst(){
        Link temp = this.firstLink;
        
        if(isEmpty()){
            this.firstLink = this.firstLink.next;
        }
        else{
            System.out.println("Empty LinkList");
        }
        return temp;
    }
    
    public void display(){
        Link temp = this.firstLink;
        
        while(temp != null){
           // temp.display();
            System.out.println(temp.bookName + "                " + temp.millionSold);
            temp = temp.next;
        }
    }
    
    public boolean find(String bookName){
        boolean flag = false;
        Link temp = this.firstLink;
        if(isEmpty()){
            while(temp.bookName != bookName){
                if(temp.next == null){
                    flag = false;
                }
                else {
                    temp = temp.next;
                }
            }
            flag = true;
        }
        else {
            System.out.println("Empty Link List");
        }
        return flag;
    }
    
    public Link removeLink(String bookName){
        Link currentLink = this.firstLink;
        Link previousLink = this.firstLink;
        
        while(currentLink.bookName != bookName){
            if(currentLink.next == null){
                return null;
            }
            else{
                previousLink = currentLink;
                currentLink =currentLink.next;
            }
        }
        
        if(currentLink == this.firstLink){
            this.firstLink = this.firstLink.next;
        }
        else{
            previousLink.next = currentLink.next;
        }
         
        return currentLink;
    }
}

