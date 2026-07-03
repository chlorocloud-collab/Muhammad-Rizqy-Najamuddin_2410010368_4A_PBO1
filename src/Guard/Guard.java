package guard;

import base.Operator;
import java.util.ArrayList;

public class Guard extends Operator {
    private int physicalEvasion;

    public Guard() {
        super();
    }

    public Guard(String name, String position, int atk, int def, int res, 
                 int blockCount, String subclass, ArrayList<String> affixes, int physicalEvasion) {
        super(name, position, atk, def, res, blockCount, subclass, affixes);
        this.physicalEvasion = physicalEvasion;
    }

    public int getPhysicalEvasion() { return physicalEvasion; }
    public void setPhysicalEvasion(int physicalEvasion) { this.physicalEvasion = physicalEvasion; }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Evasion   : " + physicalEvasion + "%");
    }
}