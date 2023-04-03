package ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph;

import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.Edge;

import java.util.*;

public abstract class AbstractGraph<T> implements Graph<T>, Pathfinder<T> {
    //An abstract graph class to define a graph of any type T, such as a graph of vertices, using an adjacency list.

    public Map<T, Set< Edge<T> > > adjacencyList;


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
        if(!adjacencyList.containsKey(node) && node != null) {
            adjacencyList.put(node, new HashSet<>());
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

    @Override
    public Set< Edge<T> > getAllEdges(T node){
        Set<Edge<T>> edges = new HashSet<>(this.adjacencyList.get(node));

        this.adjacencyList.forEach((nodeKey, edgeList) -> {
            edgeList.forEach(edge -> {
                if(edge.containsNode(node)){
                    edges.add(edge);
                }
            });
        });

        return edges;
    }

    @Override
    public Optional< List<T> > findShortestPath(T source, T target) {
        Map<T, T> pathMap = new HashMap<>();
        Map<T, Double> cost = new HashMap<>();
        this.adjacencyList.keySet().forEach(key -> {
            cost.put(key, Double.POSITIVE_INFINITY);
            pathMap.put(key, null);
        });
        pathMap.put(source, source);
        cost.put(source, 0.0);

        PriorityQueue<Tuple<T, Double>> queue = new PriorityQueue<>(Comparator.comparingDouble(Tuple::getPriority));
        queue.add(new Tuple<>(source, 0d));


        while(!queue.isEmpty()){
            Tuple<T, Double> tuple = queue.remove();
            T node = tuple.node;

            Set< Edge<T> > edges = this.adjacencyList.get(node);

            edges.forEach(edge -> {
                if(( cost.get(edge.getNode1()) + edge.getWeight()) < cost.get(edge.getNode2())){
                    pathMap.put(edge.getNode2(), edge.getNode1());
                    cost.put(edge.getNode2(), (edge.getWeight() + cost.get(edge.getNode1())));
                    queue.add(new Tuple<>(edge.getNode2(), cost.get(edge.getNode2())));
                }
            });
        }

        List<T> pathReversed = new ArrayList<>();


        T node = target;

        pathReversed.add(node);

        do {
            if (node == null) {
                return Optional.empty();
            }
            node = pathMap.get(node);
            pathReversed.add(node);

        } while (node != source);

        List<T> path = new ArrayList<>();

        for(int i = pathReversed.size()-1; i >= 0; i--){
            path.add(pathReversed.get(i));
        }

        return Optional.of(path);
    }

    private static class Tuple<T, E> {
        private final T node;
        private final E priority;

        public Tuple(T node, E priority) {
            this.node = node;
            this.priority = priority;
        }

        public T getNode() {
            return this.node;
        }

        public E getPriority() {
            return this.priority;
        }
    }

}
