
package bstd;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class BSTD {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BST dic = new BST(); 
       
        try{
            FileInputStream fstream = new FileInputStream("C:\\Users\\Asad\\Desktop\\Assignment 4\\Dictionary.txt");

            DataInputStream in = new DataInputStream(fstream);

            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String strLine;
    
            ArrayList<String> list = new ArrayList<>(10);
            
            while ((strLine = br.readLine()) != null) 	{
                list.add(strLine);      // adding lines to arraylist
            }   
            
            Iterator<String> i = list.iterator();
            
            while (i.hasNext()){        
                String s = i.next();                // removing empty lines
                if (s == null || s.isEmpty()){
                    i.remove();
                }
            }
            
            Collections.shuffle(list);          // shuffling arraylist
           
            String[] str;
            
            
            
            for (int j = 0; j < list.size(); j++) {
                if(list.get(j).contains("   ")){
                    list.get(j).replaceAll("   ", "  ");        // replacing '3 spaces with 2 spaces' 
                }
                
                if(list.get(j).contains("  ")){
                    str = list.get(j).split("  ");
                    dic.insert(str[0], str[1]);
                }  
            }
            
            System.out.println("Enter Word you wanna search in Dictionary");
            System.out.println(dic.find(input.next()));
            
            in.close();
        }
        
        catch (Exception e){
            System.err.println("Error: " + e.getMessage());
          
        }
    }    
}
