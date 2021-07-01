package org.example;

class Printer implements Runnable { // We can also extend class Thread, but this way is recommended
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}

public class App {
    public static void main(String[] args) {

        // Printing happens simultaneously all threads. Outputs are mixed.

        Thread thread1 = new Thread(new Printer()); // Thread-0
        Thread thread2 = new Thread(new Printer()); // Thread-1
        Thread thread3 = new Thread(new Printer()); // Thread-2
        Thread thread4 = new Thread(new Printer()); // Thread-3
        thread1.start(); // logging to console
        thread2.start(); // logging to console
        thread3.start(); // logging to console
        thread4.start(); // logging to console
    }
}
