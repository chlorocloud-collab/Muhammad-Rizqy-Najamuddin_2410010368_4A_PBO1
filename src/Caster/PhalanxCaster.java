package caster;

import java.util.ArrayList;

public class PhalanxCaster extends Caster {
    private boolean defenseMode;

    public PhalanxCaster() {
        super();
    }

    public PhalanxCaster(String name, String position, int atk, int def, int res, 
                         int blockCount, String subclass, ArrayList<String> affixes, int spCost, boolean defenseMode) {
        super(name, position, atk, def, res, blockCount, subclass, affixes, spCost);
        this.defenseMode = defenseMode;
    }

    public boolean isDefenseMode() { return defenseMode; }
    public void setDefenseMode(boolean defenseMode) { this.defenseMode = defenseMode; }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Def Mode  : " + (defenseMode ? "Yes" : "No"));
    }
}