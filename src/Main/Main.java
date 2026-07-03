package main;

import base.Operator;
import guard.*;
import medic.*;
import caster.*;
import exception.*;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    // ===== MASTER AFFIXES =====
    private static final String[] MASTER_AFFIXES = {
        "Crowd Control", "Nuker", "Healing", "Support", "DP-Recovery", "DPS",
        "Survival", "AoE", "Defense", "Slow", "Debuff", "Fast-Redeploy",
        "Shift", "Summon", "Robot", "Elemental"
    };

    // ===== VARIABEL GLOBAL =====
    private static Operator[] allOperators = new Operator[12];
    private static Operator[] recruitmentResult = new Operator[0]; // Untuk menyimpan hasil terakhir
    private static Scanner scanner = new Scanner(System.in);

    // ================================================================
    // 1. INISIALISASI DATABASE
    // ================================================================
    private static void initializeDatabase() {
        ArrayList<String> aff1 = new ArrayList<>(Arrays.asList("DPS", "Support"));
        ArrayList<String> aff2 = new ArrayList<>(Arrays.asList("DPS", "Debuff"));
        ArrayList<String> aff3 = new ArrayList<>(Arrays.asList("DPS", "Survival"));
        ArrayList<String> aff4 = new ArrayList<>(Arrays.asList("Nuker", "DPS"));
        ArrayList<String> aff5 = new ArrayList<>(Arrays.asList("Healing", "DPS", "Debuff"));
        ArrayList<String> aff6 = new ArrayList<>(Arrays.asList("Healing"));
        ArrayList<String> aff7 = new ArrayList<>(Arrays.asList("Healing", "DPS", "Support"));
        ArrayList<String> aff8 = new ArrayList<>(Arrays.asList("Healing", "DPS"));
        ArrayList<String> aff9 = new ArrayList<>(Arrays.asList("DPS"));
        ArrayList<String> aff10 = new ArrayList<>(Arrays.asList("AoE", "Defense"));
        ArrayList<String> aff11 = new ArrayList<>(Arrays.asList("AoE", "Support", "Crowd Control"));
        ArrayList<String> aff12 = new ArrayList<>(Arrays.asList("DPS", "Healing", "Slow"));

        allOperators[0] = new Lord("SilverAsh", "Melee", 8, 7, 5, 2, "Lord", aff1, 10, true);
        allOperators[1] = new Lord("Lappland", "Melee", 7, 5, 5, 2, "Lord", aff2, 15, true);
        allOperators[2] = new Crusher("Ulpianus", "Melee", 9, 4, 3, 1, "Crusher", aff3, 5, true);
        allOperators[3] = new Swordmaster("Ch'en", "Melee", 8, 6, 4, 2, "Swordmaster", aff4, 20, 30);
        allOperators[4] = new IncantationMedic("Reed The Flame Shadow", "Ranged", 7, 5, 9, 0, "Incantation-Medic", aff5, 2, true);
        allOperators[5] = new WanderingMedic("Eyjafjalla the Hvít Aska", "Ranged", 5, 4, 9, 0, "Wandering-Medic", aff6, 2, true);
        allOperators[6] = new ChainMedic("Mon3tr", "Ranged", 8, 6, 8, 0, "Chain-Medic", aff7, 2, 3);
        allOperators[7] = new IncantationMedic("Amiya", "Ranged", 6, 5, 9, 0, "Incantation-Medic", aff8, 2, true);
        allOperators[8] = new CoreCaster("Logos", "Ranged", 9, 3, 9, 0, "Core-Caster", aff9, 25, 20);
        allOperators[9] = new PhalanxCaster("Lin", "Ranged", 7, 7, 9, 0, "Phalanx-Caster", aff10, 30, true);
        allOperators[10] = new SplashCaster("Mostima", "Ranged", 8, 4, 9, 0, "Splash-Caster", aff11, 35, 2);
        allOperators[11] = new CoreCaster("Nightmare", "Ranged", 8, 3, 9, 0, "Core-Caster", aff12, 25, 25);

        System.out.println("✅ Database " + allOperators.length + " Operator siap!");
    }

    // ================================================================
    // 2. PANDUAN SINGKAT
    // ================================================================
    private static void showQuickGuide() {
        System.out.println("\n=== PANDUAN SINGKAT REKRUTMEN ===");
        System.out.println("📌 CLASS TERSEDIA: Guard, Medic, Caster");
        System.out.println("\n📌 AFFIX (TAG) TERSEDIA:");
        for (int i = 0; i < MASTER_AFFIXES.length; i++) {
            System.out.print(MASTER_AFFIXES[i]);
            if (i < MASTER_AFFIXES.length - 1) System.out.print(", ");
            if ((i + 1) % 6 == 0) System.out.println();
        }
        System.out.println("\n📌 Cara input Affix: ");
        System.out.println("   - Satu affix: DPS");
        System.out.println("   - Multiple affix: DPS/Healing (pakai '/')");
        System.out.println("====================================");
    }

    // ================================================================
    // 3. PROSES REKRUTMEN (THROW EXCEPTION)
    // ================================================================
    private static void recruitmentProcess() throws InvalidAffixException, NoOperatorFoundException {
        System.out.println("\n=========================================");
        System.out.println("   ARKNIGHTS RECRUITMENT SYSTEM v1.0");
        System.out.println("=========================================");

        System.out.print("Enter Affix (pisahkan dengan '/' jika lebih dari 1): ");
        String affixInput = scanner.nextLine().trim();
        String[] affixList = affixInput.split("/");
        for (int i = 0; i < affixList.length; i++) {
            affixList[i] = affixList[i].trim();
        }

        // VALIDASI AFFIX (Custom Exception 1)
        for (String affix : affixList) {
            boolean affixValid = false;
            for (String master : MASTER_AFFIXES) {
                if (master.equalsIgnoreCase(affix)) {
                    affixValid = true;
                    break;
                }
            }
            if (!affixValid) {
                throw new InvalidAffixException("Affix '" + affix + "' tidak dikenal! Cek daftar affix.");
            }
        }

        System.out.print("Enter Class  : ");
        String classInput = scanner.nextLine().trim();

        String selectedClass = null;
        if (classInput.equalsIgnoreCase("Guard")) {
            selectedClass = "Guard";
        } else if (classInput.equalsIgnoreCase("Medic")) {
            selectedClass = "Medic";
        } else if (classInput.equalsIgnoreCase("Caster")) {
            selectedClass = "Caster";
        } else {
            throw new InvalidAffixException("Class '" + classInput + "' tidak valid! Pilih: Guard, Medic, atau Caster.");
        }

        // FILTER OPERATOR
        Operator[] results = new Operator[12];
        int count = 0;

        for (Operator op : allOperators) {
            boolean isGuard = op instanceof Guard;
            boolean isMedic = op instanceof Medic;
            boolean isCaster = op instanceof Caster;

            boolean classMatch = false;
            if (selectedClass.equals("Guard") && isGuard) classMatch = true;
            else if (selectedClass.equals("Medic") && isMedic) classMatch = true;
            else if (selectedClass.equals("Caster") && isCaster) classMatch = true;

            boolean hasAllAffixes = true;
            for (String affix : affixList) {
                if (!op.hasAffix(affix)) {
                    hasAllAffixes = false;
                    break;
                }
            }

            if (classMatch && hasAllAffixes) {
                results[count] = op;
                count++;
            }
        }

        // VALIDASI HASIL (Custom Exception 2 - Coming Soon)
        if (count == 0) {
            throw new NoOperatorFoundException(
                "Tidak ada operator " + selectedClass + " dengan kombinasi affix tersebut. " +
                "Mungkin kombinasi ini tidak valid atau operatornya belum datang! (Coming Soon!)"
            );
        }

        // SIMPAN HASIL KE VARIABEL GLOBAL (untuk keperluan Save/Load)
        recruitmentResult = new Operator[count];
        for (int i = 0; i < count; i++) {
            recruitmentResult[i] = results[i];
        }

        // TAMPILKAN HASIL
        System.out.println("\n=========================================");
        System.out.println("   HASIL REKRUTMEN");
        System.out.println("=========================================");

        if (count == 1) {
            Operator op = results[0];
            System.out.println("\n" + op.getName() + " ---------- " + selectedClass + " [" + op.getSubclass() + "]");
            System.out.println("Blockcount : " + op.getBlockCount());
            System.out.println("ATK        : " + op.getAtk());
            System.out.println("DEF        : " + op.getDef());
            System.out.println("RES        : " + op.getRes());
            System.out.print("Affix      : ");
            ArrayList<String> affs = op.getAffixes();
            for (int i = 0; i < affs.size(); i++) {
                System.out.print(affs.get(i));
                if (i < affs.size() - 1) System.out.print(", ");
            }
            System.out.println();

            // Detail spesifik subclass
            if (op instanceof Lord) {
                System.out.println("Range Atk  : " + (((Lord) op).isCanAttackRange() ? "Yes" : "No"));
            } else if (op instanceof Crusher) {
                System.out.println("Slow Atk   : " + (((Crusher) op).isSlowAttack() ? "Yes" : "No"));
            } else if (op instanceof Swordmaster) {
                System.out.println("Dual Strike: " + ((Swordmaster) op).getDualStrikeChance() + "%");
            } else if (op instanceof ChainMedic) {
                System.out.println("Chain Heal : " + ((ChainMedic) op).getChainTarget() + " targets");
            } else if (op instanceof WanderingMedic) {
                System.out.println("Elem Heal  : " + (((WanderingMedic) op).isElementalHeal() ? "Yes" : "No"));
            } else if (op instanceof IncantationMedic) {
                System.out.println("Dmg->Heal  : " + (((IncantationMedic) op).isDamageConvertHeal() ? "Yes" : "No"));
            } else if (op instanceof CoreCaster) {
                System.out.println("Atk Speed  : +" + ((CoreCaster) op).getAttackSpeedBonus() + "%");
            } else if (op instanceof SplashCaster) {
                System.out.println("Splash Rad : " + ((SplashCaster) op).getSplashRadius() + " tiles");
            } else if (op instanceof PhalanxCaster) {
                System.out.println("Def Mode   : " + (((PhalanxCaster) op).isDefenseMode() ? "Yes" : "No"));
            }
            System.out.println("\n[Operator " + op.getName() + " adalah satu-satunya operator yang bisa kamu dapatkan]");
        } else {
            System.out.println("\nPossibilitas dari Recruitment anda adalah");
            for (int i = 0; i < count; i++) {
                System.out.println("- " + results[i].getName());
            }
            System.out.println("\n[Operator di atas adalah salah satu operator yang bisa kamu dapatkan]");
        }
        System.out.println("\n=========================================");
    }

    // ================================================================
    // 4. SIMPAN KE FILE (IO Sederhana)
    // ================================================================
    private static void saveToFile() {
        if (recruitmentResult == null || recruitmentResult.length == 0) {
            System.out.println("⚠️  Tidak ada hasil rekrutmen untuk disimpan!");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("recruitment_result.txt"))) {
            writer.write("=== ARKNIGHTS RECRUITMENT RESULT ===\n");
            writer.write("Jumlah Operator: " + recruitmentResult.length + "\n\n");
            for (Operator op : recruitmentResult) {
                writer.write("Nama: " + op.getName() + " | Subclass: " + op.getSubclass() + " | Affix: " + op.getAffixes() + "\n");
            }
            System.out.println("✅ Data berhasil disimpan ke 'recruitment_result.txt'");
        } catch (IOException e) {
            System.out.println("❌ Error saat menyimpan: " + e.getMessage());
        }
    }

    // ================================================================
    // 5. MUAT DARI FILE (IO Sederhana)
    // ================================================================
    private static void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("recruitment_result.txt"))) {
            String line;
            System.out.println("\n--- ISI FILE recruitment_result.txt ---");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("----------------------------------------");
        } catch (FileNotFoundException e) {
            System.out.println("❌ File 'recruitment_result.txt' tidak ditemukan!");
        } catch (IOException e) {
            System.out.println("❌ Error saat membaca file: " + e.getMessage());
        }
    }

    // ================================================================
    // 6. MAIN METHOD (MENU UTAMA)
    // ================================================================
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   ARKNIGHTS RECRUITMENT SYSTEM v1.0");
        System.out.println("=========================================");

        initializeDatabase();
        showQuickGuide();

        while (true) {
            System.out.println("\n===== MENU UTAMA =====");
            System.out.println("1. Rekrut Operator");
            System.out.println("2. Simpan Hasil ke File");
            System.out.println("3. Muat Hasil dari File");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");

            int choice = 0;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("⚠️  Input harus angka!");
                scanner.nextLine();
                continue;
            }

            switch (choice) { // SELEKSI (Switch-Case)
                case 1:
                    try {
                        recruitmentProcess(); // THROW EXCEPTION DI SINI
                    } catch (InvalidAffixException | NoOperatorFoundException e) {
                        System.out.println("\n❌ " + e.getMessage());
                    }
                    break;
                case 2:
                    saveToFile();
                    break;
                case 3:
                    loadFromFile();
                    break;
                case 4:
                    System.out.println("Terima kasih, Dokter! Sampai jumpa.");
                    System.exit(0);
                default:
                    System.out.println("Menu tidak valid.");
            }
        }
    }
}