package ca.mcmaster.cas.se2aa4.a2.island.settlement;

import ca.mcmaster.cas.se2aa4.a2.mesh.adt.vertex.Vertex;

public interface Settlement {

    /**
     *
     * @return The {@link Float} representing the radius of the vertex of the {@link Settlement}.
     */
    float getSize();

    /**
     *
     * @return The {@link Vertex} representing the location of the {@link Settlement}.
     */
    Vertex getLocation();

    /**
     *
     * @return The {@link String} representation of the type of the {@link Settlement}.
     */
    String getType();
}
