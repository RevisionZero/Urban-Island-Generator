package ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph.graphs;

import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.Edge;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph.AbstractGraph;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph.Graph;

import java.util.*;

public class UndirectedGraph<T> extends AbstractGraph<T> {
    public UndirectedGraph(Set<T> nodes) {
        super(nodes);
    }

    public UndirectedGraph(Set<T> nodes, Set< Edge<T> > edges){
        super(nodes, edges);
    }

    @Override
    public Optional<List<T>> findPath(T node1, T node2) {
        return Optional.empty();
    }

    @Override
    public Optional<List<T>> findShortestPath(T node1, T node2) {
        return Optional.empty();
    }

    @Override
    public void addEdge(Edge<T> edge) {
        this.edges.get(edge.getNode1()).add(edge);
    }

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
