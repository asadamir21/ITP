
package editdistance;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class Path {
    public int distance;
    public String editSequence;
    public String topAlignmentRow;
    public String bottomAlignmentRow;
    public int[][] arrange;
   
    public String str1;
    public String str2;  
    
    public Path(String str1, String str2){
        this.str1 = str1;
        this.str2 = str2;
        cost(this.str1, this.str2);
    }
    
    public void cost(String s1, String s2){
        s1 = "\u0000" + s1;
        s2 = "\u0000" + s2;

        final int[][] d = new int[s2.length() + 1][s1.length() + 1];
        final Map<Point, Point> parentMap = new HashMap<>();

        for (int i = 0; i < s2.length(); i++) {
            d[i][0] = i+1;
        }
        
        for (int i = 0; i < s1.length(); i++) {
            d[0][i] = i+1;
        }
        
        for (int j = 1; j <= s1.length(); j++) {
            for (int i = 1; i <= s2.length(); i++) {
                int dij = 0; 
                if(s1.charAt(j - 1) == s2.charAt(i - 1)){
                    dij = 0;
                }
                else{
                    dij = 1;
                }

                int tentativeDistance = d[i - 1][j] + 1;
                String S = "I";
                
                if (tentativeDistance > d[i][j - 1] + 1) {
                    tentativeDistance = d[i][j - 1] + 1;
                    S = "D";
                }

                if (tentativeDistance > d[i - 1][j - 1] + dij) {
                    tentativeDistance = d[i - 1][j - 1] + dij;
                    S = "S";
                }

                d[i][j] = tentativeDistance;
                switch (S) {
                    case "S":
                        parentMap.put(new Point(i, j), new Point(i - 1, j - 1));
                        break;
                    case "I":
                        parentMap.put(new Point(i, j), new Point(i - 1, j));
                        break;
                    case "D": 
                        parentMap.put(new Point(i, j), new Point(i, j - 1));
                        break;
                    default:
                        break;
                }
            }
        }

        String topLineBuilder = "";
        String bottomLineBuilder = "";
        String editSequenceBuilder = "";
        Point current = new Point(s2.length(), s1.length());

        while (true) {
            Point predecessor = parentMap.get(current);

            if (predecessor == null) {
                break;
            }
            if (current.x != predecessor.x && current.y != predecessor.y) {
                final char schar = s1.charAt(predecessor.y);
                final char zchar = s2.charAt(predecessor.x);

                topLineBuilder = schar + topLineBuilder;
                bottomLineBuilder = zchar + bottomLineBuilder;
                if(schar != zchar){
                    editSequenceBuilder = "S" + editSequenceBuilder;
                }
                else{
                    editSequenceBuilder = "N" + editSequenceBuilder;
                }
            } 
            else if (current.x != predecessor.x) {
                topLineBuilder = "-" + topLineBuilder;
                bottomLineBuilder = s2.charAt(predecessor.x) + bottomLineBuilder;
                editSequenceBuilder = "I" + editSequenceBuilder;
            } 
            else {
                topLineBuilder = s1.charAt(predecessor.y) + topLineBuilder;
                bottomLineBuilder = "-" + bottomLineBuilder;
                editSequenceBuilder = "D" + editSequenceBuilder;
            }
            current = predecessor;
        }
        
        topLineBuilder = topLineBuilder.substring(1, topLineBuilder.length());
        bottomLineBuilder = bottomLineBuilder.substring(1, bottomLineBuilder.length());
        editSequenceBuilder = editSequenceBuilder.substring(1, editSequenceBuilder.length());
             
        this.distance           = d[s2.length()][s1.length()];
        this.editSequence       = editSequenceBuilder;
        this.topAlignmentRow    = topLineBuilder;
        this.bottomAlignmentRow = bottomLineBuilder;
        this.arrange = d;
    }
}