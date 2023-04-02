package ca.mcmaster.cas.se2aa4.a2.pathfinder;

import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.Edge;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.edges.DirectedEdge;
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

    private Set< Edge<Integer> > undirectedEdges;
    private Set< Edge<Integer> > undirectedEdgesWithoutNull;

    private Set<Integer> nodes;
    private Set<Integer> nodesWithoutNull;


    private final Integer zero = 0;
    private final Integer one = 1;
    private final Integer two = 2;
    private final Integer three = 3;
    private final Integer four = 4;

    private final Edge<Integer> e = new UndirectedEdge<>(4,1);
    private final Edge<Integer> d = new UndirectedEdge<>(3,4);
    private final Edge<Integer> c = new UndirectedEdge<>(2,3);
    private final Edge<Integer> b = new UndirectedEdge<>(1,2);
    private final Edge<Integer> a = new UndirectedEdge<>(0,1);

    @BeforeEach
    public void beforetest(){
        nodes = new HashSet<>();
        nodesWithoutNull = new HashSet<>();
        nodes.add(zero); nodesWithoutNull.add(zero);
        nodes.add(one); nodesWithoutNull.add(one);
        nodes.add(two); nodesWithoutNull.add(two);
        nodes.add(three); nodesWithoutNull.add(three);
        nodes.add(four); nodesWithoutNull.add(four);
        nodes.add(null);

        undirectedEdges = new HashSet<>();
        undirectedEdgesWithoutNull = new HashSet<>();
        undirectedEdges.add(a); undirectedEdgesWithoutNull.add(a);
        undirectedEdges.add(b); undirectedEdgesWithoutNull.add(b);
        undirectedEdges.add(c); undirectedEdgesWithoutNull.add(c);
        undirectedEdges.add(d); undirectedEdgesWithoutNull.add(d);
        undirectedEdges.add(e); undirectedEdgesWithoutNull.add(e);
        undirectedEdges.add(null);

        undirected = new UndirectedGraph<>(nodes, undirectedEdges);
    }

    @Test
    public void getTest(){
        /*Set<Integer> nodes = new HashSet<>();
        nodes.add(0);
        nodes.add(1);
        nodes.add(2);
        nodes.add(3);
        nodes.add(4);

        Set<Edge<Integer>> edges = new HashSet<>();
        edges.add(new UndirectedEdge<>(0,1));
        edges.add(new UndirectedEdge<>(1,2));
        edges.add(new UndirectedEdge<>(2,3));
        edges.add(new UndirectedEdge<>(3,4));
        edges.add(new UndirectedEdge<>(4,1));*/

        assertEquals(undirected.getNodes(), nodesWithoutNull);
        assertEquals(undirected.getEdges(), undirectedEdgesWithoutNull);
    }

    @Test
    public void removeNodeTest(){
        nodesWithoutNull.remove(zero);

        undirectedEdgesWithoutNull.remove(a);

        undirected.removeNode(zero);

        assertEquals(undirected.getNodes(),nodesWithoutNull);
        assertEquals(undirected.getEdges(),undirectedEdgesWithoutNull);

        undirected.removeNode(5);

        assertEquals(undirected.getNodes(),nodesWithoutNull);
        assertEquals(undirected.getEdges(),undirectedEdgesWithoutNull);

        undirected.removeNode(null);


        assertEquals(undirected.getNodes(),nodesWithoutNull);
        assertEquals(undirected.getEdges(),undirectedEdgesWithoutNull);

    }

    @Test
    public void removeEdgeTest(){
        undirectedEdgesWithoutNull.remove(a);


        undirected.removeEdge(a);

        undirected.removeEdge(new UndirectedEdge<>(1,7));

        undirected.removeEdge(new UndirectedEdge<>(7,2));

        undirected.removeEdge(new UndirectedEdge<>(5,6));


        assertEquals(undirected.getNodes(),nodesWithoutNull);
        assertEquals(undirected.getEdges(),undirectedEdgesWithoutNull);


    }
}
