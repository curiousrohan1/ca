import java.util.Scanner;

/**
 * XorCAII
 */
public class XorCAII {

    public static void xorcaii(int length, int base) {
        int[][] automaton = new int[length][length];
        automaton[0] = Util.genRandomCells(length, base);
        automaton[1] = Util.genRandomCells(length, base);
        Util.draw(automaton[0], base);
        Util.draw(automaton[1], base);
        int[] nextgen = new int[length];
        for (int j = 2; j < length; j++) {
            for (int i = 0; i < length; i++) {
                nextgen[i] = (automaton[j - 1][i] + automaton[j - 2][i]) % base;
            }
            Util.draw(nextgen, base);
            automaton[j] = nextgen;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How long should each line be?");
        int length = input.nextInt();
        System.out.println("How many different characters should be in the automaton(what base should it be)?");
        int base = input.nextInt();
        System.out.println("How many cellular automata should be generated?");
        int automatanum = input.nextInt();
        for (int l = 0; l < automatanum; l++) {
            System.out.println("\n[" + l + "]");
            xorcaii(length, base);
        }
        input.close();
    }
}
