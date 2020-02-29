
package project;

public class FreeTime {
    int From;
    int To;
    FreeTime next;
    
    public FreeTime(int From, int To) throws Exception{
        try{
            if(From < To){
                this.From = From;
                this.To = To;
            }
            else{
                throw new Exception();
            }
        }
        catch(Exception e){
            System.out.println("Initial Time can never be greater than Final Time");
        }
    }
    
    public String toString(){    
        String F = From + ":00";
        String T = To + ":00";
        return F + "  -  "  + T;
    }
}
