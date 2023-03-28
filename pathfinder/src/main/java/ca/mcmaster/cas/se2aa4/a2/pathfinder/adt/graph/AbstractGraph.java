package ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph;

import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.Edge;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph.graphs.UndirectedGraph;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;

public abstract class AbstractGraph<T> implements Graph<T>, Pathfinder<T> {

    protected Set<T> nodes;

    protected HashMap<T, Set< Edge<T> > > edges;

    public AbstractGraph (Set<T> nodes){
        this.nodes = nodes;
    }

    public AbstractGraph (HashMap<T, Set< Edge<T> > > edges){
        this.edges = edges;
        edges.forEach( (node, edge) ->{
            this.nodes.add(node);
        });
    }

    public AbstractGraph() {

    }

    @Override
    public void removeNode(T node) {

        nodes.remove(node);

        edges.remove(node);
    }

    @Override
    public void addNode(T node){
        nodes.add(node);
    }

    @Override
    public HashMap<T, Set< Edge<T> > > getEdges(){
        return this.edges;
    }

}
