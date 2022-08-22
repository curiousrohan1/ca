package MusicGen;

import java.util.List;

public class Chord {
    private List<Note> notes;
    private int numDes;

    public Chord(List<Note> notes) {
        this.notes = notes;
    }

    public Chord(String name) {
        switch (name) {
            case "A": {
                notes.add(new Note("A[0]"));
                notes.add(new Note("D[2]"));
                notes.add(new Note("G[2]"));
                notes.add(new Note("B[2]"));
                notes.add(new Note("HighE[0]"));
                numDes = 0;
                break;
            }
            case "Am": {
                notes.add(new Note("A[0]"));
                notes.add(new Note("D[2]"));
                notes.add(new Note("G[2]"));
                notes.add(new Note("B[1]"));
                notes.add(new Note("HighE[0]"));
                numDes = 1;
                break;
            }
            case "B": {
                notes.add(new Note("A[2]"));
                notes.add(new Note("D[4]"));
                notes.add(new Note("G[4]"));
                notes.add(new Note("B[4]"));
                notes.add(new Note("HighE[2]"));
                numDes = 2;
                break;
            }
            case "Bm": {
                notes.add(new Note("A[2]"));
                notes.add(new Note("D[4]"));
                notes.add(new Note("G[4]"));
                notes.add(new Note("B[3]"));
                notes.add(new Note("HighE[2]"));
                numDes = 3;
                break;
            }

            case "C": {
                notes.add(new Note("A[3]"));
                notes.add(new Note("D[2]"));
                notes.add(new Note("G[0]"));
                notes.add(new Note("B[1]"));
                notes.add(new Note("HighE[0]"));
                numDes = 4;
                break;
            }
            case "Cm": {
                notes.add(new Note("A[3]"));
                notes.add(new Note("D[5]"));
                notes.add(new Note("G[5]"));
                notes.add(new Note("B[4]"));
                notes.add(new Note("HighE[3]"));
                numDes = 5;
                break;
            }
            case "D": {
                notes.add(new Note("D[0]"));
                notes.add(new Note("G[2]"));
                notes.add(new Note("B[3]"));
                notes.add(new Note("HighE[2]"));
                numDes = 6;
                break;
            }
            case "Dm": {
                notes.add(new Note("D[0]"));
                notes.add(new Note("G[2]"));
                notes.add(new Note("B[3]"));
                notes.add(new Note("HighE[1]"));
                numDes = 7;
                break;
            }
            case "E": {
                notes.add(new Note("E[0]"));
                notes.add(new Note("A[2]"));
                notes.add(new Note("D[2]"));
                notes.add(new Note("G[1]"));
                notes.add(new Note("B[0]"));
                notes.add(new Note("HighE[0]"));
                numDes = 8;
                break;
            }
            case "Em": {
                notes.add(new Note("E[0]"));
                notes.add(new Note("A[2]"));
                notes.add(new Note("D[2]"));
                notes.add(new Note("G[0]"));
                notes.add(new Note("B[0]"));
                notes.add(new Note("HighE[0]"));
                numDes = 9;
                break;
            }
            case "F": {
                notes.add(new Note("E[1]"));
                notes.add(new Note("A[3]"));
                notes.add(new Note("D[3]"));
                notes.add(new Note("G[2]"));
                notes.add(new Note("B[1]"));
                notes.add(new Note("HighE[1]"));
                numDes = 10;
                break;
            }
            case "Fm": {
                notes.add(new Note("E[1]"));
                notes.add(new Note("A[3]"));
                notes.add(new Note("D[3]"));
                notes.add(new Note("G[1]"));
                notes.add(new Note("B[1]"));
                notes.add(new Note("HighE[1]"));
                numDes = 11;
                break;
            }
            case "G": {
                notes.add(new Note("E[3]"));
                notes.add(new Note("A[2]"));
                notes.add(new Note("D[0]"));
                notes.add(new Note("G[0]"));
                notes.add(new Note("B[0]"));
                notes.add(new Note("HighE[3]"));
                numDes = 12;
                break;
            }
            case "Gm": {
                notes.add(new Note("E[3]"));
                notes.add(new Note("A[5]"));
                notes.add(new Note("D[5]"));
                notes.add(new Note("G[3]"));
                notes.add(new Note("B[3]"));
                notes.add(new Note("HighE[3]"));
                numDes = 13;
                break;
            }
        }
    }

    public String toString() {
        StringBuilder stringForm = new StringBuilder();
        for (Note note :
                notes) {
            stringForm.append(note.toString()).append(", ");
        }
        return stringForm.toString();
    }

    public int getNumDes() {
        return numDes;
    }

}
