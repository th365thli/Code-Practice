package Algorithms;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		
		List<Vertex> nodes = new ArrayList<Vertex>();
		List<Edge> edges = new ArrayList<Edge>();
		
		Vertex A = new Vertex("A", "A");
		Vertex B = new Vertex("B", "B");
		Vertex C = new Vertex("C", "C");
		Vertex D = new Vertex("D", "D");
		Vertex E = new Vertex("E", "E");
		Vertex F = new Vertex("F", "F");
		
		nodes.add(A);
		nodes.add(B);
		nodes.add(C);
		nodes.add(D);
		nodes.add(E);
		nodes.add(F);
		
		Edge e1 = new Edge("1", A, B, 10);
		Edge e2 = new Edge("2", A, C, 15);
		Edge e3 = new Edge("3", B, D, 12);
		Edge e4 = new Edge("4", B, F, 15);
		Edge e5 = new Edge("5", C, E, 10);
		Edge e6 = new Edge("6", D, E, 2);
		Edge e7 = new Edge("7", D, F, 1);
		Edge e8 = new Edge("7", F, E, 5);
		
		edges.add(e1); edges.add(e2); edges.add(e3); edges.add(e4); edges.add(e5); edges.add(e6); edges.add(e7);edges.add(e8);
		
		Graph test = new Graph(nodes, edges);
		
		Djikstra run = new Djikstra(test, A);
		
		
	}
	
	
	
	
}
