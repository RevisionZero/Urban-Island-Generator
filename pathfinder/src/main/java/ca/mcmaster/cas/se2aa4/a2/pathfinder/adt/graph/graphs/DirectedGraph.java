package ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph.graphs;

import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.Edge;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.edges.DirectedEdge;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.edges.UndirectedEdge;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph.AbstractGraph;

import java.sql.Array;
import java.util.*;

public class DirectedGraph<T> extends AbstractGraph<T> {

    public DirectedGraph (Set< Edge<T> > edges){
        super(edges);
    }

    /**
     *
     * If the {@link Set} of {@link Edge} contains nodes not in the {@link Set} of {@link T}, they will be added.
     * @param nodes The {@link Set} of {@link T} nodes to use to create the graph.
     * @param edges The {@link Set} of {@link Edge} to add to the graph.
     * @throws IllegalArgumentException if the set of edges contains an undirected edge.
     */
    public DirectedGraph(Set<T> nodes, Set< Edge<T>> edges) throws IllegalArgumentException{
        super(nodes,edges);

        if(edges.contains(UndirectedEdge.class)){
            throw new IllegalArgumentException("The set of edges contains an undirected edge!");
        }
    }

    @Override
    public Optional<List<T>> findPath(T source, T target) {
        return Optional.empty();
    }

    @Override
    public Map<T, T> findShortestPath(T source, T target) {
        Map<T, T> path = new HashMap<>();
        Map<T, Double> cost = new HashMap<>();
        this.adjacencyList.keySet().forEach(key -> {
            cost.put(key, Double.MAX_VALUE);
            path.put(key, null);
        });
        path.put(source, source);
        cost.put(source, (Double) 0.0);



        Map<Double, T> queue = new HashMap<>();
        queue.put((Double) 0.0, source);

        while(!queue.isEmpty()){
            double lowestPriority = queue.keySet().stream().min(Double::compareTo).get();
            T node = queue.remove(lowestPriority);

            Set< Edge<T> > edges = this.adjacencyList.get(node);

            edges.forEach(edge -> {
                if(( cost.get(edge.getNode1()) + edge.getWeight()) < cost.get(edge.getNode2())){
                    path.put(edge.getNode2(), edge.getNode1());
                    cost.put(edge.getNode2(), (edge.getWeight() + cost.get(edge.getNode1())));
                    queue.put(cost.get(edge.getNode2()), edge.getNode2());
                }
            });
        }

        return path;
    }
}
