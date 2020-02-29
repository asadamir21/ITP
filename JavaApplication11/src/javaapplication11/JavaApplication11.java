
package javaapplication11;


public class JavaApplication11 {

    
    public static void main(String[] args) {
        ArrDict arr = new ArrDict();
        
        arr.insert("Google", "www.gmail.com");
        arr.insert("Google", "www.youtube.com");
        arr.insert("Google", "www.GoogleDrive.com");
        arr.insert("Google", "www.translate.com");
        arr.insert("Google", "www.GoogleMaps.com");
        
        
        
        arr.Find("Google");
        
        System.out.println(arr);
    }
    
}
