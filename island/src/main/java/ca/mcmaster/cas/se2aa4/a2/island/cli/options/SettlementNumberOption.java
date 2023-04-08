package ca.mcmaster.cas.se2aa4.a2.island.cli.options;

import org.apache.commons.cli.Option;

import java.util.Random;

public class SettlementNumberOption extends Option {

    public static final String OPTION_STR = "settlements";
    private static final String DESCRIPTION = "What number of settlements(cities, towns, villages) do you want?";
    public static final String DEFAULT_VALUE = "5";

    public SettlementNumberOption() {
        super("set", OPTION_STR, true, DESCRIPTION);
        super.setRequired(false);
        super.setArgs(1);
        super.setArgName("settlements");
    }


}
