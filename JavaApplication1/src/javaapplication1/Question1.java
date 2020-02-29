
package javaapplication1;

public class Question1 {

    public static void main(String[] args) {
        DLL<Integer> List = new DLL<Integer>();
        for (int i = 0; i < 40; i++) {
            List.InsertInOrder(i + 1);
        }
        
        System.out.println(List.find(20));
        List.delete(1);
        List.delete(40);
        System.out.println(List);
    }
}
