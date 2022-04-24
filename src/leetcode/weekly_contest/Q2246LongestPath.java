package leetcode.weekly_contest;

import org.w3c.dom.NodeList;

import java.util.*;

public class Q2246LongestPath {

    class Node{
        public Node parent;
        public ArrayList<Node> children;
        public Character myCharacter;
        public Integer longestPath;

        public Integer findLongestPath(){
            if (longestPath != null){
                return longestPath;
            } else {
                longestPath = 1;
                ArrayList<Integer> availablePath = new ArrayList<>();
                availablePath.add(0);
                availablePath.add(0);
                children.forEach((node -> {
                    var childLongest = node.findLongestPath();
                    if (node.myCharacter != myCharacter){
                        availablePath.add(childLongest);
                    }
                }));
                var max1 = Collections.max(availablePath);
                availablePath.remove(max1);
                var max2 = Collections.max(availablePath);
                longestPath = longestPath + max2 + max1;
                return longestPath;

            }
        }
        public Node(Node parent, Character myCharacter){
            this.parent = parent;
            children = new ArrayList<Node>();
            this.myCharacter = myCharacter;
        }
        public Node(){
            children = new ArrayList<Node>();
        }

    }

    public int longestPath(int[] parent, String s) {
        var length = parent.length;
        Node[] nodeArray = new Node[length];



        for (int i = 1; i < parent.length; i++) {
            if (nodeArray[i] == null){
                nodeArray[i] = new Node();
            }
            if (nodeArray[parent[i]] == null){
                nodeArray[parent[i]] = new Node();
            }
            nodeArray[i].myCharacter = s.charAt(i);
            nodeArray[i].parent = nodeArray[parent[i]];
            nodeArray[parent[i]].children.add(nodeArray[i]);
        }

        var path = nodeArray[0].findLongestPath();
        List<Node> nodeList = Arrays.asList(nodeArray);
        return Collections.max(nodeList, Comparator.comparing((Node a) -> a.longestPath)).longestPath;
    }

    private int findMax(ArrayList<Integer> arrayList) {
        return Collections.max(arrayList);

    }


}
