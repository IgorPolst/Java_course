import java.util.concurrent.*;

public class DiningPhilosophers {

    public static void main(String[] args) {
        final int PHILOSOPHERS_COUNT = 5;
        Semaphore[] forks = new Semaphore[PHILOSOPHERS_COUNT];

        // Создаем вилки
        for (int i = 0; i < PHILOSOPHERS_COUNT; i++) {
            forks[i] = new Semaphore(1); // каждая вилка изначально доступна
        }

        Thread[] philosophers = new Thread[PHILOSOPHERS_COUNT];

        // Создаем философов
        for (int i = 0; i < PHILOSOPHERS_COUNT; i++) {
            Semaphore leftFork = forks[i];
            Semaphore rightFork = forks[(i + 1) % PHILOSOPHERS_COUNT]; // следующая вилка
            philosophers[i] = new Thread(new Philosopher(i, leftFork, rightFork));
            philosophers[i].start();
        }

        // Даем философам поработать некоторое время и завершаем программу
        try {
            Thread.sleep(1000000); // Даем им поесть и подумать 10 секунд
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Останавливаем философов
        for (Thread philosopher : philosophers) {
            philosopher.interrupt();
        }
    }
}
