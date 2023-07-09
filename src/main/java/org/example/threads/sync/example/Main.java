package org.example.threads.sync.example;

public class Main {
    public static void main(String[] args) {
        CallMe callMe = new CallMe();
        Caller caller1 = new Caller(callMe, "message 1");
        Caller caller2 = new Caller(callMe, "message 2");
        caller1.t.start();
        caller2.t.start();

        try {
            caller1.t.join();
            caller2.t.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
