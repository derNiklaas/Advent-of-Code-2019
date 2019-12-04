package de.derniklaas.adventofcode.day3;

import de.derniklaas.adventofcode.day3.test.Grid;

public class Day3B {

    public static void main(String[] args) {
        System.out.println(new Grid().nearestCrossSection(false));
    }
/*
    private static String wire1 = "R998,D934,L448,U443,R583,U398,R763,U98,R435,U984,L196,U410,L475,D163,R776,D796,R175,U640,R805,D857,R935,D768,L99,D75,R354,U551,L986,D592,R51,U648,L108,U8,R44,U298,L578,U710,R745,U60,L536,D62,R620,D454,L143,U407,R465,U606,L367,U107,L581,U900,R495,D12,R763,D244,R946,D424,R367,D696,L534,U452,R274,D942,L813,U336,L742,U134,R571,U703,R941,D532,L903,D833,L821,D577,L598,D83,R858,U798,L802,D852,R913,U309,L784,D235,L446,D571,R222,D714,R6,D379,R130,D313,R276,U632,L474,U11,L551,U257,R239,U218,R592,U901,L596,D367,L34,D397,R520,U547,L795,U192,R960,U77,L825,U954,R307,D399,R958,U239,R514,D863,L162,U266,R705,U731,R458,D514,R42,U314,R700,D651,L626,U555,R774,U773,R553,D107,L404,D100,R149,U845,L58,U674,R695,U255,R816,D884,R568,U618,R510,D566,L388,D947,L851,U127,L116,U143,L744,D361,L336,U903,L202,U683,R287,D174,L229,U371,L298,U839,L27,U462,R443,D39,R411,U788,L197,D160,L289,U840,L78,D262,R352,U83,R20,U109,R657,D225,R587,D968,R576,D791,R493,U805,R139,D699,R783,U140,L371,D170,L635,U257,R331,D311,R725,D970,R57,D986,L222,D760,L830,D960,L901,D367,R469,D560,L593,D940,L71,D384,R603,D689,R250,D859,L156,U499,L850,U166,R726,D210,L36,D584,R672,U47,L713,U985,R551,U22,L499,D575,R210,D829,L186,U340,R696,D939,L744,D46,L896,U467,L214,D71,R376,D379,L1,U870,R785,D779,L94,U723,L199,D185,R210,U937,R645,U25,R116,D821,R964,U959,R569,U496,R809,U112,R712,D315,L747,U754,L66,U614,L454,D945,R214,U965,L248,U702,L287,D863,R700,U768,R139,D242,R914,D818,R340,D60,L400,D924,R69,U73,L449,U393,L906";
    private static String wire2 = "L1005,D207,R487,U831,R81,U507,R701,D855,R978,U790,R856,U517,R693,D726,L857,D442,L13,U441,R184,D42,R27,D773,R797,D242,L689,D958,R981,D279,L635,D881,L907,U716,L90,U142,R618,D188,L725,U329,R717,D857,L583,U851,L140,U903,R363,U226,L413,U240,R772,U523,L860,U596,L861,D198,L44,U956,R862,U683,L542,U581,L346,U376,L568,D488,L254,D565,R480,D418,L567,U73,R397,U265,R632,U87,R803,D85,L100,D12,L989,U886,R279,U507,R274,U17,L36,U309,L189,D145,R50,U408,L451,D37,R930,D566,R96,U673,L302,U859,R814,U478,R218,U494,R177,D85,L376,U545,L106,U551,L469,U333,R685,U625,L933,U99,R817,D473,R412,D203,R912,U460,L527,D730,L193,U894,L256,D209,L868,D942,L8,U532,L270,U147,R919,U899,R256,U124,R204,D199,L170,D844,R974,U16,R722,U12,L470,D51,R821,U730,L498,U311,R587,D570,R981,D917,R440,D485,R179,U874,R26,D310,R302,U260,R446,D241,R694,D138,L400,D852,L194,U598,R73,U387,R660,D597,L803,D571,L956,D89,L394,U564,L287,U668,L9,D103,R152,D318,L215,U460,L870,U997,L595,D479,R262,U531,R609,U50,L165,U704,L826,D527,L901,D857,L914,U623,R432,D988,R562,D301,L277,U274,R39,D177,L827,U944,R64,U560,R801,D83,R388,U978,R387,U435,L759,U200,L760,U403,L218,D399,L178,U700,L75,U749,R85,U368,R538,U3,L172,D634,R518,D435,L542,U347,L745,U353,L178,D133,L475,U459,L522,U354,R184,U339,R845,D145,L44,U61,L603,U256,R534,U558,L998,D36,R42,U379,R813,D412,R878,D370,R629,U883,L490,D674,L863,U506,L961,D882,R436,D984,L229,D78,L779,D117,L674,U850,L494,D205,L988,D202,L368,U955,L662,U647,R774,D575,L753,D294,R131,U318,R873,U114,L30";


    private static List<Point> wires = new ArrayList<>();
    private static List<Point> wires2 = new ArrayList<>();
    private static List<Point> crossings = new ArrayList<>();
    private static List<Point> paths = new ArrayList<>();

    private static Point start = new Point(0, 0, true);

    public static void main(String[] args) {
        generateWire(wire1, false);
        generateWire(wire2, true);
        Point closest = null;
        for (Point crossing : crossings) {
            if (closest == null) {
                closest = crossing;
            } else {
                if (distance(crossing, start) < distance(closest, start)) {
                    closest = crossing;
                }
            }
        }
        System.out.println("Closest distance: " + distance(closest, start));

        paths = merge(wires, wires2);
        System.out.println("Finished merging paths...");
        System.out.println("Finding fastest route... This may take a while...");
        generatePath(closest, get(paths, start), 5, 0);
    }

    private static List<Point> merge(List<Point> points1, List<Point> points2) {
        List<Point> paths = new ArrayList<>();
        for (Point p : points1) {
            if (get(paths, p) == null) {
                paths.add(p);
            } else {
                Point point = get(paths, p);
                if (!point.isCorner() && p.isCorner()) {
                    point.setCorner(true);
                }
            }
        }
        for (Point p : points2) {
            if (get(paths, p) == null) {
                paths.add(p);
            } else {
                Point point = get(paths, p);
                if (!point.isCorner() && p.isCorner()) {
                    point.setCorner(true);
                }
            }
        }
        return paths;
    }

    private static int distance(Point a, Point b) {
        return Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY());
    }

    private static void generatePath(Point to, Point current, int direction, int step) {
        if (get(paths, current) == null) return;
        if (to.getX() == current.getX() && to.getY() == current.getY()) {
            System.out.println("Length: " + step + 1);
        }
        if (!(current.getX() == start.getX() && current.getY() == start.getY())) {
            if (!contains(paths, current)) {
                //System.out.println("Not a wire: x=" + current.getX() + " y=" + current.getY());
                return;
            }
            if (get(paths, current).isVisited()) {
                System.out.println("Already visited x=" + current.getX() + " y=" + current.getY());
                return;
            }
            Point p = get(paths, current);
            if (contains(crossings, current) || get(paths, current).isCorner()) { //Test all directions
                System.out.println("Found a corner or crossing at x=" + current.getX() + " y=" + current.getY());
                direction = 5;
            }
            if (!paths.remove(p)) {
                System.out.println("Error");
                System.exit(-1);
                return;
            }
        }
        //System.out.println("current direction: " + direction);
        switch (direction) {
            case 1: { // UP -> y-1
                Point p = current.clone();
                p.setY(p.getY() - 1);
                generatePath(to, p, 1, step + 1);
                break;
            }
            case 2: { // DOWN -> y+1
                Point p = current.clone();
                p.setY(p.getY() + 1);
                generatePath(to, p, 2, step + 1);
                break;
            }
            case 3: { // LEFT -> x-1
                Point p = current.clone();
                p.setX(p.getX() - 1);
                generatePath(to, p, 3, step + 1);
                break;
            }
            case 4: { // RIGHT -> x+1
                Point p = current.clone();
                p.setX(p.getX() + 1);
                generatePath(to, p, 4, step + 1);
                break;
            }
            case 5: {
                Point up = current.clone();
                up.setY(up.getY() - 1);
                Point down = current.clone();
                down.setY(down.getY() + 1);
                Point left = current.clone();
                left.setX(left.getX() - 1);
                Point right = current.clone();
                right.setX(right.getX() + 1);
                generatePath(to, up, 1, step + 1);
                generatePath(to, down, 2, step + 1);
                generatePath(to, left, 3, step + 1);
                generatePath(to, right, 4, step + 1);
                break;
            }
        }
    }

    private static boolean contains(List<Point> points, Point point) {
        for (Point p : points) {
            if (p.getX() == point.getX() && p.getY() == point.getY()) return true;
        }
        return false;
    }


    private static Point get(List<Point> points, Point point) {
        for (Point p : points) {
            if (p.getX() == point.getX() && p.getY() == point.getY()) return p;
        }
        return null;
    }

    private static void generateWire(String input, boolean crossing) {
        Point current = start.clone();
        String[] parts = input.split(",");
        for (String part : parts) {
            current.setCorner(true);
            if (crossing) {
                wires2.add(current.clone());
            } else {
                wires.add(current.clone());
            }
            current.setCorner(false);
            int amount = Integer.parseInt(part.substring(1));
            switch (part.charAt(0)) {
                case 'U': { // UP -> y-1
                    for (int i = 0; i < amount; i++) {
                        current.setY(current.getY() - 1);
                        current.setCorner(false);
                        if (!crossing) {
                            wires.add(current.clone());
                        } else {
                            wires2.add(current.clone());
                            if (contains(wires, current)) {
                                crossings.add(current.clone());
                                System.out.println("New Crossing: " + current.getX() + "/" + current.getY());
                            }
                        }
                    }
                    break;
                }
                case 'D': { // DOWN -> y+1
                    for (int i = 0; i < amount; i++) {
                        current.setY(current.getY() + 1);
                        current.setCorner(false);
                        if (!crossing) {
                            wires.add(current.clone());
                        } else {
                            wires2.add(current.clone());
                            if (contains(wires, current)) {
                                crossings.add(current.clone());
                                System.out.println("New Crossing: " + current.getX() + "/" + current.getY());
                            }
                        }
                    }
                    break;
                }
                case 'L': { // LEFT -> x-1
                    for (int i = 0; i < amount; i++) {
                        current.setX(current.getX() - 1);
                        current.setCorner(false);
                        if (!crossing) {
                            wires.add(current.clone());
                        } else {
                            wires2.add(current.clone());
                            if (contains(wires, current)) {
                                crossings.add(current.clone());
                                System.out.println("New Crossing: " + current.getX() + "/" + current.getY());
                            }
                        }
                    }
                    break;

                }
                case 'R': { // RIGHT -> x+1
                    for (int i = 0; i < amount; i++) {
                        current.setX(current.getX() + 1);
                        current.setCorner(false);
                        if (!crossing) {
                            wires.add(current.clone());
                        } else {
                            wires2.add(current.clone());
                            if (contains(wires, current)) {
                                crossings.add(current.clone());
                                System.out.println("New Crossing: " + current.getX() + "/" + current.getY());
                            }
                        }
                    }
                    break;
                }

            }
        }
    }
*/
}