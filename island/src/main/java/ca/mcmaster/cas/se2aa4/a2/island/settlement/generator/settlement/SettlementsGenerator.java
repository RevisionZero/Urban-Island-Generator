package ca.mcmaster.cas.se2aa4.a2.island.settlement.generator.settlement;

import ca.mcmaster.cas.se2aa4.a2.island.settlement.Settlement;
import ca.mcmaster.cas.se2aa4.a2.island.tile.Tile;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.vertex.Vertex;

import java.util.List;
import java.util.Set;

public interface SettlementsGenerator {

    void createSettlements(int numLocations);


    Set<Vertex> getSettlementLocations(int numLocations);

    List<Settlement> getSettlements();

    Settlement getCentralSettlement();

}
