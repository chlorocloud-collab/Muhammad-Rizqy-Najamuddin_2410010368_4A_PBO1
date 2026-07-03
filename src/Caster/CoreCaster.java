package caster;

import java.util.ArrayList;

public class CoreCaster extends Caster {
    private int attackSpeedBonus;

    public CoreCaster() {
        super();
    }

    public CoreCaster(String name, String position, int atk, int def, int res, 
                      int blockCount, String subclass, ArrayList<String> affixes, int spCost, int attackSpeedBonus) {
        super(name, position, atk, def, res, blockCount, subclass, affixes, spCost);
        this.attackSpeedBonus = attackSpeedBonus;
    }

    public int getAttackSpeedBonus() { return attackSpeedBonus; }
    public void setAttackSpeedBonus(int attackSpeedBonus) { this.attackSpeedBonus = attackSpeedBonus; }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Atk Speed : +" + attackSpeedBonus + "%");
    }
}