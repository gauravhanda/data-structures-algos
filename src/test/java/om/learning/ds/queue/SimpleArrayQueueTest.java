package om.learning.ds.queue;

import com.learning.ds.queue.SimpleArrayQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SimpleArrayQueueTest {
    private SimpleArrayQueue simpleArrayQueue;

    @BeforeEach
    public void setup() {
        simpleArrayQueue = new SimpleArrayQueue(5);
    }

    @Test
    public void insertionShouldWork() {
        simpleArrayQueue.enqueue(10);
        simpleArrayQueue.enqueue(1);
        Assertions.assertEquals(2, simpleArrayQueue.size());
    }

    @Test
    public void insertionAndDequeShouldWork() {
        simpleArrayQueue.enqueue(1);
        simpleArrayQueue.enqueue(2);
        simpleArrayQueue.dequeue();
        Assertions.assertEquals(1, simpleArrayQueue.size());
    }

    @Test
    public void popOnEmptyQueueShouldThrowError() {
        Assertions.assertThrows(IllegalStateException.class, () -> simpleArrayQueue.dequeue());
    }

    @Test
    public void pushOnFullQueueShouldThrowError() {
        Assertions.assertThrows(IllegalStateException.class,
                () -> IntStream.range(1, 10).forEach(x -> simpleArrayQueue.enqueue(x)));
    }

    @Test
    public void pushAndPopSequenceShouldMatch() {
        int array[] = {1,2,3,4,5};
        Arrays.stream(array).forEach(simpleArrayQueue::enqueue);

    }
}
