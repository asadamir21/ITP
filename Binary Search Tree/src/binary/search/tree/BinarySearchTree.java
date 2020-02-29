
package binary.search.tree;

public class BinarySearchTree {

    public static void main(String[] args) {
        BTree<Integer> T = new BTree<>();
        
        T.insert(58);
        T.insert(8);
        T.insert(82);
        T.insert(17);
        System.out.println(T.find(17));
     
        T.LNR(T.Root);
        System.out.println("");
        T.LRN(T.Root);
        System.out.println("");
        T.NLR(T.Root);
        System.out.println("");
        T.Deletion(82);
        T.LNR(T.Root);
    }
    
}
