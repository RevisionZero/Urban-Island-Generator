package ca.mcmaster.cas.se2aa4.a2.pathfinder;

import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.Edge;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.edges.DirectedEdge;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.edges.UndirectedEdge;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph.graphs.DirectedGraph;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph.graphs.UndirectedGraph;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShortestPathTest {

    @Test
    public void directedTest(){
        Set<Edge<Integer>> edges = new HashSet<>();

        edges.add(new DirectedEdge<>(3,8, 1));
        edges.add(new DirectedEdge<>(3,0,9));
        edges.add(new DirectedEdge<>(3,2,5));
        edges.add(new DirectedEdge<>(1,5, 2));
        edges.add(new DirectedEdge<>(1,8, 4));
        edges.add(new DirectedEdge<>(8,5, 7));
        edges.add(new DirectedEdge<>(2,7, 7));
        edges.add(new DirectedEdge<>(4,0, 13));
        edges.add(new DirectedEdge<>(5,9, 8));
        edges.add(new DirectedEdge<>(6,5, 3));
        edges.add(new DirectedEdge<>(6,9, 4));
        edges.add(new DirectedEdge<>(7,0, 12));
        edges.add(new DirectedEdge<>(9,0, 11));

        DirectedGraph<Integer> directedGraph = new DirectedGraph<>(edges);

        Optional<List<Integer>> shortestPath = directedGraph.findShortestPath(3,9);

        List<Integer> shortestPathAnswer = new ArrayList<>();
        shortestPathAnswer.add(3);
        shortestPathAnswer.add(8);
        shortestPathAnswer.add(5);
        shortestPathAnswer.add(9);

        assertEquals(shortestPath.get(), shortestPathAnswer);

        shortestPath = directedGraph.findShortestPath(3,4);
        assertEquals(shortestPath, Optional.empty());

        shortestPath = directedGraph.findShortestPath(3,10);
        assertEquals(shortestPath, Optional.empty());

        shortestPath = directedGraph.findShortestPath(11,10);
        assertEquals(shortestPath, Optional.empty());
    }

    @Test
    public void undirectedTest(){
        Set<Edge<Integer>> edges = new HashSet<>();

        edges.add(new UndirectedEdge<>(3,8, 1));
        edges.add(new UndirectedEdge<>(3,0,9));
        edges.add(new UndirectedEdge<>(3,2,5));
        edges.add(new UndirectedEdge<>(1,5, 2));
        edges.add(new UndirectedEdge<>(1,8, 4));
        edges.add(new UndirectedEdge<>(8,5, 7));
        edges.add(new UndirectedEdge<>(2,7, 7));
        edges.add(new UndirectedEdge<>(4,0, 13));
        edges.add(new UndirectedEdge<>(5,9, 8));
        edges.add(new UndirectedEdge<>(6,5, 3));
        edges.add(new UndirectedEdge<>(6,9, 4));
        edges.add(new UndirectedEdge<>(7,0, 12));
        edges.add(new UndirectedEdge<>(9,0, 11));

        UndirectedGraph<Integer> undirectedGraph = new UndirectedGraph<>(edges);

        Optional<List<Integer>> shortestPath = undirectedGraph.findShortestPath(3,5);

        List<Integer> actualShortestPath = new ArrayList<>();

        actualShortestPath.add(3);
        actualShortestPath.add(8);
        actualShortestPath.add(1);
        actualShortestPath.add(5);

        assertEquals(shortestPath.get(), actualShortestPath);

        shortestPath = undirectedGraph.findShortestPath(3,10);
        assertEquals(shortestPath,Optional.empty());

        shortestPath = undirectedGraph.findShortestPath(11,10);
        assertEquals(shortestPath, Optional.empty());
    }
}
