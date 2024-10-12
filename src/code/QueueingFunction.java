package code;

import java.util.List;
import java.util.Queue;

public interface QueueingFunction {
    void enqueue(Node node);
    Node dequeue();
    boolean isEmpty();  
    void displayQueue();
    
}
