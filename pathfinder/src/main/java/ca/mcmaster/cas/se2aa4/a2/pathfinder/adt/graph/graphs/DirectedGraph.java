package ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph.graphs;

import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.Edge;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.edges.UndirectedEdge;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph.AbstractGraph;

import java.util.*;

public class DirectedGraph<T> extends AbstractGraph<T> {

    public DirectedGraph (Set< Edge<T> > edges) throws IllegalArgumentException{
        if(edges.contains(UndirectedEdge.class)){
            throw new IllegalArgumentException("Undirected edges are not allowed in directed graphs!");
        }
        this.adjacencyList = new HashMap<>();

        if(!edges.isEmpty()) {
            edges.forEach(edge -> {
                if(edge != null) {
                    T node1 = edge.getNode1();
                    T node2 = edge.getNode2();

                    if (!this.adjacencyList.containsKey(node1)) {
                        this.adjacencyList.put(node1, new HashSet<>());
                    } else if (!this.adjacencyList.containsKey(node2)) {
                        this.adjacencyList.put(node2, new HashSet<>());
                    }

                    Set<Edge<T>> edgeList = this.adjacencyList.get(node1);
                    edgeList.add(edge);
                    this.adjacencyList.put(node1, edgeList);
                }
            });
        }
    }

    /**
     *
     * If the {@link Set} of {@link Edge} contains nodes not in the {@link Set} of {@link T}, they will be added.
     * @param nodes The {@link Set} of {@link T} nodes to use to create the graph.
     * @param edges The {@link Set} of {@link Edge} to add to the graph.
     * @throws IllegalArgumentException if the set of edges contains an undirected edge.
     */
    public DirectedGraph(Set<T> nodes, Set< Edge<T> > edges) throws IllegalArgumentException{
        if(edges.contains(UndirectedEdge.class)){
            throw new IllegalArgumentException("Undirected edges are not allowed in directed graphs!");
        }
        this.adjacencyList = new HashMap<>();

        if(!nodes.isEmpty()) {
            nodes.forEach(node -> {
                if(node != null) {
                    this.adjacencyList.put(node, new HashSet<>());
                }
            });
        }

        if(!edges.isEmpty()) {
            edges.forEach(edge -> {
                if(edge != null) {
                    T node1 = edge.getNode1();
                    T node2 = edge.getNode2();

                    this.adjacencyList.putIfAbsent(node1, new HashSet<>());
                    this.adjacencyList.putIfAbsent(node2, new HashSet<>());

                    Set<Edge<T>> edgeList = this.adjacencyList.get(node1);
                    edgeList.add(edge);
                    this.adjacencyList.put(node1, edgeList);
                }
            });
        }
    }

    @Override
    public void addEdge(Edge<T> edge) {
        if(edge == null){
            return;
        }
        if(this.adjacencyList.containsKey(edge.getNode1())){
            this.adjacencyList.get(edge.getNode1()).add(edge);
        }
        else{
            this.adjacencyList.put(edge.getNode1(), new HashSet<>());
            this.adjacencyList.get(edge.getNode1()).add(edge);
        }
    }

    @Override
    public void removeEdge(Edge<T> edge) {
        for (Map.Entry<T, Set<Edge<T>>> entry : adjacencyList.entrySet()) {
            if(entry.getKey() != null && !entry.getValue().isEmpty() && entry.getValue().contains(edge)){
                entry.getValue().remove(edge);
                break;
            }
        }
    }

}
