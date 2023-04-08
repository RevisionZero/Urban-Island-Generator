import ca.mcmaster.cas.se2aa4.a2.island.cli.IslandInputHandler;
import ca.mcmaster.cas.se2aa4.a2.island.generator.IslandGenerator;
import ca.mcmaster.cas.se2aa4.a2.island.hook.Hook;
import ca.mcmaster.cas.se2aa4.a2.island.humidity.soil.SoilAbsorptionProfile;
import ca.mcmaster.cas.se2aa4.a2.island.io.MeshReader;
import ca.mcmaster.cas.se2aa4.a2.island.io.MeshWriter;
import ca.mcmaster.cas.se2aa4.a2.island.mesh.IslandMesh;
import ca.mcmaster.cas.se2aa4.a2.island.settlement.generator.SettlementGenerator;
import ca.mcmaster.cas.se2aa4.a2.island.settlement.roads.LandGraph;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.segment.Segment;
import ca.mcmaster.cas.se2aa4.a2.mesh.cli.InputHandler;
import ca.mcmaster.cas.se2aa4.a2.mesh.cli.exceptions.IllegalInputException;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            InputHandler handler = IslandInputHandler.getInputHandler(args);

            String input = IslandInputHandler.getInputMesh(handler);
            String output = IslandInputHandler.getOutputFile(handler);
            SoilAbsorptionProfile soilAbsorptionProfile = IslandInputHandler.getSoilAbsorptionProfile(handler);

            MeshReader meshReader = new MeshReader(input);
            IslandMesh mesh = new IslandMesh(meshReader.getMesh(), soilAbsorptionProfile);

            IslandGenerator generator = IslandInputHandler.getIslandMode(handler, mesh);
            generator.generate();

            int numSettlements = IslandInputHandler.getNumSettlements(handler);
            SettlementGenerator settlementGenerator = new SettlementGenerator(mesh.getConverted(), generator.getSeed(), generator.getLand());
            settlementGenerator.generateSettlements(numSettlements);

            LandGraph landGraph = new LandGraph(mesh.getConverted(), generator.getLand());
            List<Segment> path = landGraph.findShortestPath(settlementGenerator.getSettlements().get(1).getLocation(), settlementGenerator.getSettlements().get(0).getLocation()).get();
            path.forEach(segment -> {
                segment.setColor(new Color(255,0,0));
            });

            Hook heatMap = IslandInputHandler.getHook(handler);
            heatMap.apply(mesh.getTiles());

            MeshWriter writer = new MeshWriter();
            writer.write(mesh.getConverted(), output);

            System.out.printf("Island Seed: %d\n", generator.getSeed());
        } catch(IllegalInputException e) {
            System.exit(1);
        }
    }
}