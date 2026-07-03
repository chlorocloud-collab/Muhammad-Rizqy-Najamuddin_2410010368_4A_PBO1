package medic;

import base.Operator;
import java.util.ArrayList;

public class Medic extends Operator {
    private int healRange;

    public Medic() {
        super();
    }

    public Medic(String name, String position, int atk, int def, int res, 
                 int blockCount, String subclass, ArrayList<String> affixes, int healRange) {
        super(name, position, atk, def, res, blockCount, subclass, affixes);
        this.healRange = healRange;
    }

    public int getHealRange() { return healRange; }
    public void setHealRange(int healRange) { this.healRange = healRange; }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Heal Range: " + healRange + " tiles");
    }
}