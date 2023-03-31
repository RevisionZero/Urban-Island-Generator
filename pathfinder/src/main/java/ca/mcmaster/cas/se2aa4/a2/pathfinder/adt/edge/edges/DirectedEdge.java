package ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.edges;

import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.AbstractEdge;

import java.util.Optional;

public class DirectedEdge<T> extends AbstractEdge<T> {

    public DirectedEdge(T node1, T node2, double weight) {
        super(node1, node2, weight);
    }

    public DirectedEdge(T node1, T node2) {
        super(node1, node2);
    }
}
