package Zadanie2;

import javax.swing.JTextField;

/**
 *
 * @author KamilZemczak
 */
public class Silnia extends Thread {
    int num;
    JTextField outputField;
    
    public Silnia(JTextField outputField, int num) {
        this.num = num;
        this.outputField = outputField;
    }
}
