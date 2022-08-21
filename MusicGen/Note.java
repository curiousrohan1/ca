package MusicGen;

public class Note {
    private String string;
    private String name;
    private int fret;
    private int numDes;
    static String[] strings = { "E", "E", "E", "A", "A", "A", "D", "D", "D", "G", "G", "B", "B", "B", "HighE", "HighE",
            "HighE", "HighE", "HighE", "HighE", "HighE", "HighE" };
    static String[] names = { "LowMi", "LowFi", "LowSol", "LowLa", "LowTi", "LowDo", "LowRe", "Mi", "Fi", "Sol", "La",
            "Ti", "Do", "Re", "HighMi", "HighFi", "HighSol", "HighLa", "HighTi", "HighDo", "HighRe", "UberMi" };
    static int[] frets = { 0, 1, 3, 0, 2, 3, 0, 2, 3, 0, 2, 0, 1, 3, 0, 1, 3, 5, 7, 8, 10, 12 };

    public Note(String notation) {
        string = notation.substring(0, 1);
        fret = notation.charAt(2) - '0';
        name = notation.substring(5, notation.lastIndexOf(')'));
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(name)) {
                numDes = i;
            }
        }
    }

    public Note(int num) {
        string = strings[num];
        name = names[num];
        fret = frets[num];
        numDes = num;
    }

    public int getFret() {
        return fret;
    }

    public void setFret(int fret) {
        this.fret = fret;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public String toString() {
        return string + "[" + fret + "](" + name + ")" + "{" + numDes + "}";
    }
}