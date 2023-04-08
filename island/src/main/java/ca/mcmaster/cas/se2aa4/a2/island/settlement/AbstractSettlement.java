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

    protected AbstractSettlement(Vertex location, float size, Color settlementColor){
        this.location = location;
        this.size = size;
        this.type = this.getClass().toString().replace("class ", "");
        this.location.setThickness(size);
        this.location.setColor(settlementColor);
    }


}
