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
        if (end >= array.length - 1) {
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
        int index = end;
        while (--index > 0) {
            array[index - 1] = array[index];
        }
        array[end - 1] = 0;
        end = end - 1;
    }

    public int size() {
        return end;
    }

    public int[] getQueueContents() {
        return Arrays.copyOf(array, array.length);
    }
}
