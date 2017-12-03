package com.examples;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class GraphNode {

	private String label;
	private Set<GraphNode> neighbors;
	private Optional<String> color;

	public GraphNode(String label) {
		this.label = label;
		neighbors = new HashSet<GraphNode>();
		color = Optional.empty();
	}

	public String getLabel() {
		return label;
	}

	public Set<GraphNode> getNeighbors() {
		return Collections.unmodifiableSet(neighbors);
	}

	public void addNeighbor(GraphNode neighbor) {
		neighbors.add(neighbor);
	}

	public boolean hasColor() {
		return color.isPresent();
	}

	public String getColor() {
		return color.get();
	}

	public void setColor(String color) {
		this.color = Optional.ofNullable(color);
	}

	public static void colorGraphBckUp(List<GraphNode> graph, List<String> colors) {

		
		int index = 0;
		for (GraphNode node : graph) {

	        if (node.getNeighbors().contains(node)) {
	            throw new IllegalArgumentException(String.format(
	                "Legal coloring impossible for node with loop: %s",
	                node.getLabel()));
	        }
	        
			for (GraphNode neighbor : node.getNeighbors()) {
				if(neighbor.hasColor() && colors.get(index) == neighbor.getColor()) {
					if(index>=colors.size()) {
						index=0;
					}else {
						index++;
					}
				}
			}

			node.setColor(colors.get(index));
		}
	}
	
	public static void colorGraph(List<GraphNode> graph, List<String> colors) {

		Set<String> currentColors = new HashSet<>();
		
		for (GraphNode node : graph) {

	        if (node.getNeighbors().contains(node)) {
	            throw new IllegalArgumentException(String.format(
	                "Legal coloring impossible for node with loop: %s",
	                node.getLabel()));
	        }
	        
			if(currentColors.isEmpty()) {
				for (String color : colors) {
					currentColors.add(color);
				}
			} 

			for (GraphNode neighbor : node.getNeighbors()) {
				if(neighbor.hasColor() && currentColors.contains(neighbor.getColor())) {
						currentColors.remove(neighbor.getColor());
				}
			}

			node.setColor(currentColors.iterator().next());
		}
	}

	public static void main(String args[]) {
/*		GraphNode a = new GraphNode("a");
		GraphNode b = new GraphNode("b");
		GraphNode c = new GraphNode("c");

		a.addNeighbor(b);
		b.addNeighbor(a);
		b.addNeighbor(c);
		c.addNeighbor(b);*/

		GraphNode a = new GraphNode("a");
		GraphNode b = new GraphNode("b");
		GraphNode c = new GraphNode("c");
		GraphNode d = new GraphNode("d");
		GraphNode e = new GraphNode("e");
		GraphNode f = new GraphNode("f");
		GraphNode g = new GraphNode("g");
		GraphNode h = new GraphNode("h");		
		a.addNeighbor(e);
		a.addNeighbor(g);
		a.addNeighbor(b);
		b.addNeighbor(a);
		b.addNeighbor(c);
		b.addNeighbor(f);
		c.addNeighbor(b);
		c.addNeighbor(f);
		c.addNeighbor(d);
		d.addNeighbor(c);
		d.addNeighbor(f);
		d.addNeighbor(g);
		e.addNeighbor(g);
		e.addNeighbor(a);		
		f.addNeighbor(d);
		f.addNeighbor(c);
		f.addNeighbor(b);	
		g.addNeighbor(d);
		g.addNeighbor(e);
		g.addNeighbor(a);	
		h.addNeighbor(h);
		
/*		GraphNode a = new GraphNode("a");
		GraphNode b = new GraphNode("b");

		a.addNeighbor(a);
		b.addNeighbor(a);*/
		
		List<GraphNode> graph = Arrays.asList(a, b, c, d, e, f, g,h);
		//List<GraphNode> graph = Arrays.asList(a,b);
		List<String> colors = Arrays.asList("red","blue","green","yellow", "orange");
		colorGraph(graph,colors);

		for (GraphNode node : graph) {
			System.out.println(node.label+" - "+node.getColor());
		}
	}
}


