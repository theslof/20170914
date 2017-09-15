package com.theslof;

import java.util.Random;

public class Producer implements Runnable {
    private GenQueue<Integer> queue;

    public Producer(GenQueue<Integer> newQueue) {
        queue = newQueue;
    }

    @Override
    public void run() {
        Random rand = new Random();
        while (true) {
            Integer i = rand.nextInt(500);
            System.out.println("Enqueueing " + i);
            queue.enQueue(i);
            try {
                Thread.sleep(rand.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
