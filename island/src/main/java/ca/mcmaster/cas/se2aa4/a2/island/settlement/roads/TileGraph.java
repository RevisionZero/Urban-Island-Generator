package ca.mcmaster.cas.se2aa4.a2.island.settlement.roads;

import ca.mcmaster.cas.se2aa4.a2.island.tile.Tile;
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

    private Set<Vertex> vertices;

    private Set<Segment> segments;

    private Set<Edge<Vertex>> edges;

    private UndirectedGraph<Vertex> graph;

    /**
     * Constructs a new undirected graph connecting all the centroids of the given {@link Set} of {@link Tile}.
     * Each newly constructed {@link Segment} and its {@link Vertex} are added as invisible {@link Segment} and {@link Vertex} to the {@link Mesh}.
     * @param mesh The {@link Mesh} of the {@link Set} of {@link Tile}.
     * @param tiles The {@link Set} of {@link Tile} to use to construct the undirected graph.
     */
    public TileGraph(Mesh mesh, Set<Tile> tiles){
        this.mesh = mesh;
        this.vertices = new HashSet<>();
        this.segments = new HashSet<>();
        this.edges = new HashSet<>();

        tiles.forEach(tile -> {
            vertices.add(tile.getPolygon().getCentroid());
            tile.getNeighbors().forEach(neighbor -> {
                Segment segment = new Segment(tile.getPolygon().getCentroid(), neighbor.getPolygon().getCentroid());
                segment.setColor(new Color(0,0,0,0));
                this.mesh.addSegment(segment);
                segments.add(segment);
                double weight = (tile.getElevation() + neighbor.getElevation()) / 2;
                edges.add(new UndirectedEdge<>(tile.getPolygon().getCentroid(), neighbor.getPolygon().getCentroid()));
            });
        });
        this.mesh.getVertices().forEach(vertex -> {
            vertex.setColor(new Color(0,0,0,0));
        });

        graph = new UndirectedGraph<>(vertices, edges);
    }

    /**
     *
     * @param source The source {@link Vertex} of the shortest path.
     * @param target The {@link Vertex} node of the shortest path.
     * @return An {@link Optional} describing the path between the souce and target as a {@link List} of {@link Segment}.
     */
    public Optional<List<Segment>> findShortestPath(Vertex source, Vertex target){
        List<Segment> path = new ArrayList<>();
        Optional<List<Vertex>> shortestPath = graph.findShortestPath(source, target);

        if(shortestPath.isPresent()){
            List<Vertex> pathVertices = shortestPath.get();

            for(int i = 0; i < pathVertices.size()-1; i++){
                int finalI = i;
                segments.forEach(segment -> {
                    if(segment.equals(new Segment(pathVertices.get(finalI), pathVertices.get(finalI + 1)))){
                        path.add(segment);
                    }
                });
            }
        }

        return Optional.of(path);
    }

}
