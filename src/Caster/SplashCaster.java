package caster;

import java.util.ArrayList;

public class SplashCaster extends Caster {
    private int splashRadius;

    public SplashCaster() {
        super();
    }

    public SplashCaster(String name, String position, int atk, int def, int res, 
                        int blockCount, String subclass, ArrayList<String> affixes, int spCost, int splashRadius) {
        super(name, position, atk, def, res, blockCount, subclass, affixes, spCost);
        this.splashRadius = splashRadius;
    }

    public int getSplashRadius() { return splashRadius; }
    public void setSplashRadius(int splashRadius) { this.splashRadius = splashRadius; }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Splash Rad: " + splashRadius + " tiles");
    }
}