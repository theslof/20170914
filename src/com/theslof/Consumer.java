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
            System.out.println("Dequeued " + i);
        }
    }
}
