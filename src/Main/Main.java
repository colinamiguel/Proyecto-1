package Main;


/**
 *
 * @author USER
 */

import Interfaces.Interface;
import java.util.concurrent.Semaphore;
import javax.swing.JOptionPane;
public class Main {
    public static void main(String[] args) {
        Plant[] plants = new Plant[0];
       new Interface(plants).setVisible(true);
    };
    
};

