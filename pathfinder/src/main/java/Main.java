import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.Edge;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.edges.DirectedEdge;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.edges.UndirectedEdge;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph.AbstractGraph;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph.Graph;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph.Pathfinder;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph.graphs.DirectedGraph;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph.graphs.UndirectedGraph;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Set<Integer> nodes = new HashSet<>();
        nodes.add(0);
        nodes.add(1);
        nodes.add(2);
        Integer three = 3;
        nodes.add(three);
        nodes.add(4);
        Integer five = 5;
        nodes.add(five);
        nodes.add(6);
        nodes.add(7);
        nodes.add(8);
        nodes.add(9);

        Set< Edge<Integer> > edges = new HashSet<>();

        /*edges.add(new DirectedEdge<>(3,8, 1));
        edges.add(new UndirectedEdge<>(3,0,9));
        edges.add(new UndirectedEdge<>(3,2,5));
        edges.add(new DirectedEdge<>(1,5, 2));
        edges.add(new DirectedEdge<>(1,8, 4));
        edges.add(new DirectedEdge<>(5,1, 2));
        edges.add(new DirectedEdge<>(5,8, 7));
        edges.add(new DirectedEdge<>(8,1, 4));
        edges.add(new DirectedEdge<>(8,5, 7));
        edges.add(new DirectedEdge<>(8,3, 1));
        edges.add(new DirectedEdge<>(0,9, 11));
        edges.add(new DirectedEdge<>(0,3, 9));
        edges.add(new DirectedEdge<>(0,7, 12));
        edges.add(new DirectedEdge<>(0,4, 13));
        edges.add(new DirectedEdge<>(2,3, 5));
        edges.add(new DirectedEdge<>(2,7, 7));
        edges.add(new DirectedEdge<>(4,0, 13));
        edges.add(new DirectedEdge<>(5,9, 8));
        edges.add(new DirectedEdge<>(5,6, 3));
        edges.add(new DirectedEdge<>(6,5, 3));
        edges.add(new DirectedEdge<>(6,9, 4));
        edges.add(new DirectedEdge<>(7,0, 12));
        edges.add(new DirectedEdge<>(7,2, 7));
        edges.add(new DirectedEdge<>(9,6, 4));
        edges.add(new DirectedEdge<>(9,5, 8));
        edges.add(new DirectedEdge<>(9,0, 11));*/


        edges.add(new DirectedEdge<>(3,8, 1));
        edges.add(new UndirectedEdge<>(3,0,9));
        edges.add(new UndirectedEdge<>(3,2,5));
        edges.add(new DirectedEdge<>(1,5, 2));
        edges.add(new DirectedEdge<>(1,8, 4));
        //edges.add(new DirectedEdge<>(5,1, 2));
        //edges.add(new DirectedEdge<>(5,8, 7));
        //edges.add(new DirectedEdge<>(8,1, 4));
        edges.add(new DirectedEdge<>(8,5, 7));
        //edges.add(new DirectedEdge<>(8,3, 1));
        //edges.add(new DirectedEdge<>(0,9, 11));
        // edges.add(new DirectedEdge<>(0,3, 9));
        //edges.add(new DirectedEdge<>(0,7, 12));
        //edges.add(new DirectedEdge<>(0,4, 13));
        //edges.add(new DirectedEdge<>(2,3, 5));
        edges.add(new DirectedEdge<>(2,7, 7));
        edges.add(new DirectedEdge<>(4,0, 13));
        edges.add(new DirectedEdge<>(5,9, 8));
        //edges.add(new DirectedEdge<>(5,6, 3));
        edges.add(new DirectedEdge<>(6,5, 3));
        edges.add(new DirectedEdge<>(6,9, 4));
        edges.add(new DirectedEdge<>(7,0, 12));
        //edges.add(new DirectedEdge<>(7,2, 7));
        //edges.add(new DirectedEdge<>(9,6, 4));
        //edges.add(new DirectedEdge<>(9,5, 8));
        edges.add(new DirectedEdge<>(9,0, 11));


        System.out.println("Pathfinder:");

        Pathfinder<Integer> graph = new DirectedGraph<>(nodes, edges);

        Optional< List<Integer> > answer = graph.findShortestPath(2,7);

        if(answer.isEmpty()){
            System.out.println("null");
        }
        else {
            answer.get().forEach(key -> {
                System.out.print(key + ", ");
            });
        }

        System.out.println("Graph:");

        Set< Edge<Integer> > edges2 = new HashSet<>();

        edges2.add(new UndirectedEdge<>(4,9));
        edges2.add(new UndirectedEdge<>(1,3));
        edges2.add(new UndirectedEdge<>(1,9));

        Set<Integer> nodes2 = new HashSet<>();
        nodes2.add(5);
        nodes2.add(0);

        /*UndirectedGraph<Integer> g = new UndirectedGraph<>(nodes2, edges2);

        g.adjacencyList.forEach((node, edgeList) -> {
            System.out.print(node+": ");
            edgeList.forEach(edge -> {
                System.out.print("("+edge.getNode1()+", "+edge.getNode2()+"); ");
            });
            System.out.println();
        });*/

        /*System.out.print("Path: ");

        Pathfinder<Integer> graph = new DirectedGraph<>(nodes, edges);

        List<Integer> answer = graph.findShortestPath(3,5);

        answer.forEach(node -> {
            System.out.print(node+", ");
        });*/


        Edge<Integer> e1 = new UndirectedEdge<>(0,1);
        Edge<Integer> e2 = new UndirectedEdge<>(0,5);
        Set<Edge<Integer>> set = new HashSet<>();
        set.add(e1);
        set.add(e2);
        UndirectedGraph<Integer> leGraph = new UndirectedGraph<>(set);
        set.add(e1);
        set.add(e2);
        System.out.println("Before removal:");
        set.forEach(edge -> {
            System.out.print("("+edge.getNode1()+", "+edge.getNode2()+"); ");
        });
        leGraph.removeEdge(new UndirectedEdge<>(0,1));
        System.out.println();
        System.out.println("After removal:");
        set.forEach(edge -> {
            System.out.print("("+edge.getNode1()+", "+edge.getNode2()+"); ");
        });

    }
}
