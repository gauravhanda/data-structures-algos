package com.learning.ds.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class SimpleArrayQueue {
    private final Logger logger = LoggerFactory.getLogger(SimpleArrayQueue.class);
    private int end = 0;
    private int array[];

    public SimpleArrayQueue(int queueSize) {
        array = new int[queueSize];
    }

    public void enqueue(int value) {
        if (end >= array.length) {
            logger.error("Queue is full");
            throw new IllegalStateException("Queue is Full");
        } else {
            array[end++] = value;
        }
    }

    public int dequeue() throws IllegalStateException {
        if (end == 0) {
            logger.error("Queue is Empty");
            throw new IllegalStateException("Queue is Empty");
        }
        int retVal = array[0];
        shift();
        return retVal;
    }

    protected void shift() {
        int index = 0;
        while (index < end-1) {
            array[index] = array[index + 1];
            index++;
        }
        array[--end] = 0;
    }

    public int size() {
        return end;
    }

    public int[] getQueueContents() {
        return Arrays.copyOf(array, array.length);
    }
}
