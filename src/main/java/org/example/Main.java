package org.example;

import java.util.concurrent.Semaphore;



public class Main {

    public static void main(String[] args) {

        Semaphore sem = new Semaphore(2);
        for(int i=1;i<10;i++)
            new Philosopher(sem,i).start();
    }
}


