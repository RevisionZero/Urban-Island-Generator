package ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.edges;

import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.AbstractEdge;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.Edge;

import java.util.Objects;
import java.util.Optional;

public class UndirectedEdge<T> extends AbstractEdge<T> {

    /**
     * Constructs a new weighted undirected {@link Edge} using 2 nodes of type {@link T} and the weight.
     * @param node1 The first node of type {@link T} of the {@link Edge}.
     * @param node2 The second node of type {@link T} of the {@link Edge}.
     * @param weight The {@link Double} weight of the {@link Edge}.
     */
    public UndirectedEdge(T node1, T node2, double weight) {
        super(node1, node2, weight);
    }

    /**
     * Constructs a new unweighted undirected {@link Edge} using 2 nodes of type {@link T}.
     * @param node1 The first node of type {@link T} of the {@link Edge}.
     * @param node2 The second node of type {@link T} of the {@link Edge}.
     */
    public UndirectedEdge(T node1, T node2) {
        super(node1, node2);
    }

    /**
     *
     * @param o The {@link Object} to compare to.
     * @return {@code true} if the {@link Object} o is an edge with the same pair of nodes, with the order not mattering. Othewrise returns {@code false}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEdge<?> that = (AbstractEdge<?>) o;
        return Objects.equals(node1, that.getNode1()) && Objects.equals(node2, that.getNode2()) || Objects.equals(node1, that.getNode2()) && Objects.equals(node2, that.getNode1()) ;
    }
}
