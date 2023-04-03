package ca.mcmaster.cas.se2aa4.a2.pathfinder;

import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.Edge;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.edges.UndirectedEdge;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph.graphs.UndirectedGraph;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShortestPathTest {

    @Test
    public void undirectedTest(){

        Set<Edge<Integer>> edges = new HashSet<>();

        edges.add(new UndirectedEdge<>(4,9));
        edges.add(new UndirectedEdge<>(1,3));
        edges.add(new UndirectedEdge<>(1,9));

        UndirectedGraph<Integer> graph = new UndirectedGraph<>(edges);

        List<Integer> path1 = graph.findShortestPath(4,3).get();
    }
}
