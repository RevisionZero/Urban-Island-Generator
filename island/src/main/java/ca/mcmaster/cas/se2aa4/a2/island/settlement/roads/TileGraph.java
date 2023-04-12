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
     * Constructs a new undirected graph connecting all the centroids of the given {@link Set} of {@link Tile}.
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
                double weight = (tile.getElevation() + neighbor.getElevation()) / 2;
                segmentEdges.add(new UndirectedEdge<>(tile.getPolygon().getCentroid(), neighbor.getPolygon().getCentroid(), weight));
            });
        });
        this.mesh.getVertices().forEach(vertex -> {
            vertex.setColor(new Color(0,0,0,0));
        });

        graph = new UndirectedGraph<>(verticesNodes, segmentEdges);
    }

    public Map<Vertex, Vertex> tileGraphDijkstra(Vertex source) throws IllegalArgumentException{
        return this.graph.dijkstra(source);
    }

    public Optional<List<Vertex>> tileGraphExtractPath(Map<Vertex, Vertex> pathMap, Vertex source, Vertex target) throws IllegalArgumentException{
        return this.graph.extractPath(pathMap, source, target);
    }

    public void drawRoad(List<Vertex> shortestPath){

        for(int i = 0; i < shortestPath.size()-1; i++){
            Segment segment = new Segment(shortestPath.get(i), shortestPath.get(i + 1));
            segment.setColor(new Color(0,0,0));
            this.mesh.addSegment(segment);

        }
    }

}
