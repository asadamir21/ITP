
package javaapplication23;

public class JavaApplication23 {

    public static void main(String[] args) {
        Graph g = new Graph(10);
        
        g.Addvertex("Asad");
        g.Addvertex("Farmal");
        g.Addvertex("Maqsood");
        g.Addvertex("Saad");
        g.Addvertex("Basathia");
        g.Addvertex("Rafique");
        g.Addvertex("Kumar");
        g.Addvertex("Ammar");
        
        g.AddEdge("Asad", "Farmal");
        g.AddEdge("Farmal", "Saad");
        g.AddEdge("Asad", "Saad");
        g.AddEdge("Basathia", "Farmal");
        g.AddEdge("Kumar", "Ammar");
        g.AddEdge("Kumar", "Saad");
        g.AddEdge("Kumar", "Asad");
        g.AddEdge("Basathia", "Ammar");
        
        g.DFS();
    }
    
}
