package ca.mcmaster.cas.se2aa4.a2.island.settlement.generator.network.networkGenerators;

import ca.mcmaster.cas.se2aa4.a2.island.settlement.Settlement;
import ca.mcmaster.cas.se2aa4.a2.island.settlement.generator.network.NetworkGenerator;
import ca.mcmaster.cas.se2aa4.a2.island.settlement.roads.TileGraph;
import ca.mcmaster.cas.se2aa4.a2.island.tile.Tile;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.mesh.Mesh;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.segment.Segment;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.vertex.Vertex;

import java.awt.*;
import java.util.*;
import java.util.List;

public class StarNetworkGenerator implements NetworkGenerator {

    /**
     * Creates a network of {@link Settlement}s all connected to the specified central {@link Settlement}.
     * @param mesh The {@link Mesh} to write the network to.
     * @param settlements The {@link List} of {@link Settlement}s to connect.
     * @param tileGraph The {@link Set} of {@link Tile}s representing the tiles that can be used to draw connections.
     * @param centralCity The central {@link Settlement}.
     */
    @Override
    public void createNetwork(Mesh mesh, List<Settlement> settlements, TileGraph tileGraph, Settlement centralCity) {
        if(centralCity == null){
            return;
        }
        Vertex centralVertex = centralCity.getLocation();
        centralVertex.setColor(new Color(255,0,0));

        Map<Vertex, Vertex> dijkstra = tileGraph.tileGraphDijkstra(centralVertex);

        settlements.forEach(settlement -> {
            Optional<List<Vertex>> roadPath = tileGraph.tileGraphExtractPath(dijkstra, centralVertex, settlement.getLocation());
            roadPath.ifPresent(tileGraph::drawRoad);
        });

    }


}
