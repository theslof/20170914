package com.theslof;

public class Consumer implements Runnable {
    private GenQueue<Integer> queue;

    public Consumer(GenQueue<Integer> newQueue) {
        queue = newQueue;
    }

    @Override
    public void run() {
        while (true) {
            Integer i = queue.deQueue();
            if (i == null) {
                try {
                    System.out.println("No more numbers in queue, sleeping...");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Dequeued " + i);
            }
        }
    }
}
