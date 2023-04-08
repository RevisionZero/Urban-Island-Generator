package ca.mcmaster.cas.se2aa4.a2.island.settlement;

import ca.mcmaster.cas.se2aa4.a2.island.settlement.settlements.City;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.vertex.Vertex;

import java.awt.*;

public abstract class AbstractSettlement implements Settlement{

    private final Vertex location;

    private final float size;

    protected final String type;

    @Override
    public String getType() {
        return type;
    }
    @Override
    public Vertex getLocation(){
        return this.location;
    }

    @Override
    public float getSize() {
        return size;
    }

    /**
     *
     * @param location The {@link Vertex} to use as a location for the {@link Settlement}.
     * @param size The {@link Float} representing the radius of the {@link Vertex} representing the {@link Settlement}.
     */
    protected AbstractSettlement(Vertex location, float size){
        this.location = location;
        this.size = size;
        this.type = this.getClass().toString().replace("class ", "");
    }


}
