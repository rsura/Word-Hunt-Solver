import java.util.Set;
import java.util.HashSet;


/**
 * This class is a GraphNode to be used as part of a Graph
 * Data Structure. It contains the value of the specified data
 * type, and a set of all the nodes that it is connected to.
 *
 * @param <T> the type of element maintained in the GraphNode
 * @author Rahul Sura
 */
public class GraphNode<T> {
    // Value in Graph Node
    public T val;

    // Set of all nodes this node is connected to
    private Set<GraphNode<T>> nodesConnectedTo;

    // GraphNode cannot be instantiated without a value
    private GraphNode(){
        // Intentionally Empty
    }

    /**
     * Creates a new GraphNode with the passed value. Initializes
     * the Set of graph nodes with an initial capacity
     */
    public GraphNode(T value){
        this.val = value;
        this.nodesConnectedTo = new HashSet<>(5);
    }
}