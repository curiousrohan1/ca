package MusicGen;

public class Note {
    static String[] strings = {"E", "E", "E", "E", "E", "A", "A", "A", "A", "A", "D", "D", "D", "D", "D", "G", "G", "G", "G", "B", "B", "B", "B", "B", "HighE", "HighE", "HighE", "HighE", "HighE", "HighE", "HighE", "HighE", "HighE", "HighE", "HighE", "HighE", "HighE"};
    static int[] frets = {0, 1, 2, 3, 4, 0, 1, 2, 3, 4, 0, 1, 2, 3, 4, 0, 1, 2, 3, 0, 1, 2, 3, 4, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    private final String string;
    private final int fret;
    private int numDes;


    public Note(String notation) {//String[Fret](Name)
        string = notation.substring(0, 1);
        fret = notation.charAt(2) - '0';
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals(string) && frets[i] == fret) {
                numDes = i;
            }
        }
    }

    public Note(int num) {
        string = strings[num];
        fret = frets[num];
        numDes = num;
    }


    public String toString() {
        return string + "[" + fret + "]{" + numDes + "}";
    }
}