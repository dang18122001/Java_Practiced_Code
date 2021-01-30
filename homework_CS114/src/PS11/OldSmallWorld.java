package PS11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class OldSmallWorld {
    public ArrayList<ActorRecord> readActorRecordList(String fname) throws Exception {
        RetrieveActors retriever = new RetrieveActors(fname);

        ArrayList<ActorRecord> actorRecordList = new ArrayList<>();
        String content;
        long start = System.currentTimeMillis();

        // Read in the actress records, filtering out some.

        while ((content = retriever.getNext()) != null) {
            String[] tkn = content.split("@@@");
            ActorRecord ar = new ActorRecord(tkn[0]);
            for (int i = 1; i < tkn.length; ++i) {
                if (tkn[i].startsWith("FM")) // only keep tv series
                    ar.addMovie(tkn[i].substring(2));
            }
            actorRecordList.add(ar);
        }
        retriever.close();
        long end = System.currentTimeMillis();
        System.out.println("Read in " + actorRecordList.size() + " actors in time " + (end - start) + " msec.");
        return actorRecordList;
    }

    public Graphl createActorGraph(ArrayList<ActorRecord> actorRecordList) {
        Graphl actorsGraph = new Graphl(actorRecordList.size());

        for (int i = 0; i < actorRecordList.size(); i++) {
            for (int j = i + 1; j < actorRecordList.size(); j++) {
                for (String movie: actorRecordList.get(i).movies) {
                    if (actorRecordList.get(j).appearedIn(movie)) {
                        actorsGraph.setEdge(i, j, actorsGraph.weight(i, j) + 1);
                        actorsGraph.setEdge(j, i, actorsGraph.weight(j, i) + 1);
                    }
                }
            }
        }
        return actorsGraph;
    }

    public List<Integer> searchPath(Graphl actorGraph, int scr, int dest) {
        int[] predecessors = new int[actorGraph.n()];
        boolean[] visited = new boolean[actorGraph.n()];

        LinkedList<Integer> queue = new LinkedList<>();
        visited[scr] = true;
        predecessors[scr] = -1;
        queue.add(scr);
        boolean isFound = false;

        graphTraversal:
        while (queue.size() != 0) {
            Integer s = queue.poll();

            Iterable<Integer> iterable = actorGraph.neighbors(s);
            for (Integer i : iterable) {
                if (!visited[i]) {
                    visited[i] = true;
                    predecessors[i] = s;
                    queue.add(i);
                }
                if (i == dest) {
                    isFound = true;
                    break graphTraversal;
                }
            }
        }

        List<Integer> path = new LinkedList<>();
        if (isFound) {
            int temp = dest;
            path.add(temp);
            while (predecessors[temp] != -1) {
                path.add(predecessors[temp]);
                temp = predecessors[temp];
            }
        }
        return path;
    }

    public void printActorsChain(ArrayList<ActorRecord> actorRecordList, List<Integer> path, int scr, int dest) {
        if (path.size() == 0)
            System.out.println("No path between " + actorRecordList.get(scr).name + " and " + actorRecordList.get(dest).name);
        else {
            System.out.println("Shortest path between " + actorRecordList.get(scr).name + " and " + actorRecordList.get(dest).name);
            int distance = path.size() - 1;
            System.out.println("Distance: " + distance + "; the chain is: ");
            for (int i = path.size() - 1; i > 0; i--)
                for (String movie: actorRecordList.get(path.get(i)).movies)
                    if (actorRecordList.get(path.get(i-1)).appearedIn(movie)) {
                        System.out.println(actorRecordList.get(path.get(i)).name + " appeared with " +
                                actorRecordList.get(path.get(i-1)).name + " in " + movie);
                        break;
                    }
        }
    }

    public static void main (String[] args) throws Exception {
        long start = System.currentTimeMillis();

        System.out.println("Enter source and destination indices:");
        Scanner scan = new Scanner(System.in);
        int scr = scan.nextInt();
        int dest = scan.nextInt();

        String fname = "C:/Users/DangHuynh/Downloads/NJIT Fall 2020/CS 114/PS 11/shortestActors.list.gz";
//        String fname = System.getenv("LIB")+"/public/shortestActors.list.gz";
//        String fname = "C:/Users/DangHuynh/Downloads/NJIT Fall 2020/CS 114/PS 11/actresses.list.gz";

        OldSmallWorld connectionFinder = new OldSmallWorld();
        ArrayList<ActorRecord> actorRecordList = connectionFinder.readActorRecordList(fname);

        Graphl actorGraph = connectionFinder.createActorGraph(actorRecordList);

        List<Integer> path = connectionFinder.searchPath(actorGraph, scr, dest);

        connectionFinder.printActorsChain(actorRecordList, path, scr, dest);

        long end = System.currentTimeMillis();
        System.out.println("Run in: " + (end - start));
    }
}
