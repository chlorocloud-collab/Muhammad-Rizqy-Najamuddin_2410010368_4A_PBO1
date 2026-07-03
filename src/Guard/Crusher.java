package guard;

import java.util.ArrayList;

public class Crusher extends Guard {
    private boolean slowAttack;

    public Crusher() {
        super();
    }

    public Crusher(String name, String position, int atk, int def, int res, 
                   int blockCount, String subclass, ArrayList<String> affixes, int physicalEvasion, boolean slowAttack) {
        super(name, position, atk, def, res, blockCount, subclass, affixes, physicalEvasion);
        this.slowAttack = slowAttack;
    }

    public boolean isSlowAttack() { return slowAttack; }
    public void setSlowAttack(boolean slowAttack) { this.slowAttack = slowAttack; }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Slow Atk  : " + (slowAttack ? "Yes" : "No"));
    }
}