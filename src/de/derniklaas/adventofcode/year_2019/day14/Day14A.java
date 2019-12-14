package de.derniklaas.adventofcode.year_2019.day14;

import sun.plugin.dom.exception.InvalidStateException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day14A {

    private static String input = "118 ORE => 7 GTPZ\n6 RNQJN, 4 NQKVW => 4 DTQRC\n2 GBXJL => 3 XHBR\n4 BPZM => 9 LVDRH\n131 ORE => 3 RHBL\n2 LFZS => 2 FPRJW\n6 GTPZ => 4 VTBTK\n8 GPMP, 2 BPNFJ, 3 LFZS => 2 SFGCR\n3 GPMP => 4 SPRCM\n16 XCDZP, 1 NQKSL => 4 NQKVW\n2 BXGD, 3 VJHSV, 1 MGNCW => 8 MGLH\n1 XLNTJ => 1 KXBGP\n9 PJQWR, 19 NQKVW, 10 GJHWN => 7 ZBGDF\n3 VTBTK => 6 CJNQ\n12 PJQWR => 1 JNHBR\n16 BPZM => 9 MVCH\n1 KWPXQ, 1 LVDRH => 6 LFZS\n6 VTBTK => 6 XCDZP\n1 PZFG, 2 LFZS, 2 CJNQ, 2 FPRJW, 17 MVCH, 7 MGNCW, 26 KXBGP => 6 TBTL\n2 DTQRC, 7 NBNLC => 8 BPZM\n102 ORE => 3 WNTQ\n1 WNTQ => 9 NQKSL\n5 XZMH, 1 LPLMR, 13 BXGD => 8 JPFL\n1 NQKSL, 6 XCDZP, 2 FCDVQ => 9 GJHWN\n6 XZMH => 4 GLDL\n23 ZTWR, 4 BPZM => 2 MGNCW\n11 GPMP, 19 ZBGDF => 2 XZMH\n2 MGNCW, 4 XCDZP, 17 KQLT => 4 VJHSV\n1 CJNQ => 7 QHPH\n1 RHBL => 8 GBXJL\n2 MVCH, 3 KDNT, 6 NBNLC, 26 QHPH, 2 KRKB, 1 MCPDH, 4 XZMH, 6 XHBR => 1 HZMWJ\n9 XDLZ => 1 QSXKS\n4 GLDL => 6 WJNP\n5 MVCH => 3 MCPDH\n14 TKGM => 5 LPLMR\n1 WVQN => 2 PJQWR\n4 KWPXQ => 6 FCDVQ\n10 DTQRC, 27 TBTL, 9 HZMWJ, 41 XVGP, 2 TPZFL, 54 WNTQ, 85 RHBL, 5 WCZK, 2 QVSB, 28 SPRCM => 1 FUEL\n15 RNQJN, 1 PJQWR, 2 NBNLC => 4 TKGM\n126 ORE => 5 WVQN\n10 NBNLC => 3 BWMD\n2 SFGCR, 1 NQKSL, 1 KRKB => 1 WGQTF\n2 MLWN => 5 ZTWR\n12 DTQRC, 3 NQKVW, 9 NBNLC => 8 BPNFJ\n10 SFGCR, 1 PZFG, 2 ZVFVH, 12 WJNP, 14 WGQTF, 1 JNHBR, 8 FPRJW => 3 QVSB\n2 MCPDH => 8 XVGP\n19 JPFL => 4 TPZFL\n5 GBXJL => 6 MLWN\n9 TKGM => 5 KDNT\n1 NQKVW, 15 PJQWR => 9 XDLZ\n2 QHPH, 2 JNHBR => 1 ZVFVH\n189 ORE => 6 KWPXQ\n5 KRKB, 3 MGLH => 6 WCZK\n3 NBNLC, 8 BWMD => 7 KRKB\n1 ZBGDF, 6 XDLZ => 4 GPMP\n11 XDLZ, 1 QSXKS => 2 BXGD\n2 KRKB, 1 GJHWN => 1 XLNTJ\n3 ZTWR => 4 RNQJN\n15 FCDVQ, 3 MLWN => 4 NBNLC\n1 KDNT, 1 XZMH, 8 BXGD => 1 KQLT\n2 WJNP => 3 PZFG";

    //private static String input = "157 ORE => 5 NZVS\n165 ORE => 6 DCFZ\n44 XJWVT, 5 KHKGT, 1 QDVJ, 29 NZVS, 9 GPVTF, 48 HKGWZ => 1 FUEL\n12 HKGWZ, 1 GPVTF, 8 PSHF => 9 QDVJ\n179 ORE => 7 PSHF\n177 ORE => 5 HKGWZ\n7 DCFZ, 7 PSHF => 2 XJWVT\n165 ORE => 2 GPVTF\n3 DCFZ, 7 NZVS, 5 HKGWZ, 10 PSHF => 8 KHKGT";

    private static Map<Chemical, List<Chemical>> recepies = new HashMap<>();
    private static Map<Chemical, Integer> inventory = new HashMap<>();

    public static void main(String[] args) {
        String[] parts = input.split("\n");
        for (String line : parts) {
            String[] part = line.split("=>");
            String output = part[1].trim();
            int amount = Integer.parseInt(output.split(" ")[0]);
            String name = output.split(" ")[1];
            Chemical chem = new Chemical(name, amount);
            String input = part[0];
            List<Chemical> inputs = new ArrayList<>();
            for (String s : input.split(",")) {
                s = s.trim();
                amount = Integer.parseInt(s.split(" ")[0]);
                String chemname = s.split(" ")[1];
                inputs.add(new Chemical(chemname, amount));
            }
            recepies.put(chem, inputs);
        }

        System.out.printf("[Day 14/A] The Amount of ORE require is %d \n", getRecipe("FUEL", 1));
    }

    public static int getRecipe(String name, int amount) {
        Chemical c = getChemical(name);
        List<Chemical> inputs = recepies.get(c);
        int times = 0;
        while (c.getAmount() * times < amount) {
            times++;
        }
        inventory.put(c, c.getAmount() * times - amount);
        System.out.println();
        if (amount <= 0) {
            return 0;
        }
        int ore = 0;
        for (Chemical input : inputs) {
            if (!inventory.containsKey(input)) inventory.put(input, 0);
            if (input.getName().equalsIgnoreCase("ORE")) {
                ore += input.getAmount() * times;
            } else {
                ore += getRecipe(input.getName(), input.getAmount() * times - inventory.get(input));
            }


        }
        return ore;
    }

    private static Chemical getChemical(String name) {
        Chemical chem = null;
        for (Chemical chems : recepies.keySet()) {
            if (chems.getName().equalsIgnoreCase(name)) {
                chem = chems;
                break;
            }
        }
        if (chem == null) throw new InvalidStateException("Unknown Chemical " + name);
        return chem;
    }
}


