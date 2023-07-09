package org.example.threads;

class NewThread implements Runnable {
    private final Thread t;

    public NewThread(String name, int priority) {
        this.t = new Thread(this, name);
        this.t.setPriority(priority);
        System.out.println("Child thread created: " + t);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                System.out.printf("Child thread - %s on %d%n", t.getName(), i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Exiting child thread: " + t.getName());
    }

    public Thread getT() {
        return t;
    }
}

class DemoJoin {
    public static void main(String[] args) {
        NewThread t1 = new NewThread("thread 1", 1);
        NewThread t2 = new NewThread("thread 2", 5);
        NewThread t3 = new NewThread("thread 3", 6);

        t1.getT().start();
        t2.getT().start();
        t3.getT().start();

        try {
            t1.getT().join();
            System.out.println("Thread 1 finished");
            t2.getT().join();
            System.out.println("Thread 2 finished");
            t3.getT().join();
            System.out.println("Thread 3 finished");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Thread 1 is alive:" + t1.getT().isAlive());
        System.out.println("Thread 2 is alive:" + t2.getT().isAlive());
        System.out.println("Thread 3 is alive:" + t3.getT().isAlive());

        System.out.println("Main thread exiting..");
    }
}
