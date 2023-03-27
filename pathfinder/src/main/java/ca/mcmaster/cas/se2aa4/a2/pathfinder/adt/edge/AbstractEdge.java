package ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge;

public abstract class AbstractEdge<T> implements Edge<T> {


    private final T node1;
    private final T node2;

    public AbstractEdge(T node1, T node2){
        this.node1 = node1;
        this.node2 = node2;
    }

    public Edge<T> getEdge(){
        return this;
    }


    @Override
    public boolean containsNode(T node) {
        return node.equals(node1) || node.equals(node2);
    }
}
