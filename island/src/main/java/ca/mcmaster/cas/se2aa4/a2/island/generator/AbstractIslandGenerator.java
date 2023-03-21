package ca.mcmaster.cas.se2aa4.a2.island.generator;

import ca.mcmaster.cas.se2aa4.a2.island.elevation.altimetry.AltimeterProfile;
import ca.mcmaster.cas.se2aa4.a2.island.geography.Land;
import ca.mcmaster.cas.se2aa4.a2.island.geography.Ocean;
import ca.mcmaster.cas.se2aa4.a2.island.geometry.Shape;
import ca.mcmaster.cas.se2aa4.a2.island.neighborhood.NeighborhoodRelation;
import ca.mcmaster.cas.se2aa4.a2.island.neighborhood.TileNeighborhood;
import ca.mcmaster.cas.se2aa4.a2.island.tile.Tile;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.mesh.Mesh;

import java.util.List;

public abstract class AbstractIslandGenerator implements IslandGenerator {

    private final Land land;
    private final Ocean ocean;
    private final int numLakes;
    private final Shape shape;
    private final AltimeterProfile altimeterProfile;
    protected final Mesh mesh;

    protected AbstractIslandGenerator(Mesh mesh, Shape shape, AltimeterProfile altimeterProfile, int numLakes) {
        this.land = new Land();
        this.ocean = new Ocean();
        this.mesh = mesh;
        this.shape = shape;
        this.altimeterProfile = altimeterProfile;
        this.numLakes = numLakes;
    }

    @Override
    public final void generate() {
        List<Tile> tiles = this.mesh.getPolygons().stream().map(Tile::new).toList();

        // Calculate the tiles neighborhood relationship
        NeighborhoodRelation neighborhood = new TileNeighborhood();
        neighborhood.calculateNeighbors(tiles);

        this.generateIsland(tiles, this.ocean, this.land, this.shape);
        this.generateElevation(this.land);
        this.generateLakes(this.land, this.numLakes);

    }

    /**
     * Generates the land tiles and ocean tiles
     * @param tiles The {@link List} of tiles given by the mesh
     */
    protected abstract void generateIsland(List<Tile> tiles, Ocean ocean, Land land, Shape shape);

    /**
     * Generates lakes in the island
     * @param land All the land {@link Tile} since lakes can only be in land
     */
    protected abstract void generateLakes(Land land, int numLakes);

    /**
     * Sets the elevation of land tiles. Ocean tiles are left at 0.
     */
    private void generateElevation(Land land) {
        land.getTiles().forEach(t -> {
            double elevation = this.altimeterProfile.generateElevation(this.shape, t);
            t.setElevation(elevation);
        });
    }
}
