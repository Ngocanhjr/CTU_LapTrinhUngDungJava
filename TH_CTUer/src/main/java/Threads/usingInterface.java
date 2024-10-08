/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Threads;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class usingInterface implements Runnable {

    @Override
    public void run() {
           while (true) {            
            processSomething();
        }
    }

    private void processSomething() {
        try {
            System.out.println("Processing working thread");
            Thread.sleep(1000);
            System.out.println("Processing working thread again!!!");
        } catch (InterruptedException ex) {
            Logger.getLogger(usingInterface.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
