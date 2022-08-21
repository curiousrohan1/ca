import java.util.Random;

/**
 * Util
 */
public class Util {
    static Random randgen = new Random(System.currentTimeMillis());

    // prerequisite: bin1 and bin2 have the same length
    public static String xor(String bin1, String bin2) {
        String xorString = "";
        for (int i = 0; i < bin1.length(); i++) {
            if (bin1.charAt(i) == bin2.charAt(i)) {
                xorString += '0';
            } else {
                xorString += '1';
            }
        }
        return xorString;
    }

    public static int[] genRandomCells(int length, int base) {
        if (base < 2) {
            base = 2;
        }
        int[] cells = new int[length];
        for (int i = 0; i < length; i++) {
            cells[i] = randgen.nextInt(base);
        }
        return cells;
    }

    public static int[] genSymCells(int length, int base) {
        if (base < 2) {
            base = 2;
        }
        if (length % 2 == 1) {
            length++;
        }
        int[] cells = new int[length];
        for (int j = 0; j < length; j++) {
            cells[j] = 0;
        }
        cells[length / 2] = base - 1;
        cells[length / 2 - 1] = base - 1;
        for (int i = 1; i < base && i < length / 2; i++) {
            cells[length / 2 + i] = base - (i + 1);
            cells[length / 2 - 1 - i] = base - (i + 1);
        }
        return cells;
    }

    public static void draw(int[] cells, int base) {
        String charmap = " *~!@#$%^&()_+{}:\"|<>?`-=[];\'\\,./";
        for (int i = 0; i < cells.length; i++) {
            while (cells[i] < 0) {
                cells[i] += base;
            }
            if (cells[i] > charmap.length()) {
                System.err.println("You fool. You've doomed us all! This cell's value is " + cells[i]
                        + ". Does that look like it is between 0 and " + charmap.length() + "(inclusive) to you?");
            } else {
                System.out.print(charmap.charAt(cells[i]));
            }
        }
        System.out.println("");
    }

    public static String baseConversion(String number, int sBase, int dBase) {
        return Integer.toString(Integer.parseInt(number, sBase), dBase);
    }

    public static char xor(char bin1, char bin2) {
        if (bin1 == bin2) {
            return '0';
        } else {
            return '1';
        }
    }

    public static int[] genAlternCells(int length, int base) {
        if (base < 2) {
            base = 2;
        }
        int[] cells = new int[length];
        for (int i = 0; i < length; i++) {
            cells[i] = i % base;
        }
        return cells;
    }
}