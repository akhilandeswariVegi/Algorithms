package coloring;

import java.util.*;

public class Main {

    public static Map<Integer,String> getColorMap(){
        Map<Integer,String> colorMap = new HashMap<>();
        colorMap.put(1,"Red");
        colorMap.put(2,"Green");
        colorMap.put(3,"Blue");
        colorMap.put(4,"White");
        colorMap.put(5,"Black");
        colorMap.put(6,"Magenta");
        colorMap.put(7,"Cyan");
        colorMap.put(8,"Orange");

        return colorMap;

    }


    // Greedy Coloring Algorithm to find the minimum number of colors required
    public static Map<String, Integer> greedyGraphColoring(Map<String, List<String>> adjList) {
        Map<String, Integer> colors = new HashMap<>();  // Map to store the color of each vertex

        // Iterate through each vertex in the graph
        for (String vertex : adjList.keySet()) {


            Set<Integer> availableColors = new HashSet<>(); //set to store the available colors for the current vertex
            for (int i = 1; i <= adjList.size(); i++) {
                availableColors.add(i);
            }

            for (String neighbor : adjList.get(vertex)) {   //Now, remove the available colors if neighbouring node is already using the same color
                if (colors.containsKey(neighbor)) {
                    availableColors.remove(colors.get(neighbor));
                }
            }

            // If there are available colors, choose the smallest one; otherwise, next highest color
            if (!availableColors.isEmpty()) {
                int color = Collections.min(availableColors);
                colors.put(vertex, color);
            } else {
                int newColor = Collections.max(colors.values()) + 1;
                colors.put(vertex, newColor);
            }
        }
        return colors;
    }

    public static void main(String[] args) {
        Graph graph = new Graph();  //Creating the Graph object.
        System.out.println("No.of counties in the given Map: " + graph.adjList.size());
        Map<Integer,String> colorMap = getColorMap();
        Map<String, Integer> colors = greedyGraphColoring(graph.adjList);
        System.out.println("Minimum no.of colors required such that no two adjacent counties have same color is: " + Collections.max(colors.values()));

        System.out.println("Printing assigned colors:");
        System.out.println("#################################");
        System.out.println("County ------> color");
        System.out.println("#################################");

        for(Map.Entry<String, Integer> entry : colors.entrySet()){
            System.out.println(entry.getKey() + " ------> " + colorMap.get(entry.getValue()));
        }
        
    }

}
