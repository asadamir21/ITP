
package question3;



public class Question3 {
    public static void main(String[] args) {
        
        String str = "AB + B / A + C - B C - +";
        
        Stack<Integer> MyStk = new Stack<>();
        
        for (int i = 0; i < str.length(); i++) {
            char symb = str.charAt(i);
            if(!(symb == '+'|| symb == '-'||symb == '*' || symb == '/')){
                MyStk.push((symb - (char)48.0)); 
            }
            else{
                Integer Opnd1 = MyStk.pop();
                Integer Opnd2 = MyStk.pop();
                Integer Value;
                switch (symb) {
                    case '+':
                        Value= Opnd1 + Opnd2;
                        MyStk.push(Value);
                        break;
                    case '-':
                        Value = Opnd2 - Opnd1;
                        MyStk.push(Value);
                        break;
                    case '*':
                        Value = Opnd1 * Opnd2;
                        MyStk.push(Value);
                        break;
                    case '/':
                        Value = Opnd2/Opnd1;
                        MyStk.push(Value);
                        break;
                    default:
                        break;
                }
            }
        }
        System.out.println(MyStk.pop());
    }    
}
