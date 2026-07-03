package base;

import java.util.ArrayList;

public class Operator {
    private String name;
    private String position;
    private int atk;
    private int def;
    private int res;
    private int blockCount;
    private String subclass;
    private ArrayList<String> affixes;

    // Constructor 1: Default
    public Operator() {
        this.affixes = new ArrayList<>();
    }

    // Constructor 2: Lengkap dengan affixes
    public Operator(String name, String position, int atk, int def, int res,
                    int blockCount, String subclass, ArrayList<String> affixes) {
        this.name = name;
        this.position = position;
        this.atk = atk;
        this.def = def;
        this.res = res;
        this.blockCount = blockCount;
        this.subclass = subclass;
        this.affixes = (affixes != null) ? affixes : new ArrayList<>();
    }

    // ===== GETTER & SETTER =====
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public int getAtk() { return atk; }
    public void setAtk(int atk) { this.atk = atk; }

    public int getDef() { return def; }
    public void setDef(int def) { this.def = def; }

    public int getRes() { return res; }
    public void setRes(int res) { this.res = res; }

    public int getBlockCount() { return blockCount; }
    public void setBlockCount(int blockCount) { this.blockCount = blockCount; }

    public String getSubclass() { return subclass; }
    public void setSubclass(String subclass) { this.subclass = subclass; }

    public ArrayList<String> getAffixes() { return affixes; }
    public void setAffixes(ArrayList<String> affixes) { this.affixes = affixes; }

    // ===== METHOD CEK AFFIX (CASE-INSENSITIVE) =====
    public boolean hasAffix(String affix) {
        for (String a : affixes) {
            if (a.equalsIgnoreCase(affix)) return true;
        }
        return false;
    }

    // ===== METHOD DISPLAY (AKAN DI-OVERRIDE) =====
    public void displayInfo() {
        System.out.println("Nama      : " + name);
        System.out.println("Subclass  : " + subclass);
        System.out.println("Position  : " + position);
        System.out.println("ATK       : " + atk + " | DEF : " + def + " | RES : " + res);
        System.out.println("Block     : " + blockCount);
        System.out.print("Affix     : ");
        for (int i = 0; i < affixes.size(); i++) {
            System.out.print(affixes.get(i));
            if (i < affixes.size() - 1) System.out.print(", ");
        }
        System.out.println();
    }
}