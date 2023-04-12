package ca.mcmaster.cas.se2aa4.a2.island.settlement.generator;

import java.util.Random;

import ca.mcmaster.cas.se2aa4.a2.island.geography.Land;
import ca.mcmaster.cas.se2aa4.a2.island.settlement.generator.network.NetworkGenerator;
import ca.mcmaster.cas.se2aa4.a2.island.settlement.generator.network.networkGenerators.StarNetworkGenerator;
import ca.mcmaster.cas.se2aa4.a2.island.settlement.generator.settlement.SettlementsGenerator;
import ca.mcmaster.cas.se2aa4.a2.island.settlement.generator.settlement.settlementsGenerators.RandomSettlementsGenerator;
import ca.mcmaster.cas.se2aa4.a2.island.settlement.roads.TileGraph;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.mesh.Mesh;
import ca.mcmaster.cas.se2aa4.a2.island.settlement.Settlement;

public class CountryGenerator {

    /**
     * Creates a set of settlements on an island specified by the land parameter and connects them.
     * @param mesh The {@link Mesh} to write the country to.
     * @param seed The seed to determine the {@link Random} generation.
     * @param land The {@link Land} of the island to generate the country on.
     * @param numLocations The number of {@link Settlement} to create on the island.
     */
    public static void generateCountry(Mesh mesh, long seed, Land land, int numLocations){

        TileGraph landTilesGraph = new TileGraph(mesh, land);

        SettlementsGenerator settlementsGenerator = new RandomSettlementsGenerator(mesh, seed, landTilesGraph.getLandTiles());

        settlementsGenerator.createSettlements(numLocations);

        NetworkGenerator networkGenerator = new StarNetworkGenerator();

        networkGenerator.createNetwork(mesh, settlementsGenerator.getSettlements(), landTilesGraph, settlementsGenerator.getCentralSettlement());


    }
}
