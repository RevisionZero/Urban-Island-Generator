import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.edges.UnweightedEdge;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph.Graph;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph.graphs.UndirectedGraph;

public class Main {


    public static void main(String[] args) {

        Graph<Integer> g = new UndirectedGraph<Integer>();

        g.addNode(0);
        g.addNode(1);
        g.addNode(2);
        g.addNode(3);
        g.addNode(4);

        g.addEdge(new UnweightedEdge<>(0,1));
        g.addEdge(new UnweightedEdge<>(1,2));

        g.getEdges().forEach((key, value) -> {
            System.out.println(key.toString()+": ");
            

        });
    }
}
