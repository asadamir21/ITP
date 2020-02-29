
package javaapplication23;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {   
     ArrayList<Vertex> AdjList;
     int count = 0;
    
     public Graph(int s){
         AdjList = new ArrayList<Vertex>(s);
     }

     public void Addvertex(String L){
         Vertex N = new Vertex(L);
         AdjList.add(count,N);
         count++;
     }
 
     public void AddEdge(String l1,String l2){
         int C1 = -1;
         int C2 = -1;
         
         for (int i = 0; i < AdjList.size(); i++) {
             if(AdjList.get(i).label.compareTo(l1) == 0){
                C1 = i;
             }
         }
         
         for (int i = 0; i < AdjList.size(); i++) {
             if(AdjList.get(i).label.compareTo(l2) == 0){
                C2 = i;
             }
         }
         
         AdjList.get(C1).L.add(AdjList.get(C2));
         AdjList.get(C2).L.add(AdjList.get(C1));
     }
 
     public void DFS(){
         Stack<Vertex> Stk = new Stack<>();
         boolean[] visit = new boolean[count];
         int[] comp = new int[count];
         int cc = 0;
         int j = 0;
         
         while(j <= visit.length){
             if(j == visit.length){
                 break;
             }
             else if(visit[j] == true){
                 j++;
                 continue;
             }
             else{
                 cc++;
                 Stk.push(AdjList.get(j));
                 visit[j] = true;
                 System.out.println(" " + AdjList.get(j).label);
                 comp[j] = cc;
                 int i;
                 
                 while(!Stk.empty()){
                     LinkedList<Vertex> l = Stk.peek().L;
                     
                     for (i = 0; i < l.size() && visit[AdjList.indexOf(l.get(i))] != false;){
                         i++;
                     }
                     
                     if(i < l.size() && visit[AdjList.indexOf(l.get(i))]){
                         visit[AdjList.indexOf(l.get(i))] = true;
                         Stk.push(l.get(i));
                         comp[AdjList.indexOf(l.get(i))] = cc;
                         System.out.println(" " + l.get(i).label);
                     }
                     else{
                         Stk.pop();
                     }
                 }
             }
             j++;
         }
         System.out.println("Total Connected Component = " + cc);
     }
     
     public int component(){
         return 0;
     }
}

