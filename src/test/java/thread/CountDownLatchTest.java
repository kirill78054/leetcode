package thread;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {


    @Test
    public void call() throws InterruptedException {
        int nThreads = 5;
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread(() -> {
                try {
                    System.out.println("Start name = " + Thread.currentThread().getName());
                    startGate.await();
                    System.out.println("Run name = " + Thread.currentThread().getName());
                    try {
                        for (int j = 0; j < 5; j++) {
                            Thread.sleep(1000);
                        }
                    } finally {
                        endGate.countDown();
                    }
                } catch (InterruptedException ignored) {
                }
            });
            t.start();
        }
        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        System.out.println(end - start);


    }

}
