package ca.mcmaster.cas.se2aa4.a2.island.settlement.generator.settlement;

import ca.mcmaster.cas.se2aa4.a2.island.settlement.Settlement;
import ca.mcmaster.cas.se2aa4.a2.island.tile.Tile;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.mesh.Mesh;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.vertex.Vertex;

import java.util.*;

public abstract class AbstractSettlementsGenerator implements SettlementsGenerator{

    protected Random rand;
    protected Mesh mesh;
    protected List<Vertex> landTileCentroids;
    protected List<Settlement> settlements;
    protected Settlement centralSettlement;

    public AbstractSettlementsGenerator(Mesh mesh, long seed, Set<Tile> tiles){
        this.mesh = mesh;
        this.rand = new Random(seed);
        this.landTileCentroids = new ArrayList<>();
        tiles.forEach(tile -> {
            landTileCentroids.add(tile.getPolygon().getCentroid());
        });
        this.settlements = new ArrayList<>();
    }

    /**
     *
     * @return The {@link List} of {@link Settlement}s.
     */
    @Override
    public List<Settlement> getSettlements() {
        return this.settlements;
    }

    /**
     *
     * @return The central {@link Settlement}.
     */
    @Override
    public Settlement getCentralSettlement() {
        return this.centralSettlement;
    }

}
