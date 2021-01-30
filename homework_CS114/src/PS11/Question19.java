package PS11;

import java.util.ArrayList;
import java.util.List;

public class Question19 {
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
            if (actorRecordList.size() == 10000)
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
                    if (!actorsGraph.isEdge(actorList.get(j), actorList.get(i))) {
                        actorsGraph.setEdge(actorList.get(i), actorList.get(j), 1);
                        actorsGraph.setEdge(actorList.get(j), actorList.get(i), 1);
                    }
                }
            }
        }

        return actorsGraph.e();
    }

    public static void main(String[] args) throws Exception {
        Question19 connectionFinder = new Question19();
        BST<String, List<Integer>> filmToActorDict = new BST<>();
        ArrayList<ActorRecord> actorRecordList = new ArrayList<>();
        String actressFname = "C:/Users/DangHuynh/Downloads/NJIT Fall 2020/CS 114/PS 11/actresses.list.gz";
        connectionFinder.readActorRecordList(actressFname, actorRecordList, filmToActorDict);
        System.out.println(connectionFinder.createActorGraph(filmToActorDict, actorRecordList.size()));
    }
}
