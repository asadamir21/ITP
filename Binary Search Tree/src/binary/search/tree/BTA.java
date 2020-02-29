
package binary.search.tree;

public class BTA<T extends Comparable<T>> {
    T[] tree;
    
    public BTA(int size){
        tree = (T[]) new Comparable[size];
    }
    
    public void insert(T d){
        int R = 0;
        if(tree[R] == null){
            tree[R] = d;
        }
        else{
            while(tree[R] != null){
                if(tree[R].compareTo(d) > 0){
                    R = 2*R + 1;
                }
                else{
                    R = 2*R + 2;
                }
            }
            tree[R] = d;
        }
    }

    public boolean find(T d){
        int R = 0;
        if(tree[R] == null){
            return false;
        }
        else{
            while(tree[R] != null && R < tree.length){
                if(tree[R].compareTo(d) == 0){
                    return true;
                }
                else if(tree[R].compareTo(d) > 0){
                    R = 2*R + 1;
                }
                else{
                    R = 2*R + 2;
                }
            }
        }
        return false;
    }
}





