package MusicGen;

import java.util.ArrayList;
import java.util.List;

public class Algorithm {
    private final List<Action> actions;//+1,+2

    public Algorithm() {
        actions = new ArrayList<>();
        String response = Util.ask("Add command.");
        for (int i = 0; i < response.length(); i += 2) {
            actions.add(new Action(response.substring(i, i + 2)));
        }
    }


    public int run(List<Integer> text) {//1,2,4,5
        int running = text.get(text.size() - 1);//5
        for (Action act : actions) {
            running = act.execute(running, text);
        }
        return running;
    }
}
//1,2,4,5