package MusicGen;


import java.util.ArrayList;

public class MusicGenerator {
    static ArrayList<Integer> nums = new ArrayList<>();

    public static void main(String[] args) {
        Algorithm alg = new Algorithm();
        int[] input = Util.askIntArr("Please input some notes in their number form.");
        int numNotes = Util.askInt("How many notes do you want to generate?");
        for (int note : input) {
            nums.add(note);
        }
        for (int i = input.length; i < numNotes; i++) {
            int num = alg.run(nums);
            num %= 37;
            while (num < 0) {
                num += 37;
            }
            nums.add(num);
        }
        for (int i1 = 0; i1 < nums.size(); i1++) {
            Note note = new Note(nums.get(i1));
            System.out.println(note);
            if (i1 % 4 == 3) {
                System.out.println();
            }
        }
        System.out.println();
    }
}
//1,2,4,5,