
package Question2;

public class StackExp{
    Stack MyStk = new Stack();
    String Postfix ="";
    
    public String infixtoPostfix(String expr) {
        int i = 0;
        char ch;
        while (i < expr.length()) {
            ch = expr.charAt(i++);
            switch (ch) {
                case '[':
                case '{':
                case '(':
                    //MyStk.push(ch); 
                    break;
                
                case '+':
                case '-':
                    Setpriority(ch, 1); 
                    break; 
                
                case '*':
                case '/':
                    Setpriority(ch, 2); 
                    break; 
                
                case ')':
                case '}':
                case ']':
                    SetAtClose(ch); 
                    break;
                
                default:
                    Postfix = Postfix + ch;
                    

            }
        } 
          
        while(!MyStk.isEmpty()){
            Postfix = Postfix + MyStk.pop();
            
        }
        return Postfix;
    }
    
    
    public void Setpriority(char c, int Priority){
	while(!MyStk.isEmpty()){
            char ch = (Character)MyStk.pop(); // [(A+B)/B+A-C+(B-C)]
            
            int Priority2 = 0;
            
            if(ch == '+' || ch == '-'){
                Priority2 = 1;
            }
            else if (ch == '/' || ch == '*'){
                Priority2 = 2;
            }
            
            if(Priority > Priority2){
                MyStk.push(ch);
		break;
            }
            else{
                if(ch != '(' && ch != '{' && ch != '['){
                    Postfix = Postfix + ch;
		}                
            }
	}
	MyStk.push(c);	 
    }
    
    
    public void SetAtClose(char c){
        while(!MyStk.isEmpty() && c != '(' && c != '{' && c != '['){
            Postfix = Postfix + MyStk.pop();
        }
    }    
}

    
