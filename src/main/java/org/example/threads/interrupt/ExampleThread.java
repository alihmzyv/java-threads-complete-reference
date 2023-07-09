package org.example.threads.interrupt;

public class ExampleThread implements Runnable {
    Thread t;

    public ExampleThread() {
        this.t = new Thread(this);
    }

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            for (long j = 0; j < 1000000001L; j++) {
                if (i == 2) {
                    if (Thread.interrupted()) {
                        System.out.println("Interrupted, leaving...");
                        return;
                    }
                }
            }
//            try {
//                Thread.sleep(4000);
//            } catch (InterruptedException e) {
//                System.out.println("Interrupted");
//                return;
//            }
            System.out.printf("i: %s%n", i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExampleThread exampleThread = new ExampleThread();
        exampleThread.t.start();
//        Thread.sleep(1000);
        exampleThread.t.interrupt();
    }
}
