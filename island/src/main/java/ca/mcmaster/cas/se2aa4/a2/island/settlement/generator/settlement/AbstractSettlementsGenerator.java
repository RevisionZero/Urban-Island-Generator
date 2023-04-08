package ca.mcmaster.cas.se2aa4.a2.island.settlement.generator.settlement;

import ca.mcmaster.cas.se2aa4.a2.island.geography.Land;
import ca.mcmaster.cas.se2aa4.a2.island.settlement.Settlement;
import ca.mcmaster.cas.se2aa4.a2.island.tile.Tile;
import ca.mcmaster.cas.se2aa4.a2.island.tile.type.TileGroup;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.mesh.Mesh;

import java.util.*;

public abstract class AbstractSettlementsGenerator implements SettlementsGenerator{

    protected Random rand;
    protected Mesh mesh;
    protected Set<Tile> landTiles;
    protected List<Settlement> settlements;
    protected Settlement centralCity;

    public AbstractSettlementsGenerator(Mesh mesh, long seed, Land land){
        this.mesh = mesh;
        this.rand = new Random(seed);
        this.landTiles = new HashSet<>();
        land.getTiles().stream().filter(tile -> tile.getType().getGroup().equals(TileGroup.LAND)).forEach(tile -> {
            landTiles.add(tile);
        });
        this.settlements = new ArrayList<>();
    }

    /**
     *
     * @return The {@link Set} of {@link Tile}s that are land tiles in this island.
     */
    @Override
    public Set<Tile> getLandTiles(){
        return this.landTiles;
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
        return this.centralCity;
    }

}
