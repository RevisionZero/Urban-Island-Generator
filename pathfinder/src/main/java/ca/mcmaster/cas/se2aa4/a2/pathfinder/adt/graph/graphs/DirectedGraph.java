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
        cost.put(source, 0.0);



        //Map<Double, T> queue = new HashMap<>();
        //queue.put(0.0, source);

        PriorityQueue<Tuple<T, Double>> q = new PriorityQueue<>(Comparator.comparingDouble(Tuple::e2));
        q.add(new Tuple<>(source, 0d));


        while(!q.isEmpty()){
            //double lowestPriority = queue.keySet().stream().min(Double::compareTo).get();
            //T node = queue.remove(lowestPriority);
            Tuple<T, Double> tuple = q.remove();
            T node = tuple.e1;

            Set< Edge<T> > edges = this.adjacencyList.get(node);

            edges.forEach(edge -> {
                if(( cost.get(edge.getNode1()) + edge.getWeight()) < cost.get(edge.getNode2())){
                    path.put(edge.getNode2(), edge.getNode1());
                    cost.put(edge.getNode2(), (edge.getWeight() + cost.get(edge.getNode1())));
                    //queue.put(cost.get(edge.getNode2()), edge.getNode2());
                    q.add(new Tuple<>(edge.getNode2(), cost.get(edge.getNode2())));
                }
            });
        }

        /*List<T> finalPathReversed = new ArrayList<>();


        T node = target;

        finalPathReversed.add(node);

        while (true){
            node = path.get(node);
            finalPathReversed.add(node);

            if(node == source){
                break;
            }
        }

        List<T> finalPath = new ArrayList<>();

        for(int i = finalPathReversed.size()-1; i >= 0; i--){
            finalPath.add(finalPathReversed.get(i));
        }*/

        return path;
    }

    private record Tuple<D, E>(D e1, E e2) {
        public static <F, G> Tuple<F, G> of(F e1, G e2) {
            return new Tuple<>(e1, e2);
        }
    }
}
