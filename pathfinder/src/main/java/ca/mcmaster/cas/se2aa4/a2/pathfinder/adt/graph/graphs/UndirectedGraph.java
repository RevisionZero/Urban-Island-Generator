package ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph.graphs;

import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.Edge;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.edges.DirectedEdge;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.edges.UndirectedEdge;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph.AbstractGraph;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph.Graph;

import java.util.*;

public class UndirectedGraph<T> extends AbstractGraph<T> {

    /**
     *
     * @param edges Construct a new graph using the given {@link Set} of {@link Edge}.
     */
    public UndirectedGraph (Set< Edge<T> > edges){
        super(edges);
    }

    /**
     *
     * If the {@link Set} of {@link Edge} contains nodes not in the {@link Set} of {@link T}, they will be added.
     * @param nodes The {@link Set} of {@link T} nodes to use to create the graph.
     * @param edges The {@link Set} of {@link Edge} to add to the graph.
     * @throws IllegalArgumentException if the set of edges contains a directed edge.
     */
    public UndirectedGraph(Set<T> nodes, Set< Edge<T> > edges) throws IllegalArgumentException{
        super(nodes,edges);

        if(edges.contains(DirectedEdge.class)){
            throw new IllegalArgumentException("The set of edges contains a directed edge!");
        }
    }

    //Implementation of finding a path between 2 nodes, if any, for an undirected graph
    @Override
    public Optional<List<T>> findPath(T source, T target) {
        return Optional.empty();
    }

    //Implementation of finding the shortest path between 2 nodes, if any, for an undirected graph
    @Override
    public Map<T, T> findShortestPath(T source, T target) {
        return null;
    }


}
