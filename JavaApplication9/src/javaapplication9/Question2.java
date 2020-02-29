
package javaapplication9;

public class Question2 {

    public static void main(String[] args) {
        
       SearchEngine Eng = new SearchEngine();
       
       Eng.insert("Asia", "Wiki.com");
       Eng.insert("Asia", "iba.edu.pk");
       Eng.insert("Asia", "ibm.com");
       
       Eng.insert("Lahore", "lums.com");
       Eng.insert("Lahore", "iba.edu.com");
       Eng.insert("Lahore", "yahoo.com");
       
       Eng.insert("Admission","wikipedia.com");
       Eng.insert("Admission","nust.edu.pk");
       Eng.insert("Admission","yahoo.com");
    
       Eng.Find("Lahore");
    }
    
}
