package org.example.threads.sync.example;

public class Caller implements Runnable {
    CallMe target;
    String msg;
    Thread t;

    public Caller(CallMe target, String msg) {
        this.target = target;
        this.msg = msg;
        this.t = new Thread(this);
    }

    @Override
    public void run() {
        target.call(msg);
    }
}
