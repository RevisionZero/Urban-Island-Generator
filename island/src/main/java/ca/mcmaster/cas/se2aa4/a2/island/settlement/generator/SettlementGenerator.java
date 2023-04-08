package ca.mcmaster.cas.se2aa4.a2.island.settlement.generator;

import ca.mcmaster.cas.se2aa4.a2.island.geography.Land;
import ca.mcmaster.cas.se2aa4.a2.island.settlement.Settlement;
import ca.mcmaster.cas.se2aa4.a2.island.settlement.roads.LandGraph;
import ca.mcmaster.cas.se2aa4.a2.island.settlement.settlements.City;
import ca.mcmaster.cas.se2aa4.a2.island.settlement.settlements.Town;
import ca.mcmaster.cas.se2aa4.a2.island.settlement.settlements.Village;
import ca.mcmaster.cas.se2aa4.a2.island.tile.Tile;
import ca.mcmaster.cas.se2aa4.a2.island.tile.type.TileType;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.mesh.Mesh;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.polygon.Polygon;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.segment.Segment;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.vertex.Vertex;
import ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge.edges.UndirectedEdge;

import java.awt.*;
import java.util.*;
import java.util.List;

public class SettlementGenerator {

    private Random rand;
    private Mesh mesh;
    private Land land;
    private List<Settlement> settlements;

    public SettlementGenerator(Mesh mesh, long seed, Land land){
        this.mesh = mesh;
        this.rand = new Random(seed);
        this.mesh.getVertices().forEach(vertex -> {
            vertex.setColor(new Color(0,0,0,0));
        });
        this.land = land;
        this.settlements = new ArrayList<>();
    }

    public void generateSettlements(int numLocations){
        createSettlements(numLocations);
        createStarNetwork();

    }

    private void createSettlements(int numLocations){
        Set<Vertex> settlementLocations = getLocations(numLocations);

        settlementLocations.forEach(location -> {
            int chosenSettlementType = rand.nextInt(3);
            float settlementSize;

            if(chosenSettlementType == 0){
                settlementSize = rand.nextFloat(15,20);
                City city = new City(location, settlementSize, new Color(130, 130, 130));
                settlements.add(city);
            }
            else if (chosenSettlementType == 1) {
                settlementSize = rand.nextFloat(10,15);
                Town town = new Town(location, settlementSize, new Color(255,0,0));
                settlements.add(town);
            }
            else{
                settlementSize = rand.nextFloat(5,10);
                Village village = new Village(location, settlementSize, new Color(92,49,3));
                settlements.add(village);
            }
        });
    }

    private void createStarNetwork(){

        Settlement centralCity = settlements.get(rand.nextInt(settlements.size()));

        Vertex centralVertex = centralCity.getLocation();

        LandGraph landGraph = new LandGraph(this.mesh, this.land);

        settlements.stream().filter(settlement -> !settlement.equals(centralCity)).forEach(settlement -> {
            Optional<List<Segment>> shortestPath = landGraph.findShortestPath(centralVertex, settlement.getLocation());
            shortestPath.ifPresent(this::drawRoad);
        });

    }

    private void drawRoad(List<Segment> segments){
        segments.forEach(segment -> {
            segment.setColor(new Color(0,0,0));
        });
    }

    private Set<Vertex> getLocations(int numLocations){
        //List<Vertex> vertices = this.mesh.getVertices();

        Set<Vertex> settlementLocations = new HashSet<>();

        //List<Tile> landTiles = land.getTiles().stream().filter(tile -> tile.getType() != TileType.OCEAN && tile.getType() != TileType.LAND_WATER).toList();

        List<Vertex> landVertices = new ArrayList<>();

//        landTiles.forEach(tile -> {
//            landVertices.addAll(tile.getPolygon().getVertices());
//        });

        land.getPaths().forEach(path -> {
            Segment segment = path.getSegment();
            landVertices.add(segment.getV1());
            landVertices.add(segment.getV2());
        });

        for(int i = 0; i < numLocations; i++){

            Vertex nextLocation = landVertices.get(rand.nextInt(landVertices.size()));
            if(!settlementLocations.add(nextLocation)){
                i--;
            }
        }
        return settlementLocations;
    }
}
