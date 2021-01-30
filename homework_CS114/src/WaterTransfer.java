import java.util.*;

public class WaterTransfer {

    public static void main(String[] args) {

        ArrayDeque<State> dq = new ArrayDeque<>();
        ArrayDeque<State> seq = new ArrayDeque<>();
        ArrayList<State> visited = new ArrayList<>();

        // Get the input values.
        Scanner scan = new Scanner(System.in);
        int[] cap = new int[3];

        // Put the input values to an array.
        for (int i = 0; i < 3; ++i) {
            cap[i] = scan.nextInt();
        }

        // Get the last input.
        int d = scan.nextInt();

        //initialize State
        State startStep = new State(cap);
        State.setCapacities(cap);
        visited.add(startStep);

        // enqueue
        dq.addFirst(startStep);

        // add to list
        visited.add(startStep);

        while(!dq.isEmpty()) {

            State nextStep = dq.removeFirst(); // dequeue

            if (nextStep.reachFinal(d)) {
                for (State x = nextStep; x != null; x = x.pred)
                    seq.offerLast(x);
                State s = seq.pollLast();
                while(s != null) {
                    s.display();
                    s = seq.pollLast();
                }
                break;
            }

            for(int i = 0; i <= 2; i++)
                for(int j = 0; j <= 2; j++) {

                    if (i == 0 && j == 0)
                        continue;

                    State p = nextStep.move(i, j);

                    if (p == null || visited.contains(p))
                        continue;

                    visited.add(p);
                    dq.addLast(p);


                }

        }
    }
}


class State {
    static int[] capacities;
    int[] contents;
    State pred; // predecessor state

    static void setCapacities(int[] c) {
        capacities = c;
    }

    State(int[] c) {
        contents = new int[3];
        contents[0] = c[0];
        contents[1] = 0;
        contents[2] = 0;
    }

    public State(State state) {
        contents = new int[3];
        contents[0] = state.contents[0];
        contents[1] = state.contents[1];
        contents[2] = state.contents[2];
    }


    State move(int src, int dest) {
        State newStateElements = new State(this);

        if((contents[src] == 0) || (contents[dest] == capacities[dest])==true)
            return null; // Checks if source is empty or if destination is full
        else{

            int diff = capacities[dest] - newStateElements.contents[dest];

            if(newStateElements.contents[src] >= diff) {    // if SOURCE is greater than DEST
                newStateElements.contents[dest] += diff;    // fills up destination jug
                newStateElements.contents[src] -= diff;       // subtracts fill_up from source jug
            }
            else {// else SOURCE is less than DEST
                if(newStateElements.contents[dest] + newStateElements.contents[src] > capacities[dest])
                    return null;
                newStateElements.contents[dest] += newStateElements.contents[src];
                newStateElements.contents[src] = 0;
            }
        }
        newStateElements.pred = this;
        return newStateElements;
    }

    boolean reachFinal(int d) {
        return(contents[0] == d || contents[1] == d || contents[2] == d);
    }

    void display() {
        System.out.println(contents[0] + " " + contents[1] + " " + contents[2]);
    }

}
