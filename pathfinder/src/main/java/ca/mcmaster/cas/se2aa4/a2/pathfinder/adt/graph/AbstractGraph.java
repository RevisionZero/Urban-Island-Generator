package ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph;

import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.Edge;

import java.util.List;

public abstract class AbstractGraph<T> implements Graph<T> {

    private List<T> nodes;

    private List< List< Edge<T> > > edges;

    @Override
    public void removeNode(T node) {

        nodes.remove(node);

        edges.forEach(edgeList -> {
            if(edgeList.get(0).containsNode(node)){
                edges.remove(edgeList);
            }
        });
    }

    @Override
    public Graph<T> getGraph(){
        return this;
    }


}
