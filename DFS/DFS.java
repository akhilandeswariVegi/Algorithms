import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DFS {
    public static void main(String[] args) {

        Graph graph = new Graph(); // Creating the Graph object.
        List<Character> path = new ArrayList<>(); // To store the path from source to destination.

        System.out.println("Performing path search with Depth First Search	");
        SearchNodes.search_with_dfs(graph, 'S', 'G', path, new HashSet<>());
        System.out.println("The path from source to destination is below");

        // Printing the path found using DFS.
        for (int i = 0; i < path.size(); i++) {
            if (i == path.size() - 1)
                System.out.println(path.get(i));
            else
                System.out.print(path.get(i) + "->");
        }
    }

    public class SearchNodes {
        /*
         * Function to perform Depth First Search and find the path from Source to
         * destination.
         * Accepts Graph, source, destination, current path, set of visited nodes as
         * input.
         * This function finally stores the path in the variable called path and returns
         * boolean values : True(destination is found), False(Destination not found)
         * This function is called recursively till the destination node is reached.
         */
        public static boolean search_with_dfs(Graph graph, Character source, Character destination,
                List<Character> path, HashSet<Character> visited) {
            path.add(source); // adding the source to path.
            if (source == destination)
                return true;
            System.out.println("Exploring node " + source);
            visited.add(source);
            List<Character> neighbours = graph.adjList.getOrDefault(source, new ArrayList<>());
            // getting the neighbouring nodes of the source.

            for (int i = 0; i < neighbours.size(); i++) {
                if (!visited.contains(neighbours.get(i))
                        && search_with_dfs(graph, neighbours.get(i), destination, path, visited))
                    return true; // calling the function recursively.
            }

            path.remove(path.size() - 1); // removing the current node from path if the destination is not found
            return false;
        }
    }
}