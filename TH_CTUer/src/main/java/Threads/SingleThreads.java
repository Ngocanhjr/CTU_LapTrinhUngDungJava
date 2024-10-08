/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Threads;

/**
 *
 * @author GIGABYTE
 */
public class SingleThreads extends Thread{
    String name;

    @Override
    public void run() {
        int count = 0;
        
        System.out.println("Run--------------------------");
        while (count < 3) {
            System.out.println("Active count " + Thread.activeCount());
            name = Thread.currentThread().getName();
            count++;
            System.out.println(name);
            if(name.equals("Threads1"))
                System.out.println("aaa");
            else
                System.out.println("bbbb");
        }
    }
}
