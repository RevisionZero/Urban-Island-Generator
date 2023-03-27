package ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.edges;

import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.AbstractEdge;

public class WeightedEdge<T> extends AbstractEdge<T> {

    private final int weight;

    public WeightedEdge(T node1, T node2, int weight){
        super(node1,node2);
        this.weight = weight;
    }
}
