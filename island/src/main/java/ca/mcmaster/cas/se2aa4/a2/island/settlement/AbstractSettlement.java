package ca.mcmaster.cas.se2aa4.a2.island.settlement;

import ca.mcmaster.cas.se2aa4.a2.island.settlement.settlements.City;
import ca.mcmaster.cas.se2aa4.a2.mesh.adt.vertex.Vertex;

public abstract class AbstractSettlement implements Settlement{

    private final Vertex location;

    private final float size;

    protected final String type;

    @Override
    public Vertex getLocation(){
        return this.location;
    }

    @Override
    public float getSize() {
        return size;
    }

    protected AbstractSettlement(Vertex location, float size){
        this.location = location;
        this.size = size;
        this.type = this.getClass().toString().replace("class ", "");
        this.location.setThickness(size);
    }


}
