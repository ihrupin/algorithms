package com.hrupin.algorithms.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Igor Khrupin www.hrupin.com 20.11.2016
 */

public class GraphCircleSample {

	public static void run() {
		System.out.println(GraphCircleSample.class.getSimpleName());
		
		Node nodeA = new Node();
		nodeA.setName("A");
		Node nodeB = new Node();
		nodeB.setName("B");
		Node nodeC = new Node();
		nodeC.setName("C");
		Node nodeD = new Node();
		nodeD.setName("D");
		
		//set relations
		nodeA.addNeighbour(nodeB);
		nodeA.addNeighbour(nodeC);
		
		nodeB.addNeighbour(nodeA);
		nodeB.addNeighbour(nodeC);
		
		nodeC.addNeighbour(nodeA);
		nodeC.addNeighbour(nodeB);
		nodeC.addNeighbour(nodeD);
		
		nodeD.addNeighbour(nodeC);
		
		List<Node> graph = new ArrayList<Node>();
		graph.add(nodeA);
		graph.add(nodeB);
		graph.add(nodeC);
		graph.add(nodeD);	
		
		System.out.println("Graph=" + graph);
		
		//The rule: We looking for graph without circles. So, we looking for tree.
		// A tree is an undirected graph G that satisfies the following equivalent conditions:
		//	- G is connected and has no cycles.
		//OR
		// - G is connected and has n − 1 edges. n- count of nodes
		
		// 1. We need check graph for connectivity. But, we assume that graph is connected. So, will skip it.
		// 2. We need check if graph has n − 1 edges.
		
		System.out.println("Is Graph Has Cirles = " + isGraphHasCircles(graph));
	}
	
	public static boolean isGraphHasCircles(List<Node> graph){
		int countOfEdgesMultiple2 = 0;
		for(Node n : graph){
			countOfEdgesMultiple2 += n.getNeighbours().size();
		}
		int countOfEdges = countOfEdgesMultiple2 / 2;
		System.out.println("Count of edges = " + countOfEdges);
		System.out.println("Count of nodes = " + graph.size());
		return countOfEdges != graph.size() - 1;
	}
}
