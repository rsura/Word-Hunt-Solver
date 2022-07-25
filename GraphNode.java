import java.util.Set;
import java.util.HashSet;
import java.util.Objects;
import java.util.InputMismatchException;
import java.lang.InstantiationError;

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

    /**
     * Default Constructor - throws an {@code InstantiationError} since
     * no value provided in the constructor.
     */
    public GraphNode(){
        throw new InstantiationError("Graph Node needs a value to be Instantiated!");
    }

    /**
     * Constructor - creates a new GraphNode with the passed value. 
     * Initializes the Set of graph nodes with an initial capacity.
     * 
     * @param   value The value of the node based on its data type.
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
     * @return  A set of all the nodes this GraphNode is connected to.
     */
    public Set<GraphNode<T>> getConnectedNodes(){
		return new HashSet<>(this.nodesConnectedTo);
	}

    /**
     * Creates a one way connection to the given GraphNode.
     * 
     * @param   g The GraphNode that will be connected to.
     * @return  If the connection successfully happened.
     */
    public boolean connectToNode(GraphNode<T> g){
		if (this == g || g == null){ // not allowed to connect to itself or a null node
			return false;
		}
		try {
			this.nodesConnectedTo.add(g);
		} catch (Exception e){
			throw new InputMismatchException("GraphNodes are of different DataTypes!");
		}
		return true;
	}

    /**
     * Creates a two way connection between both given GraphNodes.
     * @param   g1 GraphNode #1.
     * @param   g2 GraphNode #2.
     * @return  True, if both connections were successful or not.
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

    /**
     * Removes a one way connection from this GraphNode to the
     * given GraphNode.
     * @param   g The GraphNode to remove a connection from.
     * @return  True, if removal was successful.
     */
    public boolean removeNode(GraphNode<T> g){
		return this.nodesConnectedTo.remove(g);
	}

    /**
     * Removes all the connected GraphNodes where the node's
     * value is equal to the passed in value parameter.
     * @param   val The value of the node(s) to be deleted.
     * @return  True, if at least one.
     */
    public boolean removeNodes(T val){
		boolean removed = false;
		for (GraphNode<T> node: nodesConnectedTo) {
			if (node.val.equals(val)){
				if(this.removeNode(node)){
                    removed = true;
                }
			}
		}
		return removed;
	}

    /**
     * Removes a two way connection between both given GraphNodes.
     * @param   g1 GraphNode #1.
     * @param   g2 GraphNode #2.
     * @return  True, if both connections were successfully removed or not. 
     *          False, if either node isn't connected to the other.
     */
    public static boolean removeNodeConnections(GraphNode g1, GraphNode g2){
		if (!g1.val.getClass().equals(g2.val.getClass())){
			throw new InputMismatchException("Graph nodes are of different data types");
		}
		return (g1.removeNode(g2) && g2.removeNode(g1));
	}

    /**
     * Overriden toString method, showing the GraphNode's address and value.
     */
    @Override
    public String toString() {
		return "GraphNode" + super.toString().substring(super.toString().indexOf('@')) + " - value: (" + this.val.toString() + ")";
    }

    /**
     * Overridden equals method, showing that the two GraphNodes are equal
     * if the value of the GraphNode is the same, as well as all the nodes
     * it is connected to.
     */
    @Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		GraphNode<?> graphNode = (GraphNode<?>) o;
		return Objects.equals(this.val, graphNode.val) && Objects.equals(this.nodesConnectedTo, graphNode.nodesConnectedTo);
	}
}