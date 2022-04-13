package com.learning.ds.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CircularQueue {
    private final Logger logger = LoggerFactory.getLogger(CircularQueue.class);
    private int end = -1, front = -1, size = 10;
    private int array[];

    public CircularQueue() {
        this.array = new int[3];
    }

    public CircularQueue(int size) {
        this.size = size;
        this.array = new int[size];
    }

    /**
     * If the queue is not null do the following:
     * 1. If the front is pointing to -1 then increment it so that we have index to read. Updating front in add method
     * helps in keeping the empty check simple. front > -1
     * 2. One the front is updated for entry condition, we deal with end
     * 2.1) if end is less than size-1 then just increment. This will cover the use case where the front is ahead of
     * end pointer as we have done that check already in the isQueueFull method.
     * 2.2) If end reaches the size -1 then reset it to 0 so that we can have circular effect.
     *
     * @param x
     * @return
     */
    public boolean add(int x) {
        if (!isQueueFull()) {
            if (front == -1) {
                front = 0;
            }
            end = end < size - 1 ? end + 1 : 0;
            array[end] = x;

            return true;
        } else {
            logger.error("Add failed as queue is full");
        }
        return false;
    }

    /**
     * Popping algorithm
     * 1. Read the value from array for current index
     * 2. Now see if the front == end; that means we read last item, set the index to -1 as queue is empty
     * 3. If the front approaches last index, set it to 0 to complete the circle
     * 4. For all other cases we can increment front safely for next read
     *
     * @return
     */
    public int pop() {
        int retValue = Integer.MIN_VALUE;
        if (!isQueueEmpty()) {
            retValue = array[front];
            array[front] = Integer.MIN_VALUE;

            if (front == end) {
                front = end = -1;
            } else if (front == size - 1) {
                front = 0;
            } else {
                front = front + 1;
            }
        } else {
            logger.error("Queue is empty, cant pop anymore");
        }

        return retValue;
    }

    /**
     * If front and end point to same index, that means there is nothing to pop and nothing to add
     * this means the queue is empty
     *
     * @return
     */
    public boolean isQueueEmpty() {
        return front < 0;
    }

    /**
     * Queue will be full if the front point to zero and end has reached the max
     * Queue will also be full if the front is not at zero and end has circled back to it.
     *
     * @return
     */
    public boolean isQueueFull() {
        return (front == 0 && end == size - 1) || (front != 0 && front - end == 1);
    }

    public void printQueue() {
        logger.error("Queue is {}", array);
    }

}
