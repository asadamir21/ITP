
package javaapplication25;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class NewClass {
   static String timeConversion(String s) {
        // Complete this function
        String[] time = s.split(":");
        
        if((Integer.parseInt(time[0]) < 12) && (time[2].contains("PM"))){
            int hr = Integer.parseInt(time[0]);
            hr += 12;               
            time[0] = hr + "";
        }
        else if(((Integer.parseInt(time[0]) == 12) && (time[2].contains("AM")))){
            int hr = Integer.parseInt(time[0]);
            hr = 00;               
            time[0] = "0" + hr + "";
        }
        
        String Temp = "";
        
        if(time[time.length - 1].contains("PM")){
            Temp = time[time.length - 1].replace("PM", "");
            time[time.length - 1] = Temp;
        }
        
        if(time[time.length - 1].contains("AM")){
            Temp = time[time.length - 1].replace("AM", "");
            time[time.length - 1] = Temp;
        }
        
        
        s = ""; 
        
        for(int i = 0; i < time.length; i++){
            if(i < time.length - 1){
                s += time[i] + ":";
            }
            else{
                s += time[i];
            }
        }
        
        return s;
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = timeConversion(s);
        System.out.println(result);
    }
}