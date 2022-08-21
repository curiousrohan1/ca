import java.util.Random;
import java.util.Scanner;

public class XorCA {
    public static void xorca(String rule, int neighborhoodsize, int length, int base) {
        System.out.println("rule is " + rule + ", neighborhood size is " + neighborhoodsize + ".");
        int[] cells = Util.genSymCells(length, base);
        Util.draw(cells, base);
        int[] nextgen = new int[length];
        for (int j = 0; j < length; j++) {
            for (int i = neighborhoodsize / 2; i < length - neighborhoodsize / 2; i++) {
                int[] hood = new int[neighborhoodsize];
                for (int k = 0; k < neighborhoodsize; k++) {
                    hood[k] = cells[i - neighborhoodsize / 2 + k];
                }
                int bin1 = hood[neighborhoodsize - Integer.parseInt(rule.substring(0, rule.indexOf(' '))) - 1];
                int bin2 = hood[neighborhoodsize - Integer.parseInt(rule.substring(rule.indexOf(' ') + 1)) - 1];
                nextgen[i] = (bin1 + bin2) % base;
            }
            cells = nextgen;
            Util.draw(cells, base);
        }
    }

    public static void main(String[] args) {
        Random randgen = new Random(System.currentTimeMillis());
        Scanner input = new Scanner(System.in);
        System.out.println("How long should each line be?");
        int length = input.nextInt();
        System.out.println(
                "How big should the neighborhood(the subset of the previous row used to calculate each cell of the current row) be?");
        int neighborhoodsize = input.nextInt();
        System.out.println("How many cellular automata should be generated?");
        int automatanum = input.nextInt();
        System.out.println("What base?");
        int base = input.nextInt();
        for (int l = 0; l < automatanum; l++) {
            System.out.println("\n[" + l + "]");
            int k1 = randgen.nextInt(neighborhoodsize);
            int k2 = randgen.nextInt(neighborhoodsize);
            while (k1 == k2) {
                k2 = randgen.nextInt(neighborhoodsize);
            }
            String rule = "" + k1 + " " + k2;
            xorca(rule, neighborhoodsize, length, base);
        }
        input.close();
    }
}
