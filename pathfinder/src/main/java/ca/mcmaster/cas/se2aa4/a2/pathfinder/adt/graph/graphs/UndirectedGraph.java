package ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph.graphs;

import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.Edge;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.edges.DirectedEdge;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.edges.UndirectedEdge;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph.AbstractGraph;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class UndirectedGraph<T> extends AbstractGraph<T> {

    /**
     *
     * @param edges Construct a new graph using the given {@link Set} of {@link Edge}.
     */
    public UndirectedGraph (Set< Edge<T> > edges) throws IllegalArgumentException{
        if(edges.contains(DirectedEdge.class)){
            throw new IllegalArgumentException("Directed edges are not allowed in undirected graphs!");
        }
        this.adjacencyList = new HashMap<>();

        if(!edges.isEmpty()) {
            edges.forEach(edge -> {
                if(edge != null) {
                    T node1 = edge.getNode1();
                    T node2 = edge.getNode2();

                    this.adjacencyList.putIfAbsent(node1, new HashSet<>());
                    this.adjacencyList.putIfAbsent(node2, new HashSet<>());

                    Set<Edge<T>> node1EdgeList = this.adjacencyList.get(node1);
                    node1EdgeList.add(edge);
                    this.adjacencyList.put(node1, node1EdgeList);

                    Set<Edge<T>> node2EdgeList = this.adjacencyList.get(node2);
                    node2EdgeList.add(new UndirectedEdge<>(node2, node1));
                    this.adjacencyList.put(node2, node2EdgeList);
                }
            });
        }
    }

    /**
     *
     * If the {@link Set} of {@link Edge} contains nodes not in the {@link Set} of {@link T}, they will be added.
     * @param nodes The {@link Set} of {@link T} nodes to use to create the graph.
     * @param edges The {@link Set} of {@link Edge} to add to the graph.
     * @throws IllegalArgumentException if the set of edges contains a directed edge.
     */
    public UndirectedGraph(Set<T> nodes, Set< Edge<T> > edges) throws IllegalArgumentException{
        if(edges.contains(DirectedEdge.class)){
            throw new IllegalArgumentException("Directed edges are not allowed in undirected graphs!");
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
                //UndirectedEdge<T> edge = (UndirectedEdge<T>) edge;
                if(edge != null) {
                    T node1 = edge.getNode1();
                    T node2 = edge.getNode2();

                    this.adjacencyList.putIfAbsent(node1, new HashSet<>());
                    this.adjacencyList.putIfAbsent(node2, new HashSet<>());

                    Set<Edge<T>> node1EdgeList = this.adjacencyList.get(node1);
                    node1EdgeList.add(edge);
                    this.adjacencyList.put(node1, node1EdgeList);

                    Set<Edge<T>> node2EdgeList = this.adjacencyList.get(node2);
                    node2EdgeList.add(new UndirectedEdge<>(node2, node1));
                    this.adjacencyList.put(node2, node2EdgeList);
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
        if(this.adjacencyList.containsKey(edge.getNode2())){
            this.adjacencyList.get(edge.getNode2()).add(new UndirectedEdge<>(edge.getNode2(), edge.getNode1()));
        }
        else{
            this.adjacencyList.put(edge.getNode2(), new HashSet<>());
            this.adjacencyList.get(edge.getNode2()).add(new UndirectedEdge<>(edge.getNode2(), edge.getNode1()));
        }
    }

    @Override
    public void removeEdge(Edge<T> edge) {
        for (Map.Entry<T, Set<Edge<T>>> entry : adjacencyList.entrySet()) {
            if(entry.getKey() != null && !entry.getValue().isEmpty()){
                entry.getValue().forEach(listEdge -> {
                    if(edge.equals(listEdge)){
                        System.out.println(entry.getValue().remove(edge));
                    }
                });
            }
        }
    }


}
