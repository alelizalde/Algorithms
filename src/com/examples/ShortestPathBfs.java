package com.examples;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ShortestPathBfs {

	public static List<String> shortestPathBfs(Map<String, String[]> graph, String startNode, String endNode) {

	    if (!graph.containsKey(startNode)) {
	        throw new IllegalArgumentException("Start node not in graph");
	    }
	    
	    if (!graph.containsKey(endNode)) {
	        throw new IllegalArgumentException("End node not in graph");
	    }
	    
		List<String> result = new ArrayList<String>();
		Queue<String> nodesToVisit = new ArrayDeque<String>();
		nodesToVisit.add(startNode);

		// keep track of what nodes we've already seen so
		// we don't process them twice
		Set<String> nodesAlreadySeen = new HashSet<String>();
		nodesAlreadySeen.add(startNode);

		Map<String, String> howWeReachedNodes = new HashMap<>();
		howWeReachedNodes.put(startNode, null);


		while (!nodesToVisit.isEmpty()) {
			String currentNode = nodesToVisit.remove();

			// stop when we reach the end node
			if (currentNode.equals(endNode)) {
				// found it!
				String PathNode =endNode;
				while(PathNode!=null) {
					result.add(PathNode);
					PathNode=howWeReachedNodes.get(PathNode);
				}
				return result;
			}

			if(graph.containsKey(currentNode)) {
				for (String neighbor: graph.get(currentNode)) {
					if (!nodesAlreadySeen.contains(neighbor)) {
						nodesAlreadySeen.add(neighbor);
						nodesToVisit.add(neighbor);
						howWeReachedNodes.put(neighbor, currentNode);
					}
				}
			}else {
				nodesAlreadySeen.add(currentNode);
			}
		}
		return result;
	}

	public static void main(String[] args) {

		HashMap<String,String[]> network = new HashMap<String,String[]>();

		network.put("Min",new String[] {"William", "Jayden", "Omar"});
		network.put("William",new String[] {"Min", "Noam"});
		network.put("Jayden",new String[] {"Min", "Amelia", "Ren", "Noam"});
		network.put("Ren",new String[] {"Jayden", "Omar"});
		network.put("Amelia",new String[] {"Jayden", "Adam", "Miguel"});
		network.put("Adam",new String[] {"Amelia", "Miguel", "Sofia", "Lucas"});
		network.put("Miguel",new String[] {"Amelia", "Adam", "Liam", "Nathan"});

		System.out.println(shortestPathBfs(network,"Min","Min"));

	}

}
