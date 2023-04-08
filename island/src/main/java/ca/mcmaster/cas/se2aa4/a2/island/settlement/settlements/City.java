package ca.mcmaster.cas.se2aa4.a2.island.settlement.settlements;

import ca.mcmaster.cas.se2aa4.a2.island.settlement.AbstractSettlement;
import ca.mcmaster.cas.se2aa4.a2.island.settlement.Settlement;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.vertex.Vertex;

import java.awt.*;

public class City extends AbstractSettlement {


    /**
     * Creates a new {@link City} at the specified location with the specified size.
     * @param location The {@link Vertex} to use as a location for the {@link Settlement}.
     * @param size The {@link Float} representing the radius of the {@link Vertex} representing the {@link Settlement}.
     */
    public City(Vertex location, float size) {
        super(location, size);
    }
}
