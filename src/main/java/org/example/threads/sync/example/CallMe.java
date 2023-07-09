package org.example.threads.sync.example;

public class CallMe {
    /*
    TODO: read https://docs.oracle.com/javase/tutorial/essential/concurrency/index.html
     */
    public synchronized void call(String msg) {
        System.out.print("[" + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("]");
    }
}
