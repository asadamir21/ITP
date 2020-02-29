
package project;

public class FreeList {
    FreeTime Head;
    FreeTime Tail;
    int count = 0;
    
    public void insert(int from, int to) throws Exception {
        FreeTime N = new FreeTime(from, to);
        if (Head == null) {
            Head = N;            
            Tail = N;
        }
        else {
            Tail.next = N;
            Tail = N;
        }
        count++;
    }
    
    public boolean find(int from, int to) {
        FreeTime N = Head;
	
        while (N != null) {
            if (N.From == from && N.To == to){
		return true;
            }
            N = N.next;	
	}
	return false;
    }

    public String toString() {
        FreeTime Temp = Head;
	String str = "";
	
        while (Temp != null) {
            str = str + "     Timing: " + Temp.From + "   -   " + Temp.To + "\n";
            Temp = Temp.next;
	}
	return str;
    }
}
