import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Graph {
    /*
     * This is the graph class where the given graph configuration is initialized.
     * Used a HashMap to store a node and its
     * neighbours as a adjacency list.
     */
    HashMap<Character, List<Character>> adjList;

    public Graph() {
        this.adjList = new HashMap<>();
        adjList.put('S', new ArrayList<>(Arrays.asList('B', 'C')));
        adjList.put('B', new ArrayList<>(Arrays.asList('D', 'E')));
        adjList.put('C', new ArrayList<>(Arrays.asList('F')));
        adjList.put('D', new ArrayList<>(Arrays.asList('H')));
        adjList.put('E', new ArrayList<>(Arrays.asList('G', 'I')));
        adjList.put('F', new ArrayList<>(Arrays.asList('J')));
    }
}