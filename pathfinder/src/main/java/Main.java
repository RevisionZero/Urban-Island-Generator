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


        DirectedGraph<Integer> directedGraph = new DirectedGraph<>(nodes, edges);

        Set<Integer> nodes2 = new HashSet<>();
        nodes2.add(0);
        nodes2.add(1);

        Edge<Integer> e1 = new UndirectedEdge<>(0,1);
        Edge<Integer> e2 = new UndirectedEdge<>(0,5);
        Set<Edge<Integer>> edges2 = new HashSet<>();
        edges2.add(e1);
        edges2.add(e2);

        UndirectedGraph<Integer> undirectedGraph = new UndirectedGraph<>(edges2);

        System.out.println("Directed Graph Test:\n");
        System.out.println("Directed Graph:");
        System.out.println(directedGraph.showGraph());
        directedGraph.removeNode(9);
        System.out.println("Removed node 9:");
        System.out.println(directedGraph.showGraph());
        directedGraph.removeEdge(new DirectedEdge<>(2,7));
        System.out.println("Removed edge (2, 7):");
        System.out.println(directedGraph.showGraph());
        directedGraph.addEdge(new DirectedEdge<>(0,1));
        System.out.println("Added unweighted edge (0, 1):");
        System.out.println(directedGraph.showGraph());
        directedGraph.addEdge(new DirectedEdge<>(0,1,8));
        System.out.println("Added weighted edge (0, 1):");
        System.out.println(directedGraph.showGraph());
        directedGraph.addEdge(new UndirectedEdge<>(90,11, 88));
        System.out.println("Added Undirected Weighted Edge (90, 11):");
        System.out.println(directedGraph.showGraph());
        directedGraph.addNode(11);
        System.out.println("Added node 11:");
        System.out.println(directedGraph.showGraph());
        directedGraph = new DirectedGraph<>(edges);
        System.out.println("RESET:\n");
        System.out.println("Directed Graph:");
        System.out.println(directedGraph.showGraph());
        List<Integer> shortestPath = directedGraph.findShortestPath(8,0).get();
        System.out.println("Shortest path between 8 and 0:");
        shortestPath.forEach(node->{
            System.out.print(node+", ");
        });
        System.out.println();
        Optional<List<Integer>> shortestPath2 = directedGraph.findShortestPath(8,6);
        System.out.println("Shortest path between 8 and 6:");
        if(shortestPath2.isPresent()){
            shortestPath2.get().forEach(node->{
                System.out.print(node+", ");
            });
        }
        else{
            System.out.println("Doesn't exist");
        }
        System.out.println("\n\n\n\n");

        System.out.println("Undirected Graph Test:\n");
        System.out.println("Undirected Graph:");
        System.out.println(undirectedGraph.showGraph());
        undirectedGraph.removeNode(5);
        System.out.println("Removed Node 5:");
        System.out.println(undirectedGraph.showGraph());
        undirectedGraph.removeEdge(new UndirectedEdge<>(1,0,9));
        System.out.println("Removed Edge (0, 1):");
        System.out.println(undirectedGraph.showGraph());
        System.out.println("RESET:\n");
        undirectedGraph = new UndirectedGraph<>(nodes2,edges2);
        System.out.println("Undirected Graph:");
        System.out.println(undirectedGraph.showGraph());
        undirectedGraph.addEdge(new UndirectedEdge<>(6,9,9));
        System.out.println("Added Weighted Edge (6, 9):");
        System.out.println(undirectedGraph.showGraph());
        undirectedGraph.addEdge(new UndirectedEdge<>(6,9));
        System.out.println("Added Unweighted Edge (6, 9):");
        System.out.println(undirectedGraph.showGraph());
        undirectedGraph.addEdge(new DirectedEdge<>(72,9));
        System.out.println("Added Directed Edge (72, 9):");
        System.out.println(undirectedGraph.showGraph());
        undirectedGraph.addNode(99);
        System.out.println("Added Node 99:");
        System.out.println(undirectedGraph.showGraph());
        undirectedGraph = new UndirectedGraph<>(edges2);
        System.out.println("RESET:\n");
        System.out.println("Undirected Graph:");
        System.out.println(undirectedGraph.showGraph());
        Optional<List<Integer>> shortestPath3 = undirectedGraph.findShortestPath(0,1);
        System.out.println("Shortest path between 0 and 1:");
        if(shortestPath3.isPresent()){
            shortestPath3.get().forEach(node->{
                System.out.print(node+", ");
            });
        }
        else{
            System.out.println("Doesn't exist");
        }
        System.out.println();
        shortestPath3 = undirectedGraph.findShortestPath(5,1);
        System.out.println("Shortest path between 0 and 5:");
        if(shortestPath3.isPresent()){
            shortestPath3.get().forEach(node->{
                System.out.print(node+", ");
            });
        }
        else{
            System.out.println("Doesn't exist");
        }

//        System.out.println("Undirected Graph Test:\n");
//        System.out.println("Undirected Graph:");
//        System.out.println(undirectedGraph.showGraph());
//        undirectedGraph.removeEdge(new UndirectedEdge<>(0,1));
//        System.out.println("Removed Edge (0, 1): ");
//        System.out.println(undirectedGraph.showGraph());
    }
}
