
package hashing;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Hashing {
    public static void main(String args[]) {
        
        Scanner input = new Scanner(System.in);
        
        try{
            FileInputStream fstream = new FileInputStream("C:\\Users\\Asad\\Desktop\\Assignment 4\\Dictionary.txt");

            DataInputStream in = new DataInputStream(fstream);

            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String strLine;
    
            ArrayList<String> list = new ArrayList<>(10);
            
            int count = 0;      // no. of line in txt file
            
            while ((strLine = br.readLine()) != null) 	{
                list.add(strLine);
                count++;
            }
        
            Iterator<String> i = list.iterator();
            
            while (i.hasNext()){        // to remove empty line 
                String s = i.next();
                if (s == null || s.isEmpty()){
                    i.remove();
                }
            }
       
            String[] str;
            
            HashTable H = new HashTable(list.size());
            
            for (int j = 0; j < list.size(); j++) {
                if(list.get(j).contains("   ")){
                    list.get(j).replaceAll("   ", "  ");    // replacing ' 3 spaces with 2 spaces'
                }
                
                if(list.get(j).contains("  ")){
                    str = list.get(j).split("  ");          // splitting 2 spaces
                    H.insert(str[0], str[1]);
                }  
            }
            
            System.out.println("Enter word you wanna search in Dictionary");
            System.out.println(H.Find(input.next()));
            
        }
        
        catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }    
    } 
}
    
    
    
    
    
    
    
    
    
    
    
    
  