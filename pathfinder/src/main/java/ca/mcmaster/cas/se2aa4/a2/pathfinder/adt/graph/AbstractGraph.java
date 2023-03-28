package ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph;

import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.Edge;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph.graphs.UndirectedGraph;

import java.util.*;
import java.util.function.BiConsumer;

public abstract class AbstractGraph<T> implements Graph<T>, Pathfinder<T> {

    //A map of the graph's edges as follows: node(key) -> edges with that node(value), this is an adjacency
    //list representation of the graph
    protected Map<T, Set< Edge<T> > > edges;

    //Graph constructor using nodes
    public AbstractGraph (Set<T> nodes){
        this.edges = new HashMap<>();

        nodes.forEach(node -> {
            edges.put(node, new HashSet<>());
        });
    }

    //Graph constructor using set of nodes and a set of edges
    public AbstractGraph(Set<T> nodes, Set< Edge<T> > edges){
        this.edges = new HashMap<>();

        nodes.forEach(node -> {
            this.edges.put(node, new HashSet<>());
        });

        //Adding each edge to the appropriate index, so that one of the edge's nodes is the key
        edges.forEach(edge -> {
            T key = edge.getNode1();;
            Set< Edge<T> > edgeList = this.edges.get(key);
            edgeList.add(edge);
            this.edges.put(key, edgeList);
        });
    }


    @Override
    public void removeNode(T node) {
        edges.remove(node);
    }

    @Override
    public void addNode(T node){
        if(!edges.containsKey(node)) {
            edges.put(node, new HashSet<>());
        }
    }

    @Override
    public Map<T, Set< Edge<T> > > getEdges(){
        return this.edges;
    }

}
