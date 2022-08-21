import java.util.Scanner;

public class XorCAIII {
    public static void xorcaiii(int length, int base) {
        int[][] automaton = new int[length][length];
        automaton[0] = Util.genRandomCells(length, base);
        Util.draw(automaton[0], base);
        int[] nextgen = new int[length];
        for (int j = 1; j < length; j++) {
            for (int i = 1; i < length - 1; i++) {
                int sum = 0;
                for (int k = 0; k < 3; k++) {
                    sum += automaton[j - 1][i - 1 + k];
                }
                if (j > 1) {
                    sum += automaton[j - 2][i];
                }
                nextgen[i] = sum % base;
            }
            Util.draw(nextgen, base);
            automaton[j] = nextgen;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many cellular automata should be generated?");
        int automatanum = input.nextInt();
        for (int l = 0; l < automatanum; l++) {
            System.out.println("\n[" + l + "]");
            System.out.println("How long should each line be?");
            int length = input.nextInt();
            System.out.println("What's the base?");
            int base = input.nextInt();
            xorcaiii(length, base);
        }
        input.close();
    }
}
