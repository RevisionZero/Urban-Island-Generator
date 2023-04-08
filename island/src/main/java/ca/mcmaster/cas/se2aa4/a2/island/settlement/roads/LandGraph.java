package ca.mcmaster.cas.se2aa4.a2.island.settlement.roads;

import ca.mcmaster.cas.se2aa4.a2.island.geography.Land;
import ca.mcmaster.cas.se2aa4.a2.island.geography.River;
import ca.mcmaster.cas.se2aa4.a2.island.path.Path;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.mesh.Mesh;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.segment.Segment;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.vertex.Vertex;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.Edge;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.edges.UndirectedEdge;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph.Graph;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.graph.graphs.UndirectedGraph;

import java.awt.*;
import java.util.*;
import java.util.List;

public class LandGraph {

    private Mesh mesh;

    private Land land;

    private Set<Vertex> vertices;

    private Set<Segment> segments;

    private Set<Edge<Vertex>> edges;

    private UndirectedGraph<Vertex> graph;

    public LandGraph(Mesh mesh, Land land){
        this.mesh = mesh;
        this.land = land;
        this.vertices = new HashSet<>();
        this.segments = new HashSet<>();
        this.edges = new HashSet<>();
        List<River> rivers = land.getRivers();

        land.getPaths().forEach(path -> {
            rivers.forEach(river -> {
                if(!river.getRiverPath().contains(path)){
                    Segment segment = path.getSegment();
                    segments.add(segment);
                    vertices.add(segment.getV1());
                    vertices.add(segment.getV2());
                    edges.add(new UndirectedEdge<>(segment.getV1(), segment.getV2(), path.getElevation()));
                }
            });
        });

        graph = new UndirectedGraph<>(edges);
    }

    public Optional<List<Segment>> findShortestPath(Vertex v1, Vertex v2){
        List<Segment> path = new ArrayList<>();
        Optional<List<Vertex>> shortestPath = graph.findShortestPath(v1, v2);

        if(shortestPath.isPresent()){
            List<Vertex> pathVertices = shortestPath.get();

            for(int i = 0; i < pathVertices.size()-1; i++){
                int finalI = i;
                segments.forEach(segment -> {
                    if(segment.equals(new Segment(pathVertices.get(finalI), pathVertices.get(finalI +1)))){
                        path.add(segment);
                    }
                });
            }
        }

        return Optional.of(path);
    }

}
