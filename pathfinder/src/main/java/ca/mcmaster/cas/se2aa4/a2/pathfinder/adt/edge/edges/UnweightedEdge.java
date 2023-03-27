package ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.edges;

import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.AbstractEdge;

public class UnweightedEdge<T> extends AbstractEdge<T> {

    public UnweightedEdge(T node1, T node2){
        super(node1, node2);
    }
}
