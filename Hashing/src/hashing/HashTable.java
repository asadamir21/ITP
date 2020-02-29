
package hashing;

public class HashTable{
    Dictionary[] Table;
    int Count; // no.of elements in table
    int coll1 = 0;
    int coll2 = 0;
    
    public HashTable(int size) {
        Count = 0;
        Table = new Dictionary[size + size/3];
        for (int i = 0; i < Table.length; i++) {
            Table[i] = new Dictionary();
        }
    }

    public int strtoint(String word) {
        int sum = 0;
        for (int i = 0; i < word.length(); i++) {
            sum = sum + (int) word.charAt(i);
        }
        return sum;
    }

    public int Hash(String word) {
        return this.strtoint(word) % Table.length;
    }

    public void insert(String word, String meaning) {
        int N = this.Hash(word);
        int i = 0;
        if (isFull()) {
            System.out.println("Full! No more Space");
        }
        else {
            if(Table[N].word == null){
                Table[N].insert(word, meaning);
                Count++;
            }
            else {
                    //Quadratic probing
                int M = this.QRehash(word);
                if(M == -1){}
                else{
                    Table[M].insert(word, meaning);
                    Count++;
                }
            }    
        }
        
     //   Table[Count].insert(word, meaning);
      //  Count++;
    }
    
    public int QRehash(String s) {
        int index = this.Hash(s);
        int i = 1;
        for (int j = 0; j < 1000; j++) {
            index = index + (int)Math.pow((i++),2);
            index = index % this.Table.length;
            if (Table[index] == null) {
                    return index;
            }
        }
        return -1;
    }
    
	// for full hash table
    public boolean isFull() {
        return (Count == Table.length);
    }

	// empty hash table
    public boolean isEmpty() {
        return Count == 0;
    }

    public void displayTable() {
        for (int i = 0; i < Table.length; i++) {
            if(Table[i].word == null){}
            else{
                System.out.println(i + "->  " + Table[i].word + "  ");
            }
	}
    }
        // for searching 
    public String Find(String word){
        for (int i = 0; i < Table.length; i++) {
            if(Table[i].word == null){}
            else{
                if(Table[i].word.compareTo(word) == 0){
                    return Table[i].meaning;
                }
            }
        }
        return "No Such Word";
    }
    
    public void Delete(String word){
        if(Find(word).equals("No Such Word")){
            System.out.println("Cannot Delete the word");
        }
        else{
            for (int i = 0; i < Table.length; i++) {
                if(Table[i].word == null){}
                else{
                    if(Table[i].word.compareToIgnoreCase(word) == 0){
                        Table[i].word = null;
                        Table[i].meaning = null;
                        break;
                    }
                }
            }
        }
    }
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   
