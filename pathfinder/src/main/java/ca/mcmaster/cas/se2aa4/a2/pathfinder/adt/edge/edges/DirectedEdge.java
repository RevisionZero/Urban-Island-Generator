package ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.edges;

import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.AbstractEdge;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.Edge;

import java.util.Optional;

public class DirectedEdge<T> extends AbstractEdge<T> {

    /**
     * Constructs a new weighted directed {@link Edge} using 2 nodes of type {@link T} and the weight.
     * @param node1 The first node of type {@link T} of the {@link Edge}.
     * @param node2 The second node of type {@link T} of the {@link Edge}.
     * @param weight The {@link Double} weight of the {@link Edge}.
     */
    public DirectedEdge(T node1, T node2, double weight) {
        super(node1, node2, weight);
    }

    /**
     * Constructs a new unweighted directed {@link Edge} using 2 nodes of type {@link T}.
     * @param node1 The first node of type {@link T} of the {@link Edge}.
     * @param node2 The second node of type {@link T} of the {@link Edge}.
     */
    public DirectedEdge(T node1, T node2) {
        super(node1, node2);
    }
}
