package ca.mcmaster.cas.se2aa4.a2.island.tile.configuration.configurators;

import ca.mcmaster.cas.se2aa4.a2.island.elevation.handler.handlers.NormalElevationHandler;
import ca.mcmaster.cas.se2aa4.a2.island.humidity.handlers.transmitter.HumidityTransmitter;
import ca.mcmaster.cas.se2aa4.a2.island.tile.color.colors.BeachColorGenerator;
import ca.mcmaster.cas.se2aa4.a2.island.tile.configuration.AbstractConfigurator;

public class BeachConfigurator extends AbstractConfigurator {
    public BeachConfigurator() {
        super(
                new BeachColorGenerator(),
                new NormalElevationHandler()
        );
    }
}
