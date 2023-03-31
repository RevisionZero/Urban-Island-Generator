package ca.mcmaster.cas.se2aa4.a2.pathfinder;

import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.Edge;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.edges.DirectedEdge;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.edges.UndirectedEdge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.*;

@Testable
public class EdgesTest {

    private Edge<Integer> undirectedUnweighted;

    private Edge<Integer> undirectedWeighted;

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void beforeTest(){

        undirectedUnweighted = new UndirectedEdge<>(0,1);
        undirectedWeighted = new DirectedEdge<>(0,2, 9);
    }

    @Test
    public void containsTest(){
        Integer node1 = 0;
        Integer node2 = 1;
        Integer node3 = 2;

        boolean a = undirectedUnweighted.containsNode(node1);
        boolean b = undirectedUnweighted.containsNode(node2);

        boolean c = undirectedUnweighted.containsNode(node3);
        boolean d = undirectedUnweighted.containsNode((int) 8.9);

        boolean e = undirectedUnweighted.containsNode(null);

        assertTrue(a);
        assertTrue(b);

        assertFalse(c);
        assertFalse(d);

        assertFalse(e);
    }

    @Test
    public void weightTest(){
        boolean a = undirectedWeighted.getWeight() == 9;

        boolean b = undirectedUnweighted.isWeighted();

        assertTrue(a);

        assertFalse(b);

        assertThrows(Exception.class, () -> {
            undirectedUnweighted.getWeight();
            assertEquals("This edge is not weighted!", outContent.toString());
        });
    }
}
