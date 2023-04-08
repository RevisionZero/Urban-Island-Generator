package ca.mcmaster.cas.se2aa4.a2.island.settlement.generator;

import ca.mcmaster.cas.se2aa4.a2.island.geography.Land;
import ca.mcmaster.cas.se2aa4.a2.island.settlement.Settlement;
import ca.mcmaster.cas.se2aa4.a2.island.settlement.settlements.City;
import ca.mcmaster.cas.se2aa4.a2.island.settlement.settlements.Town;
import ca.mcmaster.cas.se2aa4.a2.island.settlement.settlements.Village;
import ca.mcmaster.cas.se2aa4.a2.island.tile.Tile;
import ca.mcmaster.cas.se2aa4.a2.island.tile.type.TileType;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.mesh.Mesh;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.polygon.Polygon;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.vertex.Vertex;

import java.awt.*;
import java.util.*;
import java.util.List;

public class SettlementGenerator {

    private Random rand;
    private Mesh mesh;
    private Land land;

    public SettlementGenerator(Mesh mesh, long seed, Land land){
        this.mesh = mesh;
        this.rand = new Random(seed);
        this.mesh.getVertices().forEach(vertex -> {
            vertex.setColor(new Color(0,0,0,0));
        });
        this.land = land;
    }

    public void generateSettlements(int numLocations){
        Set<Vertex> settlementLocations = getLocations(numLocations);

        settlementLocations.forEach(location -> {
            int chosenSettlement = rand.nextInt(3);
            float settlementSize;

            if(chosenSettlement == 0){
                settlementSize = rand.nextFloat(15,20);
                new City(location, settlementSize, new Color(130, 130, 130));
            }
            else if (chosenSettlement == 1) {
                settlementSize = rand.nextFloat(10,15);
                new Town(location, settlementSize, new Color(255,0,0));
            }
            else{
                settlementSize = rand.nextFloat(5,10);
                new Village(location, settlementSize, new Color(92,49,3));
            }
        });
    }

    private Set<Vertex> getLocations(int numLocations){
        List<Vertex> vertices = this.mesh.getVertices();

        Set<Vertex> settlementLocations = new HashSet<>();

        List<Tile> landTiles = land.getTiles().stream().filter(tile -> tile.getType() != TileType.OCEAN && tile.getType() != TileType.LAND_WATER).toList();

        List<Vertex> landVertices = new ArrayList<>();

        landTiles.forEach(tile -> {
            landVertices.addAll(tile.getPolygon().getVertices());
        });

        for(int i = 0; i < numLocations; i++){

            Vertex nextLocation = vertices.get(rand.nextInt(vertices.size()));
            if(!landVertices.contains(nextLocation)){
                i--;
            }
            else if(!settlementLocations.add(nextLocation)){
                i--;
            }
        }
        return settlementLocations;
    }
}
