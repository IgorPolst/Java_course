
import java.util.concurrent.*;

class Philosopher implements Runnable {

    private final int id;
    private final Semaphore leftFork;
    private final Semaphore rightFork;

    public Philosopher(int id, Semaphore leftFork, Semaphore rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();
                eat();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void think() throws InterruptedException { // - `throws` используется в объявлении метода, чтобы указать, что этот метод может выбросить одно или несколько проверяемых исключений
        System.out.println("Philosopher " + id + " is thinking.");
        Thread.sleep((long) (Math.random() * 1000));
    }

    private void eat() throws InterruptedException {

        leftFork.acquire(); //acquire() - позволяет потоку получить разрешение от семафора, блокируя поток, если разрешения больше нет.

        rightFork.acquire();

        System.out.println("Philosopher " + id + " is eating.");
        Thread.sleep((long) (Math.random() * 1000));

        rightFork.release(); // - `release()`: возвращает разрешение в семафор, увеличивая счетчик.
        leftFork.release();
        System.out.println("Philosopher " + id + " has finished eating.");
    }
}
