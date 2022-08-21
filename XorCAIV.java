import java.util.Scanner;

public class XorCAIV {
    public static void xorcaiv(int length, int base) {
        int[] cells = Util.genRandomCells(length, base);
        Util.draw(cells, base);
        int[] nextgen = new int[length];
        for (int j = 0; j < length; j++) {
            for (int i = 0; i < length - 1; i++) {
                int[] hood = new int[2];
                hood[0] = cells[i];
                hood[1] = cells[i + 1];
                nextgen[i] = (hood[0] - hood[1] )   % base;
            }
            cells = nextgen;
            Util.draw(cells, base);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How long should each line be?");
        int length = input.nextInt();
        System.out.println("How many cellular automata should be generated?");
        int automatanum = input.nextInt();
        System.out.println("What base?");
        int base = input.nextInt();
        for (int l = 0; l < automatanum; l++) {
            System.out.println("\n[" + l + "]");
            xorcaiv(length, base);
        }
        input.close();
    }
}
