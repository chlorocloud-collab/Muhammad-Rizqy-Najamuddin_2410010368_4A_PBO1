package caster;

import base.Operator;
import java.util.ArrayList;

public class Caster extends Operator {
    private int spCost;

    public Caster() {
        super();
    }

    public Caster(String name, String position, int atk, int def, int res, 
                  int blockCount, String subclass, ArrayList<String> affixes, int spCost) {
        super(name, position, atk, def, res, blockCount, subclass, affixes);
        this.spCost = spCost;
    }

    public int getSpCost() { return spCost; }
    public void setSpCost(int spCost) { this.spCost = spCost; }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("SP Cost   : " + spCost);
    }
}