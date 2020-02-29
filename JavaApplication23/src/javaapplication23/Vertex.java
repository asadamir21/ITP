
package javaapplication23;

import java.util.LinkedList;

public class Vertex {
     String label;
     boolean visit = false;
     LinkedList<Vertex> L = new LinkedList<Vertex>();
     int component;
       
     public Vertex(String l) {
         label = l;
         component = 0;
     }
}


