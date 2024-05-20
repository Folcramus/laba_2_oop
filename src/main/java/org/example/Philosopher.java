package org.example;

import java.util.concurrent.Semaphore;

// Класс философа
class Philosopher extends Thread {
    private final Semaphore semaphore; // Семафор, ограничивающий число философов
    private int mealCount = 0; // Количество приемов пищи
    private final int id; // Условный номер философа

    // Конструктор с параметрами: семафор и идентификатор философа
    Philosopher(Semaphore semaphore, int id) {
        this.semaphore = semaphore;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            while (mealCount < 1) { // Пока количество приемов пищи не достигнет 1
                // Запрашиваем у семафора разрешение на выполнение
                semaphore.acquire();
                System.out.println("Философ " + id + " садится за стол");
                // Философ ест
                Thread.sleep(500);
                mealCount++;
                //ddd
                System.out.println("Философ " + id + " выходит из-за стола");
                semaphore.release();

                // Философ гуляет
                Thread.sleep(700);
            }
        } catch (InterruptedException e) {
            System.out.println("У философа " + id + " проблемы со здоровьем");
        }
    }
}