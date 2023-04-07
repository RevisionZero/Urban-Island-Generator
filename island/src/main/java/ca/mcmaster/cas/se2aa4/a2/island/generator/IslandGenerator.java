package ca.mcmaster.cas.se2aa4.a2.island.generator;

import ca.mcmaster.cas.se2aa4.a2.island.geography.Land;

public interface IslandGenerator {

    long getSeed();

    /**
     * Generates the island terrain
     */
    void generate();

    Land getLand();
}
