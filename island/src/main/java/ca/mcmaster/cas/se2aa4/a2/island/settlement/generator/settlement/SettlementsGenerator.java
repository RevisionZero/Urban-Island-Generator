package ca.mcmaster.cas.se2aa4.a2.island.settlement.generator.settlement;

import ca.mcmaster.cas.se2aa4.a2.island.settlement.Settlement;
import ca.mcmaster.cas.se2aa4.a2.island.tile.Tile;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.vertex.Vertex;

import java.util.List;
import java.util.Set;

public interface SettlementsGenerator {

    /**
     *
     * @param numLocations The number of {@link Settlement}s to create.
     */
    void createSettlements(int numLocations);

    /**
     *
     * @param numLocations The number of {@link Settlement}s to get the locations to.
     * @return A {@link Set} of {@link Vertex} describing the locations of the {@link Settlement}s.
     */
    Set<Vertex> getSettlementLocations(int numLocations);

    /**
     *
     * @return The {@link List} of {@link Settlement}s created.
     */
    List<Settlement> getSettlements();

    Settlement getCentralSettlement();

}
