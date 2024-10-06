package generic;

import java.util.List;

public interface QueueingFunction {
    void enqueue(List<SearchTreeNode> queue, SearchTreeNode node);
    boolean isEmpty();  
}
