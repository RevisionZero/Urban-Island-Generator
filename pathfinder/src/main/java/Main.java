import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.Edge;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.edges.UnweightedEdge;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph.Graph;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph.graphs.UndirectedGraph;

import java.util.HashSet;
import java.util.Set;

public class Main {


    public static void main(String[] args) {

        Graph<Integer> g;

        Set<Edge<Integer>> edges = new HashSet<>();
        Set<Integer> nodes = new HashSet<>();

        edges.add(new UnweightedEdge<>(0,1));
        edges.add(new UnweightedEdge<>(0,2));
        edges.add(new UnweightedEdge<>(1,3));
        edges.add(new UnweightedEdge<>(3,7));
        edges.add(new UnweightedEdge<>(4,5));
        edges.add(new UnweightedEdge<>(0,4));

        nodes.add(1);
        nodes.add(0);
        nodes.add(7);
        nodes.add(3);
        nodes.add(4);
        nodes.add(5);
        nodes.add(2);

        g = new UndirectedGraph<Integer>(nodes, edges);

        g.getEdges().forEach((key, value) -> {
            System.out.print(key.toString()+": ");

            value.forEach(edge -> {
                System.out.print("("+edge.getNode1()+", "+edge.getNode2()+")");
            });
            System.out.println();
        });
    }
}
