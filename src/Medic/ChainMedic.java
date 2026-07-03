package medic;

import java.util.ArrayList;

public class ChainMedic extends Medic {
    private int chainTarget;

    public ChainMedic() {
        super();
    }

    public ChainMedic(String name, String position, int atk, int def, int res, 
                      int blockCount, String subclass, ArrayList<String> affixes, int healRange, int chainTarget) {
        super(name, position, atk, def, res, blockCount, subclass, affixes, healRange);
        this.chainTarget = chainTarget;
    }

    public int getChainTarget() { return chainTarget; }
    public void setChainTarget(int chainTarget) { this.chainTarget = chainTarget; }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Chain Heal: " + chainTarget + " targets");
    }
}