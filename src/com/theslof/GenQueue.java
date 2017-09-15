package com.theslof;

import java.util.Arrays;

public class GenQueue<T> {
    private Object[] array;
    private int length = 10;
    private int size;
    private int start;
    private int end;

    public GenQueue() {
        array = new Object[length];
        size = 0;
        start = 0;
        end = 0;
    }

    public synchronized void enQueue(T o) {
        array[end++] = o;
        notify();
        size++;
        if (size == length)
            resize();
        if (end == length)
            end = 0;
    }

    public synchronized T deQueue() {
        if (start == end){
            try{
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        T o = (T) array[start++];
        size--;
        start = start % length;
        return o;
    }

    private void resize() {
        length *= 2;
        array = Arrays.copyOf(array, length);
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String s = "[";
        for (int i = start; i != end; i++) {
            if (i != start)
                s += ",";
            if (i >= length)
                i = 0;
            s += array[i];

        }
        return s + "]";
    }
}
