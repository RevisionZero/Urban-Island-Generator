package ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph.graphs;

import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.Edge;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph.AbstractGraph;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph.Graph;

import java.util.*;

public class UndirectedGraph<T> extends AbstractGraph<T> {
    /**
     *
     * @param nodes Construct a new graph using the given {@link Set} of {@link T}.
     */
    public UndirectedGraph(Set<T> nodes) {
        super(nodes);
    }

    /**
     *
     * If the {@link Set} of {@link Edge} contains nodes not in the {@link Set} of {@link T}, they will be added.
     * @param nodes The {@link Set} of {@link T} nodes to use to create the graph.
     * @param edges The {@link Set} of {@link Edge} to add to the graph.
     */
    public UndirectedGraph(Set<T> nodes, Set< Edge<T> > edges){
        super(nodes, edges);
    }

    //Implementation of finding a path between 2 nodes, if any, for an undirected graph
    @Override
    public Optional<List<T>> findPath(T source, T target) {
        return Optional.empty();
    }

    //Implementation of finding the shortest path between 2 nodes, if any, for an undirected graph
    @Override
    public Optional<List<T>> findShortestPath(T source, T target) {
        return Optional.empty();
    }

    //Adding an edge for an undirected graph
    @Override
    public void addEdge(Edge<T> edge) {
        this.edges.get(edge.getNode1()).add(edge);
    }

    //Removing an edge for an undirected graph
    @Override
    public void removeEdge(Edge<T> edge) {
        for (Map.Entry<T, Set<Edge<T>>> entry : edges.entrySet()) {
            if(entry.getValue().contains(edge)){
                entry.getValue().remove(edge);
                break;
            }
        }
    }

}
