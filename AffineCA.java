import java.util.*;

public class AffineCA {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How long should each line be?");
        int length = input.nextInt();
        System.out.println("How many cellular automata should be generated?");
        int automatanum = input.nextInt();
        System.out.println("What base?");
        int base = input.nextInt();
        for (int l = 0; l < automatanum; l++) {
            affineCA(length, base);
        }
        input.close();
    }

    public static void affineCA(int length, int base) {
        int[] cells = Util.genSymCells(length, base);
        Util.draw(cells, base);
        int[] nextgen = new int[length];
        for (int j = 0; j < length; j++) {
            for (int i = 0; i < length - 3; i++) {
                int[] hood = new int[3];
                for (int k = 0; k < 3; k++) {
                    hood[k] = cells[i + k];
                }
                nextgen[i] = (hood[2] * hood[1] + hood[0]) % base;
                while (nextgen[i] < 0) {
                    nextgen[i] += base;
                }
            }
            cells = nextgen;
            Util.draw(cells, base);
        }
    }
}
