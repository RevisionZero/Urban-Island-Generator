package ca.mcmaster.cas.se2aa4.a2.island.tile.configuration.configurators;

import ca.mcmaster.cas.se2aa4.a2.island.tile.color.colors.LandColorGenerator;
import ca.mcmaster.cas.se2aa4.a2.island.tile.configuration.AbstractConfigurator;

public class LandConfigurator extends AbstractConfigurator {
    public LandConfigurator() {
        super(new LandColorGenerator());
    }
}
