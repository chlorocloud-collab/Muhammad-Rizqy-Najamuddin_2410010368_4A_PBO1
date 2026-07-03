package medic;

import java.util.ArrayList;

public class IncantationMedic extends Medic {
    private boolean damageConvertHeal;

    public IncantationMedic() {
        super();
    }

    public IncantationMedic(String name, String position, int atk, int def, int res, 
                            int blockCount, String subclass, ArrayList<String> affixes, int healRange, boolean damageConvertHeal) {
        super(name, position, atk, def, res, blockCount, subclass, affixes, healRange);
        this.damageConvertHeal = damageConvertHeal;
    }

    public boolean isDamageConvertHeal() { return damageConvertHeal; }
    public void setDamageConvertHeal(boolean damageConvertHeal) { this.damageConvertHeal = damageConvertHeal; }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Dmg->Heal : " + (damageConvertHeal ? "Yes" : "No"));
    }
}