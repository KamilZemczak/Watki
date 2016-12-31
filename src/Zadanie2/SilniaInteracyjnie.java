package Zadanie2;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Kamil Zemczak
 */
public class SilniaInteracyjnie extends Silnia {
    public SilniaInteracyjnie(JTextField outputField, int num){
        super(outputField, num);
    }
    
    private long solve(int inputVal){
        long result = 1;

        for(int i = 1; i <= inputVal; i++){
            result *= i;
        }
        return result;
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
