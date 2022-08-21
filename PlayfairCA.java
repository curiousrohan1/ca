import java.util.ArrayList;
import java.util.Scanner;

public class PlayfairCA {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many cellular automata should be generated?");
        int automatanum = input.nextInt();
        for (int l = 0; l < automatanum; l++) {
            System.out.println("\n[" + l + "]");
            System.out.println("How long should each line be?");
            int length = input.nextInt();
            input.nextLine();
            System.out.println("What is the keynum?");
            String keynum = input.nextLine();
            playfairca(length, keynum);
        }
        input.close();
    }

    public static void playfairca(int length, String key) {
        if (length % 2 == 1) {
            length++;
        }
        if (key.length() > 5) {
            key = key.substring(0, 5);
        }
        int[] keynum = new int[key.length()];
        for (int i = 0; i < key.length(); i++) {
            keynum[i] = key.charAt(i) - '0';
        }
        int[][] automaton = new int[length][length];
        automaton[0] = Util.genRandomCells(length, 25);
        Util.draw(automaton[0], 25);
        for (int j = 1; j < length; j++) {
            automaton[j] = generate(automaton[j - 1], keynum);
            Util.draw(automaton[j], 25);
        }
    }

    private static int[][] getGrid(int[] hood) {
        int[][] grid = new int[5][5];
        grid[0] = hood;
        for (int i = 1; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                grid[i][j] = getNextNum(grid);
            }
        }
        return grid;
    }

    public static int[] generate(int[] row, int[] keynum) {
        int[][] grid = getGrid(keynum);
        ArrayList<Integer[]> digraphs = getDigraphs(row);
        int[] generatedRow = new int[row.length];
        for (int i = 0; i < row.length; i += 2) {
            generatedRow[i] = encryptDig(digraphs.get(i / 2), grid)[0];
            generatedRow[i + 1] = encryptDig(digraphs.get(i / 2), grid)[1];
        }
        return generatedRow;
    }

    private static int findNumRow(int[][] grid, int let) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (grid[i][j] == let) {
                    return i;
                }
            }
        }
        return -1;
    }

    private static int findNumCol(int[][] grid, int let) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (grid[i][j] == let) {
                    return j;
                }
            }
        }
        return -1;
    }

    private static int[] encryptDig(Integer[] digs, int[][] grid) {
        int one = digs[0];
        int two = digs[1];
        // for (int i = 0; i < grid.length; i++) {
        // for (int j = 0; j < grid[0].length; j++) {
        // System.out.print(grid[i][j] + " ");
        // }
        // System.out.println();
        // }
        int onerow = findNumRow(grid, one);
        int tworow = findNumRow(grid, two);
        int onecol = findNumCol(grid, one);
        int twocol = findNumCol(grid, two);
        if (onerow == tworow) {
            one = grid[onerow][(onecol + 1) % 5];
            two = grid[tworow][(twocol + 1) % 5];
        } else if (onecol == twocol) {
            one = grid[(onerow + 1) % 5][onecol];
            two = grid[(tworow + 1) % 5][twocol];
        } else {
            one = grid[onerow][twocol];
            two = grid[tworow][onecol];
        }
        int[] encrypteDig = new int[2];
        encrypteDig[0] = one;
        encrypteDig[1] = two;
        return encrypteDig;
    }

    public static ArrayList<Integer[]> getDigraphs(int[] row) {
        ArrayList<Integer[]> digraphs = new ArrayList<>();
        for (int i = 0; i < row.length; i += 2) {
            Integer[] dig = new Integer[2];
            dig[0] = row[i];
            dig[1] = row[i + 1];
            digraphs.add(dig);
        }
        return digraphs;
    }

    private static int getNextNum(int[][] grid) {
        for (int i = 0; i < 25; i++) {
            int numRow = -1;
            for (int k = 0; k < 5; k++) {
                for (int j = 0; j < 5; j++) {
                    if (grid[k][j] == i) {
                        numRow = i;
                    }
                }
            }
            if (numRow == -1) {
                return i;
            }
        }
        return -1;
    }
}
