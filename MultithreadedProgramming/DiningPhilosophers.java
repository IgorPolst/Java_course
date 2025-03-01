import java.util.concurrent.*;

public class DiningPhilosophers {

    public static void main(String[] args) {
        final int PHILOSOPHERS_COUNT = 5;
        Semaphore[] forks = new Semaphore[PHILOSOPHERS_COUNT];

        
        for (int i = 0; i < PHILOSOPHERS_COUNT; i++) {
            forks[i] = new Semaphore(1); 
        }

        Thread[] philosophers = new Thread[PHILOSOPHERS_COUNT];

        
        for (int i = 0; i < PHILOSOPHERS_COUNT; i++) {
            Semaphore leftFork = forks[i];
            Semaphore rightFork = forks[(i + 1) % PHILOSOPHERS_COUNT]; 
            philosophers[i] = new Thread(new Philosopher(i, leftFork, rightFork));
            philosophers[i].start();
        }

        
        try {
            Thread.sleep(1000000); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        
        for (Thread philosopher : philosophers) {
            philosopher.interrupt();
        }
    }
}
