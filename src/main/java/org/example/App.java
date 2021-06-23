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

        // Printing happens simultaneously from Thread-0 and main threads. Outputs are mixed.

        Thread thread = new Thread(new Printer());
        thread.start(); // logging to console

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i); // logging to console
        }
    }
}
