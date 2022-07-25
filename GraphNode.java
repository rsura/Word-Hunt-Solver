import java.util.Set;
import java.util.HashSet;
import java.lang.InstantiationError;
import java.util.InputMismatchException;


/**
 * This class is a GraphNode to be used as part of a Graph
 * Data Structure. It contains the value of the specified data
 * type, and a set of all the nodes that it is connected to.
 * It is a directional graph, but all edges have the same weight.
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
    public GraphNode(){
        throw new InstantiationError("Graph Node needs a value to be Instantiated!");
    }

    /**
     * Creates a new GraphNode with the passed value. Initializes
     * the Set of graph nodes with an initial capacity
     * 
     * @param value the value of the node based on its data type
     */
    public GraphNode(T value){
        this.val = value;
        this.nodesConnectedTo = new HashSet<>(5);
    }

    /**
     * Returns a new set of all the nodes this GraphNode is 
     * connected to, to ensure that this object's set isn't
     * tampered with.
     * 
     * @return A set of all the nodes this GraphNode is connected to
     */
    public Set<GraphNode<T>> getConnectedNodes(){
		return new HashSet<>(nodesConnectedTo);
	}

    /**
     * Creates a one way connection to the given GraphNode
     * 
     * @param g the GraphNode that will be connected to
     * @return if the connection successfully happened
     */
    public boolean connectToNode(GraphNode<T> g){
		if (this == g || g == null){ // not allowed to connect to itself or a null node
			return false;
		}
		try {
			nodesConnectedTo.add(g);
		} catch (Exception e){
			throw new InputMismatchException("GraphNodes are of different DataTypes!");
		}
		return true;
	}

    /**
     * Creates a two way connection between both given GraphNodes
     * @param g1 GraphNode #1
     * @param g2 GraphNode #2
     * @return True, if both connections were successful or not
     */
    public static boolean connectNodes(GraphNode g1, GraphNode g2){
		if (g1 == null || g2 == null) return false;

		if(!g1.val.getClass().equals(g2.val.getClass())){
			throw new InputMismatchException("Graph nodes are not of the same type!");
		}
		if(g1 == g2){ // Can't connect a node to itself.
			return false;
		}
		return g1.connectToNode(g2) && g2.connectToNode(g1);
	}
}