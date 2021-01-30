package PS11;

import java.util.*;

public class Question21 {
    public void readActorRecordList(String fname, ArrayList<ActorRecord> actorRecordList,
                                    BST<String, List<Integer>> filmToActorDict) throws Exception {
        RetrieveActors retriever = new RetrieveActors(fname);

        String content;

        // Read in the actress records, filtering out some.
        int actorIndex = 0;
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
            if (actorRecordList.size() == 120000)
                break;
            actorIndex++;
        }
        retriever.close();
    }

    public int createActorGraph(BST<String, List<Integer>> filmToActorDict, int graphSize) {
        Graphl actorsGraph = new Graphl(graphSize);
        for (List<Integer> actorList: filmToActorDict.values()) {
            for (int i = 0; i < actorList.size() - 1; i++) {
                for (int j = i + 1; j < actorList.size(); j++) {
                    if (!actorsGraph.isEdge(actorList.get(i), actorList.get(j)))
                        actorsGraph.setEdge(actorList.get(i), actorList.get(j), 1);
                    if (!actorsGraph.isEdge(actorList.get(j), actorList.get(i)))
                        actorsGraph.setEdge(actorList.get(j), actorList.get(i), 1);
                }
            }
        }

        Iterable<Integer> iterable = actorsGraph.neighbors(0);
        int ans = 0;
        for (Integer i: iterable)
            ans++;

        return ans;
    }

    public int maxPath(Graphl actorGraph) {
        int[] dis = new int[actorGraph.n()];

        // mark all distance with -1
        Arrays.fill(dis, -1);

        Queue<Integer> q = new LinkedList<>();

        q.add(0);

        // distance of u from u will be 0
        dis[0] = 0;
        while (!q.isEmpty()) {
            int t = q.poll();

            // loop for all adjacent nodes of node-t
            Iterable<Integer> iterable = actorGraph.neighbors(t);
            for(Integer v: iterable) {
                // push node into queue only if
                // it is not visited already
                if(dis[v] == -1) {
                    q.add(v);
                    // make distance of v, one more
                    // than distance of t
                    dis[v] = dis[t] + 1;
                }
            }
        }

        int maxDis = 0;

        // get farthest node distance and its index
        for(int i = 0; i < actorGraph.n(); ++i) {
            if(dis[i] > maxDis) {
                maxDis = dis[i];
            }
        }
        return maxDis;
    }

    public static void main(String[] args) throws Exception {
        Question21 connectionFinder = new Question21();
        BST<String, List<Integer>> filmToActorDict = new BST<>();
        ArrayList<ActorRecord> actorRecordList = new ArrayList<>();
        String actressFname = "C:/Users/DangHuynh/Downloads/NJIT Fall 2020/CS 114/PS 11/actresses.list.gz";
        connectionFinder.readActorRecordList(actressFname, actorRecordList, filmToActorDict);
        System.out.println(connectionFinder.createActorGraph(filmToActorDict, actorRecordList.size()));
    }
}
