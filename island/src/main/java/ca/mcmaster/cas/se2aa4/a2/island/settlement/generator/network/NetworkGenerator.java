package ca.mcmaster.cas.se2aa4.a2.island.settlement.generator.network;

import ca.mcmaster.cas.se2aa4.a2.island.settlement.Settlement;
import ca.mcmaster.cas.se2aa4.a2.island.settlement.roads.TileGraph;
import ca.mcmaster.cas.se2aa4.a2.island.tile.Tile;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.mesh.Mesh;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.segment.Segment;

import java.util.List;
import java.util.Set;

public interface NetworkGenerator {

    void createNetwork(Mesh mesh, List<Settlement> settlements, TileGraph tileGraph, Settlement centralSettlement);

}
