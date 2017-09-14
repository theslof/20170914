package com.theslof;

public class Multithreading {

    public static void main(String[] args) {
        GenQueue<Integer> queue = new GenQueue<>();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        Thread pt = new Thread(producer);
        Thread ct = new Thread(consumer);

        pt.start();
        ct.start();
    }
}
