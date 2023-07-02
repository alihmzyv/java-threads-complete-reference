package org.example.threads;

public class NewThread implements Runnable {
    private final Thread t;

    public NewThread(String name) {
        this.t = new Thread(this, name);
        System.out.println("Child thread created: " + t);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Child thread: " + i);
            try {
                for (int j = 0; j < 10000000; j++) {
                    System.out.println("Child: " + j);
                }
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Exiting child thread..");
    }

    public Thread getT() {
        return t;
    }
}
