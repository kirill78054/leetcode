package thread;

import lombok.SneakyThrows;
import org.junit.Test;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Interrupt {

    @Test
    public void call() throws InterruptedException {
        System.out.println("Start");
        T tr = new T();

        tr.start();
        SECONDS.sleep(3);
        tr.interrupt();
        System.out.println("isInterrupted = " + tr.isInterrupted());
        System.out.println("Finish");
    }

    static class T extends Thread {

        @SneakyThrows
        @Override
        public void run() {
            System.out.println("Thread start name = " + Thread.currentThread().getName());

            while (true) {
                if (!Thread.interrupted()) {
                    System.out.println("Thread name = " + Thread.currentThread().getName());
                    SECONDS.sleep(1);
                } else {
                    System.out.println("Thread name break= " + Thread.currentThread().getName());
                    break;
                }
            }
        }
    }
}
