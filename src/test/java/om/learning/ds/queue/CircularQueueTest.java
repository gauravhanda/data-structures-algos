package om.learning.ds.queue;

import com.learning.ds.queue.CircularQueue;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class CircularQueueTest {

    @Test
    public void initialQueueShouldBeEmpty() {
        CircularQueue queue = new CircularQueue();
        queue.printQueue();
        Assert.isTrue(queue.isQueueEmpty(), "Queue should be empty");
    }

    @Test
    public void queueShouldBeFull() {
        CircularQueue queue = new CircularQueue(2);
        queue.add(1);
        queue.add(2);
        queue.printQueue();
        Assert.isTrue(queue.isQueueFull(), "Queue should be full");
    }

    @Test
    public void queueShouldBeEmptyAfterPops() {
        CircularQueue queue = new CircularQueue(2);
        queue.add(1);
        queue.add(2);
        queue.pop();
        queue.pop();
        queue.printQueue();
        Assert.isTrue(queue.isQueueEmpty(), "Queue should be Empty");
    }

    @Test
    public void testCircularInsertion() {
        CircularQueue queue = new CircularQueue(2);
        queue.add(1);
        queue.add(2);
        queue.printQueue();
        queue.pop();
        queue.add(3);
        queue.printQueue();

        queue.pop();
        queue.pop();
        queue.printQueue();
        queue.pop();
        queue.add(1);
        queue.add(2);
        queue.printQueue();
        queue.add(3);
        queue.printQueue();
        Assert.isTrue(queue.isQueueEmpty(), "Queue should be Empty");
    }
}
