package ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph;

import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.Edge;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph.graphs.UndirectedGraph;

import java.util.*;
import java.util.function.BiConsumer;

public abstract class AbstractGraph<T> implements Graph<T>, Pathfinder<T> {
    //An abstract graph class to define a graph of any type T, such as a graph of vertices, using an adjacency list.

    protected Map<T, Set< Edge<T> > > edges;

    public AbstractGraph (Set<T> nodes){
        this.edges = new HashMap<>();

        nodes.forEach(node -> {
            edges.put(node, new HashSet<>());
        });
    }

    public AbstractGraph(Set<T> nodes, Set< Edge<T> > edges){
        this.edges = new HashMap<>();

        nodes.forEach(node -> {
            this.edges.put(node, new HashSet<>());
        });

        edges.forEach(edge -> {
            T node1 = edge.getNode1();
            T node2 = edge.getNode2();

            if(!this.edges.containsKey(node1)){
                this.edges.put(node1, new HashSet<>());
            }
            else if(!this.edges.containsKey(node2)){
                this.edges.put(node2, new HashSet<>());
            }

            Set< Edge<T> > edgeList = this.edges.get(node1);
            edgeList.add(edge);
            this.edges.put(node1, edgeList);
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
    public Map<T, Set< Edge<T> > > getGraph(){
        return this.edges;
    }

}
