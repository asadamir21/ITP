package firstnfollow;

public class FirstNFollow {

    static String[] Productions = new String[8];
    
    static char[][] First = new char[8][100];
    static int n = 0;
    
    static char[][] Follow = new char[8][100];
    static char ck;
    static int m = 0;
    
    static char[] first = new char[9];
    static char[] f = new char[9];
    
    
    public static void main(String[] args) {
        int jm = 0;
        int km = 0;
        
        Productions[0] = "E=TR";
        Productions[1] = "R=+TR";
        Productions[2] = "R=#";
        Productions[3] = "T=FY";
        Productions[4] = "Y=*FY";
        Productions[5] = "Y=#";
        Productions[6] = "F=(E)";
        Productions[7] = "F=i";
    
        char c;
        
        
        for (int i = 0; i < First.length; i++) {
            for (int j = 0; j < First[i].length; j++) {
                First[i][j] = '!';
            }
        }
    
        int point1 = 0, point2, temp; 
        char done[] = new char[Productions.length];
        int count = -1;
    
        for (int i = 0; i < Productions.length; i++) {
            c = Productions[i].charAt(0);
            point2 = 0; 
            temp = 0; 
          
        // Checking if First of c has 
        // already been calculated 
            for (int j = 0; j <= count; j++) {
                if(c == done[j]){ 
                    temp = 1; 
                }
            }
            if (temp == 1){ 
                continue; 
            }
          
            // Function call     
            findFirst(c, 0, 0);
            count += 1; 
          
            // Adding c to the calculated list 
            done[count] = c; 
            System.out.print("First("+ c +") = "); 
            
            First[point1][point2++] = c;
            
            
            // Printing the First Sets of the grammar 
            for (int j = 0 + jm; j < n; j++) {
                
                int chk = 0; 

                for (int k = 0; k < point2; k++) {
                    if (first[j] == First[point1][k]){ 
                        chk = 1; 
                        break; 
                    } 
                } 
                if(chk == 0) { 
                    System.out.print(first[i] + ", "); 
                    
                    First[point1][point2++] = first[i]; 
                } 
            } 
            System.out.println("");
            jm = n; 
            point1++; 
        } 
        
        System.out.println("-----------------------------------------------");
        System.out.println("");
        
        char donee[] = new char[Productions.length];
        
        count = -1; 

        // Initializing the calc_follow array 
        for (int i = 0; i < Follow.length; i++) {
            for (int j = 0; j < Follow[i].length; j++) {
                Follow[i][j] = '!';
            }
        }
        point1 = 0; 
        int land = 0; 
        
        for (int i = 0; i < Productions.length; i++) {
            ck = Productions[i].charAt(0);
            point2 = 0; 
            temp = 0; 

            // Checking if Follow of ck 
            // has alredy been calculated 
            for (int j = 0; j <= count; j++) {
                if(ck == donee[j]){ 
                    temp = 1; 
                }
            }

            if (temp == 1){ 
                continue; 
            }
            land += 1; 

            // Function call 
            findFollow(ck); 
            count += 1; 

            // Adding ck to the calculated list 
            donee[count] = ck; 
            System.out.print(" Follow(" + ck + ") = { "); 
            
            Follow[point1][point2++] = ck; 
            
            // Printing the Follow Sets of the grammar 
            for (int j = 0 + km; j < m; j++) {
                
                int chk = 0; 
                for (int k = 0; k < point2; k++) {
                    if (f[i] == Follow[point1][k]){
                        chk = 1; 
                        break; 
                    } 
                } 
                if(chk == 0){ 
                    System.out.print(f[i] + " "); 
                    Follow[point1][point2++] = f[i];
                } 
            } 
            System.out.println("");
            km = m; 
            point1++;  
        } 
    } 
    
    public static void findFirst(char c, int q1, int q2){
         int j; 

        // The case where we  
        // encounter a Terminal 
        if(!Character.isUpperCase(c)){
            first[n++] = c; 
        } 
        
        for(j = 0; j < Productions.length; j++) { 
            if(Productions[j].charAt(0) == c){ 
                if(Productions[j].charAt(2) == '#'){ 
                    if(Productions[q1].charAt(q2) == '\0'){ 
                        first[n++] = '#'; 
                    }
                    else if(Productions[q1].charAt(q2) != '\0' && (q1 != 0 || q2 != 0)) { 
                        // Recursion to calculate First of New 
                        // Non-Terminal we encounter after epsilon 
                        findFirst(Productions[q1].charAt(q2), q1, (q2+1)); 
                    } 
                    else{
                        first[n++] = '#'; 
                    }
                } 
                else if(!Character.isUpperCase(Productions[j].charAt(2))){ 
                    first[n++] = Productions[j].charAt(2); 
                } 
                else{ 
                    // Recursion to calculate First of 
                    // New Non-Terminal we encounter  
                    // at the beginning 
                    findFirst(Productions[j].charAt(2), j, 3); 
                } 
            } 
        }
    }
    
    public static void findFollow(char c){
        
        // Adding "$" to the follow 
        // set of the start symbol 
        if(Productions[0].charAt(0) == c) { 
            f[m++] = '$'; 
        } 
        
        for (int i = 0; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                
                if(Productions[i].charAt(j) == c){ 
                    if(Productions[i].charAt(j+1) != '\0') { 
                        // Calculate the first of the next 
                        // Non-Terminal in the production 
                        followFirst(Productions[i].charAt(j+1), i, (j+2)); 
                    } 

                    if(Productions[i].charAt(j+1) == '\0' && c != Productions[i].charAt(0)){ 
                        // Calculate the follow of the Non-Terminal 
                        // in the L.H.S. of the production 
                        findFollow(Productions[i].charAt(0)); 
                    } 
                }  
            } 
        } 
    }
    
    public static void followFirst(char c, int c1, int c2){ 
        int k; 
      
        // The case where we encounter 
        // a Terminal 
        if(!Character.isUpperCase(c)){
            f[m++] = c; 
        }
        else{ 
            int i = 0, j = 1; 
            for(i = 0; i < Productions.length; i++) { 
                if(First[i][0] == c){ 
                    break; 
                }
            } 

            //Including the First set of the 
            // Non-Terminal in the Follow of 
            // the original query 
            while(First[i][j] != '!'){ 
                if(First[i][j] != '#')  { 
                    f[m++] = First[i][j]; 
                } 
                else{ 
                    if(Productions[c1].charAt(c2) == '\0'){ 
                        // Case where we reach the 
                        // end of a production 
                        findFollow(Productions[c1].charAt(0)); 
                    } 
                    else{ 
                        // Recursion to the next symbol 
                        // in case we encounter a "#" 
                        
                        followFirst(Productions[c1].charAt(c2), c1, c2+1); 
                    } 
                } 
                j++; 
            } 
        } 
    } 
}