package ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph;

import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.Edge;

import java.util.*;

public abstract class AbstractGraph<T> implements Graph<T>, Pathfinder<T> {
    //An abstract graph class to define a graph of any type T, such as a graph of vertices, using an adjacency list.

    protected Map<T, Set< Edge<T> > > adjacencyList;

    /**
     *
     * @param nodes The {@link T} to construct the graph from using an adjacency list.
     */
    public AbstractGraph (Set<T> nodes){
        this.adjacencyList = new HashMap<>();

        nodes.forEach(node -> {
            adjacencyList.put(node, new HashSet<>());
        });
    }

    public AbstractGraph(Set<T> nodes, Set< Edge<T> > edges){
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

    @Override
    public void removeNode(T node) {
        adjacencyList.remove(node);

        adjacencyList.forEach((nodeKey, edgeList) -> {
            if(!edgeList.isEmpty()) {
                edgeList.forEach(edge -> {
                    if (edge != null && edge.containsNode(node)) {
                        edgeList.remove(edge);
                    }
                });
            }
        });
    }

    @Override
    public void addNode(T node){
        if(!adjacencyList.containsKey(node)) {
            adjacencyList.put(node, new HashSet<>());
        }
    }

    @Override
    public void addEdge(Edge<T> edge) {
        if(this.adjacencyList.containsKey(edge.getNode1())){
            this.adjacencyList.get(edge.getNode1()).add(edge);
        }
        else{
            this.adjacencyList.put(edge.getNode1(), new HashSet<>());
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

    @Override
    public Set< Edge<T> > getEdges(){
        Set< Edge<T> > edgeSet = new HashSet<>();

        adjacencyList.forEach((node, edgeList) -> {
            edgeSet.addAll(edgeList);
        });

        return edgeSet;
    }

    @Override
    public Set<T> getNodes(){
        return adjacencyList.keySet();
    }

}
