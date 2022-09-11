package MusicGen;

import java.util.Scanner;

public class Util {
    static Scanner input = new Scanner(System.in);

    public static int askInt(String question) {
        System.out.println(question);
        return input.nextInt();
    }

    public static int[] askIntArr(String question) {
        int size = askInt("How many numbers are you inputting?");
        int[] responses = new int[size];
        System.out.println(question);
        for (int i = 0; i < size; i++) {
            responses[i] = input.nextInt();
        }
        return responses;
    }


    public static String ask(String question) {
        System.out.println(question);
        return input.nextLine();
    }


}