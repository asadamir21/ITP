
package test;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import java.util.Random;

public class MainController implements Initializable {

    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
    public void generateRandom(ActionEvent event){
        Random rn = new Random();
        int Rand = rn.nextInt(50) + 1;
        System.out.println(Integer.toString(Rand));
    }
}
