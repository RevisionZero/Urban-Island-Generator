package ca.mcmaster.cas.se2aa4.a2.island.settlement.generator.network.networkGenerators;

import ca.mcmaster.cas.se2aa4.a2.island.settlement.Settlement;
import ca.mcmaster.cas.se2aa4.a2.island.settlement.generator.network.NetworkGenerator;
import ca.mcmaster.cas.se2aa4.a2.island.settlement.roads.TileGraph;
import ca.mcmaster.cas.se2aa4.a2.island.tile.Tile;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.mesh.Mesh;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.segment.Segment;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.vertex.Vertex;

import java.awt.*;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class StarNetworkGenerator implements NetworkGenerator {

    /**
     * Creates a network of {@link Settlement}s all connected to the specified central {@link Settlement}.
     * @param mesh The {@link Mesh} to write the network to.
     * @param settlements The {@link List} of {@link Settlement}s to connect.
     * @param tiles The {@link Set} of {@link Tile}s representing the tiles that can be used to draw connections.
     * @param centralCity The central {@link Settlement}.
     */
    @Override
    public void createNetwork(Mesh mesh, List<Settlement> settlements, Set<Tile> tiles, Settlement centralCity) {

        Vertex centralVertex = centralCity.getLocation();
        centralVertex.setColor(new Color(255,0,0));

        TileGraph landGraph = new TileGraph(mesh, tiles);

        settlements.stream().filter(settlement -> !settlement.equals(centralCity)).forEach(settlement -> {
            Optional<List<Segment>> shortestPath = landGraph.findShortestPath(centralVertex, settlement.getLocation());
            shortestPath.ifPresent(this::drawRoad);
        });
    }

    @Override
    public void drawRoad(List<Segment> segments){
        segments.forEach(segment -> {
            segment.setColor(new Color(0,0,0));
        });
    }


}
