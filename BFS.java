import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {

        Graph graph = new Graph(); // Creating the Graph object.
        List<Character> path = new ArrayList<>(); // To store the path from source to destination.

        System.out.println("Performing path search with Breadth First Search	");
        path = SearchNodes.search_with_bfs(graph, 'S', 'G');
        System.out.println("The path from source to destination is below ");

        // Printing the path found using BFS.
        for (int i = 0; i < path.size(); i++) {
            if (i == path.size() - 1)
                System.out.print(path.get(i));
            else
                System.out.print(path.get(i) + "-->");
        }
    }

    public class SearchNodes {
        /*
         * Function to find whether a node is already present in the path.
         * Used as a helper function in the search_with_bfs function
         */
        public static boolean isVisited(Character ch, List<Character> path) {
            for (Character curr_ch : path) {
                if (curr_ch == ch)
                    return true;
            }
            return false;
        }

        /*
         *
         * Function to perform Breadth First Search and find the path from Source to
         * destination.
         * Accepts Graph, source, destination as input.
         * This function finally returns the path as a List.
         */
        public static List<Character> search_with_bfs(Graph graph, Character source, Character destination) {
            Queue<List<Character>> queue = new LinkedList<>(); // To maintain the paths to be visited
            List<Character> path = new ArrayList<>();
            path.add(source);
            queue.add(path);

            while (!queue.isEmpty()) {
                path = queue.remove();
                Character lst_node = path.get(path.size() - 1); // Getting the last node in the current path.
                if (lst_node == destination)
                    return path; // If the last equals destination, return the current path.
                System.out.println("Exploring node " + lst_node);
                
                List<Character> neighbours = graph.adjList.getOrDefault(lst_node, new ArrayList<>()); // Explore paths with the neighbours of last node added.

                for (Character ch : neighbours) {
                    if (isVisited(ch, path))
                        continue;
                    List<Character> new_path = new ArrayList<>(path);
                    new_path.add(ch);
                    queue.add(new_path);
                }
            }
            return new ArrayList<>();
        }
    }
}