package org.example;

class Printer {
    // synchronized forbids other threads to access this method while it is used by one thread
    synchronized void printDocuments(int numOfCopies, String docName) {
        for (int i = 0; i < numOfCopies; i++) {
            System.out.println("Printing " + docName + " #" + i + " " + Thread.currentThread().getName());
        }
    }
}

class MyThread extends Thread {

    Printer printer;

    MyThread(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        printer.printDocuments(100, "Крижане серце");
    }
}

public class App {

    public static void main(String[] args) {

        System.out.println("=== Application started ===");

        Printer printer = new Printer();

        // logging is separate, because printDocuments() is synchronized method
        MyThread myThread1 = new MyThread(printer);
        MyThread myThread2 = new MyThread(printer);
        myThread1.start(); // logging from Thread-0
        myThread2.start(); // logging from Thread-1

        System.out.println("=== Application finished ===");
    }
}
