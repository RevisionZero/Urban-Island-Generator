package ca.mcmaster.cas.se2aa4.a2.island.settlement.generator.settlement.settlementsGenerators;

import ca.mcmaster.cas.se2aa4.a2.island.geography.Land;
import ca.mcmaster.cas.se2aa4.a2.island.settlement.Settlement;
import ca.mcmaster.cas.se2aa4.a2.island.settlement.generator.settlement.AbstractSettlementsGenerator;
import ca.mcmaster.cas.se2aa4.a2.island.settlement.settlements.City;
import ca.mcmaster.cas.se2aa4.a2.island.settlement.settlements.Town;
import ca.mcmaster.cas.se2aa4.a2.island.settlement.settlements.Village;
import ca.mcmaster.cas.se2aa4.a2.island.tile.Tile;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.mesh.Mesh;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.vertex.Vertex;

import java.awt.*;
import java.util.*;

public class RandomSettlementsGenerator extends AbstractSettlementsGenerator {

    /**
     * Creates a generator that can generate a random set of settlements on the island.
     * @param mesh The {@link Mesh} to generate the {@link Settlement}'s on.
     * @param seed The seed that controls the {@link Random} locations of the {@link Settlement}s.
     * @param tiles The {@link Land} of the island.
     */
    public RandomSettlementsGenerator(Mesh mesh, long seed, Set<Tile> tiles) {
        super(mesh, seed, tiles);
    }

    /**
     * Creates a random set of {@link Settlement}s.
     * @param numLocations The number of {@link Settlement}s to generate.
     */
    @Override
    public void createSettlements(int numLocations) {
        if(numLocations == 0){
            return;
        }
        Set<Vertex> settlementLocations = getSettlementLocations(numLocations);

        settlementLocations.forEach(location -> {
            int chosenSettlementType = rand.nextInt(3);
            float settlementSize;

            if(chosenSettlementType == 0){
                settlementSize = rand.nextFloat(9,11);
                location.setColor(new Color(130, 130, 130));
                location.setThickness(settlementSize);
                City city = new City(location, settlementSize);
                settlements.add(city);
            }
            else if (chosenSettlementType == 1) {
                settlementSize = rand.nextFloat(7,9);
                location.setColor(new Color(0, 200, 0));
                location.setThickness(settlementSize);
                Town town = new Town(location, settlementSize);
                settlements.add(town);
            }
            else{
                settlementSize = rand.nextFloat(5,7);
                location.setColor(new Color(150,75,0));
                location.setThickness(settlementSize);
                Village village = new Village(location, settlementSize);
                settlements.add(village);
            }
        });

        this.centralSettlement = settlements.stream().max(Comparator.comparing(Settlement::getSize)).get();
        this.centralSettlement.getLocation().setColor(new Color(255,0,0));
        this.centralSettlement.getLocation().setThickness(this.centralSettlement.getSize());
    }


    /**
     * Generates random location for an amount of {@link Settlement}s as specified by the input parameter.
     * @param numLocations The number of locations to generate.
     * @return A {@link Set} of {@link Vertex}'s that describe the random locations of the {@link Settlement}s.
     */
    @Override
    public Set<Vertex> getSettlementLocations(int numLocations) {
        Set<Vertex> settlementLocations = new HashSet<>();

        for(int i = 0; i < numLocations; i++){

            int index = rand.nextInt(this.landTileCentroids.size());

            Vertex nextLocation = this.landTileCentroids.get(index);
            if(!settlementLocations.add(nextLocation)){
                i--;
            }
        }
        return settlementLocations;
    }


}
