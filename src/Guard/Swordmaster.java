package guard;

import java.util.ArrayList;

public class Swordmaster extends Guard {
    private int dualStrikeChance;

    public Swordmaster() {
        super();
    }

    public Swordmaster(String name, String position, int atk, int def, int res, 
                       int blockCount, String subclass, ArrayList<String> affixes, int physicalEvasion, int dualStrikeChance) {
        super(name, position, atk, def, res, blockCount, subclass, affixes, physicalEvasion);
        this.dualStrikeChance = dualStrikeChance;
    }

    public int getDualStrikeChance() { return dualStrikeChance; }
    public void setDualStrikeChance(int dualStrikeChance) { this.dualStrikeChance = dualStrikeChance; }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Dual Strike: " + dualStrikeChance + "%");
    }
}