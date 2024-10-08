    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Threads;

/**
 *
 * @author GIGABYTE
 */
public class Main {

    public static void main(String[] args) {
         /*
        extends
         */
        SingleThreads demo = new SingleThreads();
        demo.setName("Threads1");

        System.out.println("Main------------------------");
        System.out.println("Threads: " + Thread.currentThread().isAlive());
        System.out.println("demo: " + demo.isAlive());
        System.out.println(demo.isDaemon());

        demo.start();
        //chạy xong xong 
        System.out.println("Main------------------------");
        System.out.println("Threads: " + Thread.currentThread().isAlive());
        System.out.println("demo: " + demo.isAlive());
        System.out.println("Daenon: " + demo.isDaemon());

        /*
        interface
         */
    }
}
