package PS11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SmallWorld {

    public void readActorRecordList(String fname, ArrayList<ActorRecord> actorRecordList,
                                                      BST<String, List<Integer>> filmToActorDict) throws Exception {
        RetrieveActors retriever = new RetrieveActors(fname);

        String content;

        // Read in the actress records, filtering out some.
        int actorIndex = actorRecordList.size();
        while ((content = retriever.getNext()) != null) {
            String[] tkn = content.split("@@@");
            ActorRecord ar = new ActorRecord(tkn[0]);
            for (int i = 1; i < tkn.length; ++i) {
                if (tkn[i].startsWith("FM")) { // only keep tv series
                    String movieName = tkn[i].substring(2);
                    ar.addMovie(movieName);

                    List<Integer> actorNames = filmToActorDict.find(movieName);
                    if (actorNames == null) {
                        actorNames = new ArrayList<>();
                        actorNames.add(actorIndex);
                        filmToActorDict.insert(movieName, actorNames);
                    } else {
                        actorNames.add(actorIndex);
                    }
                }
            }
            actorRecordList.add(ar);
            actorIndex++;
        }
        retriever.close();
    }

    public Graphl createActorGraph(BST<String, List<Integer>> filmToActorDict, int graphSize) {
        Graphl actorsGraph = new Graphl(graphSize);
        for (List<Integer> actorList: filmToActorDict.values()) {
            for (int i = 0; i < actorList.size() - 1; i++) {
                for (int j = i + 1; j < actorList.size(); j++) {
                    actorsGraph.setEdge(actorList.get(i), actorList.get(j), 1);
                    actorsGraph.setEdge(actorList.get(j), actorList.get(i), 1);
                }
            }
        }

        return actorsGraph;
    }

    public List<Integer> searchPath(Graphl actorGraph, int scr, int dest) {
        boolean[] visited = new boolean[actorGraph.n()];

        LinkedList<Integer> queue = new LinkedList<>();
        visited[scr] = true;
        actorGraph.Mark[scr] = -1;
        queue.add(scr);
        boolean isFound = false;

        graphTraversal:
        while (queue.size() != 0) {
            Integer s = queue.poll();

            Iterable<Integer> iterable = actorGraph.neighbors(s);
            for (Integer i : iterable) {
                if (!visited[i]) {
                    visited[i] = true;
                    actorGraph.Mark[i] = s;
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
            while (actorGraph.Mark[temp] != -1) {
                path.add(actorGraph.Mark[temp]);
                temp = actorGraph.Mark[temp];
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
        SmallWorld connectionFinder = new SmallWorld();
        BST<String, List<Integer>> filmToActorDict = new BST<>();
        ArrayList<ActorRecord> actorRecordList = new ArrayList<>();
        String actressFname = "C:/Users/DangHuynh/Downloads/NJIT Fall 2020/CS 114/PS 11/actresses.list.gz";
        connectionFinder.readActorRecordList(actressFname,actorRecordList,filmToActorDict);
        Graphl actorsGraph = connectionFinder.createActorGraph(filmToActorDict, actorRecordList.size());
        List<Integer> path = connectionFinder.searchPath(actorsGraph, 700, 900);
        connectionFinder.printActorsChain(actorRecordList, path, 700, 900);
//        boolean firstTime = true;
//        SmallWorld connectionFinder = new SmallWorld();
//        BST<String, List<Integer>> filmToActorDict = new BST<>();
//        ArrayList<ActorRecord> actorRecordList = new ArrayList<>();
//        Graphl actorGraph = null;
//        while (true) {
//            long startReading = System.currentTimeMillis();
//
//            System.out.println("Enter source and destination indices:");
//            Scanner scan = new Scanner(System.in);
//            int scr = scan.nextInt();
//            int dest = scan.nextInt();
//            if (scr == 0 && dest == 0) {
//                break;
//            }
//
//            long startFinding;
//            if (firstTime) {
//                String actorFname = "C:/Users/DangHuynh/Downloads/NJIT Fall 2020/CS 114/PS 11/actors.list.gz";
//                String actressFname = "C:/Users/DangHuynh/Downloads/NJIT Fall 2020/CS 114/PS 11/actresses.list.gz";
////        String actressFname = System.getenv("LIB")+"/public/actresses.list.gz";
////        String actorFname = System.getenv("LIB")+"/public/actors.list.gz";
//
//                connectionFinder.readActorRecordList(actressFname, actorRecordList, filmToActorDict);
//                connectionFinder.readActorRecordList(actorFname, actorRecordList, filmToActorDict);
//
//                long endReading = System.currentTimeMillis();
//                System.out.println("Read in " + actorRecordList.size() + " records in time " + (endReading - startReading) + " msec.");
//
//                startFinding = System.currentTimeMillis();
//                actorGraph = connectionFinder.createActorGraph(filmToActorDict, actorRecordList.size());
//
//                firstTime = false;
//            } else {
//                startFinding = System.currentTimeMillis();
//            }
//            List<Integer> path = connectionFinder.searchPath(actorGraph, scr, dest);
//
//            connectionFinder.printActorsChain(actorRecordList, path, scr, dest);
//
//            long endFinding = System.currentTimeMillis();
//            System.out.println("Finding connection in: " + (endFinding - startFinding) + " msec.");
//        }
    }
}
