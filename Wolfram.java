import java.util.Random;
import java.util.Scanner;

public class Wolfram {
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
        for (int l = 0; l < automatanum; l++) {
            int rule = randgen.nextInt(1 << (1 << neighborhoodsize));
            wolfram(length, neighborhoodsize, rule);
        }
        input.close();
    }

    public static void wolfram(int length, int neighborhoodsize, int rule) {
        System.out.println("rule is " + rule + ", neighborhood size is " + neighborhoodsize + ".");
        int[] cells = Util.genSymCells(length, 2);
        Util.draw(cells, 2);
        int[] nextgen = new int[length];
        for (int j = 0; j < length; j++) {
            for (int i = neighborhoodsize / 2; i < length - neighborhoodsize / 2; i++) {
                int[] hood = new int[neighborhoodsize];
                for (int k = 0; k < neighborhoodsize; k++) {
                    hood[k] = cells[i - neighborhoodsize / 2 + k];
                }
                int rule1 = rule;
                int size = 1 << neighborhoodsize;
                rule1 %= 1 << size;
                String bin = Integer.toBinaryString(rule1);
                int[] ruleset1 = new int[size];
                while (bin.length() < size) {
                    bin = '0' + bin;
                }
                for (int i1 = 0; i1 < ruleset1.length; i1++) {
                    ruleset1[i1] = bin.charAt(i1) - '0';
                }
                int[] ruleset = ruleset1;
                String s = "";
                for (int i1 = 0; i1 < neighborhoodsize; i1++) {
                    s += hood[i1];
                }
                int index = Integer.parseInt(s, 2);
                nextgen[i] = ruleset[index];
            }
            cells = nextgen;
            Util.draw(cells, 2);
        }
    }

}