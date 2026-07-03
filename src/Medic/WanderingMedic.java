package medic;

import java.util.ArrayList;

public class WanderingMedic extends Medic {
    private boolean elementalHeal;

    public WanderingMedic() {
        super();
    }

    public WanderingMedic(String name, String position, int atk, int def, int res, 
                          int blockCount, String subclass, ArrayList<String> affixes, int healRange, boolean elementalHeal) {
        super(name, position, atk, def, res, blockCount, subclass, affixes, healRange);
        this.elementalHeal = elementalHeal;
    }

    public boolean isElementalHeal() { return elementalHeal; }
    public void setElementalHeal(boolean elementalHeal) { this.elementalHeal = elementalHeal; }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Elem Heal : " + (elementalHeal ? "Yes" : "No"));
    }
}