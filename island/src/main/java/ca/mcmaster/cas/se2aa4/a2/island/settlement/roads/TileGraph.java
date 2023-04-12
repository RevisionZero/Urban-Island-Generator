package ca.mcmaster.cas.se2aa4.a2.island.settlement.roads;

import ca.mcmaster.cas.se2aa4.a2.island.geography.Land;
import ca.mcmaster.cas.se2aa4.a2.island.tile.Tile;
import ca.mcmaster.cas.se2aa4.a2.island.tile.type.TileGroup;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.mesh.Mesh;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.segment.Segment;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.vertex.Vertex;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.Edge;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.edges.UndirectedEdge;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph.graphs.UndirectedGraph;

import java.awt.*;
import java.util.*;
import java.util.List;

public class TileGraph {

    private Mesh mesh;

    private final Set<Vertex> verticesNodes;

    private final Set<Edge<Vertex>> segmentEdges;

    private final UndirectedGraph<Vertex> graph;

    private final Set<Tile> landTiles;

    public Set<Tile> getLandTiles(){
        return this.landTiles;
    }

    /**
     * Constructs a new undirected, unweighted graph connecting all the centroids of the given {@link Set} of {@link Tile}.
     * Each newly constructed {@link Segment} and its {@link Vertex} are added as invisible {@link Segment} and {@link Vertex} to the {@link Mesh}.
     * @param mesh The {@link Mesh} of the {@link Set} of {@link Tile}.
     * @param land The {@link Set} of {@link Tile} to use to construct the undirected graph.
     */
    public TileGraph(Mesh mesh, Land land){
        this.mesh = mesh;
        this.verticesNodes = new HashSet<>();
        this.segmentEdges = new HashSet<>();
        this.landTiles = new HashSet<>();

        land.getTiles().stream().filter(tile -> tile.getType().getGroup().equals(TileGroup.LAND)).forEach(tile -> {
            verticesNodes.add(tile.getPolygon().getCentroid());
            landTiles.add(tile);
            tile.getNeighbors().stream().filter(neighbor -> neighbor.getType().getGroup().equals(TileGroup.LAND)).forEach(neighbor -> {
                segmentEdges.add(new UndirectedEdge<>(tile.getPolygon().getCentroid(), neighbor.getPolygon().getCentroid()));
            });
        });
        this.mesh.getVertices().forEach(vertex -> {
            vertex.setColor(new Color(0,0,0,0));
        });

        graph = new UndirectedGraph<>(verticesNodes, segmentEdges);
    }

    /**
     * Runs Dijkstra's algorithm on the given source node of type {@link Vertex}.
     * @param source The source {@link Vertex} to run Dijskstra's algorithm on.
     * @return A {@link Map} of {@link Vertex} to {@link Vertex}.
     * @throws IllegalArgumentException When the source {@link Vertex} doesn't exist in the graph.
     */
    public Map<Vertex, Vertex> tileGraphDijkstra(Vertex source) throws IllegalArgumentException{
        return this.graph.dijkstra(source);
    }

    /**
     *
     * @param pathMap The {@link Map} of {@link Vertex} to {@link Vertex} returned by a call to Dijkstra's algorithm.
     * @param source The source {@link Vertex}.
     * @param target The target {@link Vertex}.
     * @return An {@link Optional} containing the {@link List} of {@link Vertex} that describe the path.
     * @throws IllegalArgumentException If the source or target {@link Vertex} doesn't exist.
     */
    public Optional<List<Vertex>> tileGraphExtractPath(Map<Vertex, Vertex> pathMap, Vertex source, Vertex target) throws IllegalArgumentException{
        return this.graph.extractPath(pathMap, source, target);
    }

    /**
     * Connects each {@link Vertex} to its successor to create a {@link Segment} then draws it to create a path.
     * @param shortestPath The {@link List} of {@link Vertex} to connect and draw.
     */
    public void drawRoad(List<Vertex> shortestPath){

        for(int i = 0; i < shortestPath.size()-1; i++){
            Segment segment = new Segment(shortestPath.get(i), shortestPath.get(i + 1));
            segment.setColor(new Color(0,0,0));
            this.mesh.addSegment(segment);

        }
    }

}
