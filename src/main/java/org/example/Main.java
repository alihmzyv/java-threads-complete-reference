package org.example;

import org.example.threads.NewThread;

public class Main {
    public static void main(String[] args) {
//        Thread mainThread = Thread.currentThread();
//        System.out.println("Before name change: " + mainThread);
//
//        mainThread.setName("My thread");
//        System.out.println("After name change: " + mainThread);

        new NewThread("Child Thread").getT().start();

        for (int i = 0; i < 5; i++) {
            try {
                for (int j = 0; j < 10000000; j++) {
                    System.out.println("Main: " + j);
                }
                System.out.println("Main thread: " + i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("main thread interrupted");
            }
        }
        System.out.println("Exiting main thread");
    }
}