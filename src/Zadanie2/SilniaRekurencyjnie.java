package Zadanie2;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Kamil Zemczak
 */
public class SilniaRekurencyjnie extends Silnia {
    public SilniaRekurencyjnie(JTextField outputField, int num){
        super(outputField, num);
    }
    
    private long solve(long inputVal){
        if(inputVal > 0)
            return inputVal * solve(inputVal-1);
        else 
            return 1;
    }
    
    @Override
    public void run(){
        try{
            outputField.setText(solve(num)+"");
            Thread.sleep(1000);
        } catch(InterruptedException e){
            JOptionPane.showMessageDialog(null, "Przerywam obliczenia rekurencyjne.");
        }
    }
}
