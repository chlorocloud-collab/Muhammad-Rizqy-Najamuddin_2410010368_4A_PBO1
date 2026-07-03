package guard;

import java.util.ArrayList;

public class Lord extends Guard {
    private boolean canAttackRange;

    public Lord() {
        super();
    }

    public Lord(String name, String position, int atk, int def, int res, 
                int blockCount, String subclass, ArrayList<String> affixes, int physicalEvasion, boolean canAttackRange) {
        super(name, position, atk, def, res, blockCount, subclass, affixes, physicalEvasion);
        this.canAttackRange = canAttackRange;
    }

    public boolean isCanAttackRange() { return canAttackRange; }
    public void setCanAttackRange(boolean canAttackRange) { this.canAttackRange = canAttackRange; }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Range Atk : " + (canAttackRange ? "Yes" : "No"));
    }
}