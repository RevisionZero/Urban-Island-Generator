package ca.mcmaster.cas.se2aa4.a2.island.settlement.settlements;

import ca.mcmaster.cas.se2aa4.a2.island.settlement.AbstractSettlement;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.vertex.Vertex;

import java.awt.*;

public class Town extends AbstractSettlement {

    public Town(Vertex location, float size, Color settlementColor) {
        super(location, size, settlementColor);
    }
}
