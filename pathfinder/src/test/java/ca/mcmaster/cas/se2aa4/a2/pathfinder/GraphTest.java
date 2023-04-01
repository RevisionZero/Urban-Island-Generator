package ca.mcmaster.cas.se2aa4.a2.pathfinder;

import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.Edge;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.edges.UndirectedEdge;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph.Graph;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph.graphs.DirectedGraph;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph.graphs.UndirectedGraph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

@Testable
public class GraphTest {

    private Graph<Integer> undirected;
    private Graph<Integer> directed;

    private Set< Edge<Integer> > undirectedEdges;
    private Set< Edge<Integer> > directedEdges;

    private Set<Integer> nodes;
    //Can we use stuff were going to use in beforeeach
    //Do we need to account for user putting in null values or just let it throw eexception
    //Relateed to the first point, I also use getEdge and node in the test


    @BeforeEach
    public void beforetest(){
        nodes = new HashSet<>();
        nodes.add(0);
        nodes.add(1);
        nodes.add(2);
        nodes.add(3);
        nodes.add(4);
        nodes.add(null);

        undirectedEdges = new HashSet<>();

        undirectedEdges.add(new UndirectedEdge<>(0,1));
        undirectedEdges.add(new UndirectedEdge<>(1,2));
        undirectedEdges.add(new UndirectedEdge<>(2,3));
        undirectedEdges.add(new UndirectedEdge<>(3,4));
        undirectedEdges.add(new UndirectedEdge<>(4,1));

        directedEdges.add(new UndirectedEdge<>(0,1));
        directedEdges.add(new UndirectedEdge<>(1,2));
        directedEdges.add(new UndirectedEdge<>(2,3));
        directedEdges.add(new UndirectedEdge<>(3,4));
        directedEdges.add(new UndirectedEdge<>(4,1));

        undirected = new UndirectedGraph<>(nodes, undirectedEdges);
        directed = new DirectedGraph<>(nodes, directedEdges);
    }

    @Test
    public void removeNodeTest(){
        Set<Integer> nodes = new HashSet<>();
        nodes.add(1);
        nodes.add(2);
        nodes.add(3);
        nodes.add(4);

        Set<Edge<Integer>> edges = new HashSet<>();
        edges.add(new UndirectedEdge<>(1,2));
        edges.add(new UndirectedEdge<>(2,3));
        edges.add(new UndirectedEdge<>(3,4));
        edges.add(new UndirectedEdge<>(4,1));

        undirected.removeNode(0);
        directed.removeNode(0);

        assertEquals(undirected.getNodes(),nodes);
        assertEquals(undirected.getEdges(),edges);

        assertEquals(directed.getNodes(),nodes);
        assertEquals(directed.getEdges(),edges);

        undirected.removeNode(5);
        directed.removeNode(5);

        assertEquals(undirected.getNodes(),nodes);
        assertEquals(undirected.getEdges(),edges);

        assertEquals(directed.getNodes(),nodes);
        assertEquals(directed.getEdges(),edges);

    }
}
