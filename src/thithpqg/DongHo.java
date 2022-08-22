/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package thithpqg;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.swing.JLabel;

public class DongHo extends JLabel implements Runnable{
    SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyy hh:mm:ss");
    @Override
    public void run() {
        while(true){
       this.setText(sd.format(new Date()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(DongHo.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    }
}
