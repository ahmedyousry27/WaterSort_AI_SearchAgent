package code;

import java.util.List;

public interface QueueingFunction {
    void enqueue(List<Node> queue, Node node);
    Node dequeue();
    boolean isEmpty();  
}
