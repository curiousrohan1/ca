package MusicGen;

import java.util.List;

public class Action {
    private final char operator;//+
    private final int idx;//1

    public Action(String com) {
        operator = com.charAt(0);
        idx = com.charAt(1) - '0';
    }

    public int execute(int running, List<Integer> past) {//5,(1,2,4,5)
        int operand = past.get(past.size() - 1 - idx);
        switch (operator) {
            case '+': {
                running += operand;
                break;
            }
            case '-': {
                running -= operand;
                break;
            }
            case '*': {
                running *= operand;
                break;
            }
            case '/': {
                running /= operand;
                break;
            }
            case '^': {
                running = (int) (Math.pow(running, operand));
                break;
            }
            default: {
                System.err.println("You entered " + operator + " as an operator, but it's not.");
                break;
            }
        }
        return running;
    }
}



