package com.gabrielgrimberg.algorithm.cycledetection;/*
	Name: Gabriel Grimberg.
	Type: Cycle Detection.
	Code: Main.
*/

import java.util.ArrayList;
import java.util.List;

public class CycleDetectionRun {

	public static void cycleDetection() {
		
		// Creating new vertices.
		Vertex vertex1 = new Vertex("1");
		Vertex vertex2 = new Vertex("2");
		Vertex vertex3 = new Vertex("3");
		Vertex vertex4 = new Vertex("4");
		Vertex vertex5 = new Vertex("5");
		Vertex vertex6 = new Vertex("6");
		
		// Adding the neighbours of a vertex.
		vertex1.addNeighbour(vertex2);
		vertex2.addNeighbour(vertex3);
		vertex3.addNeighbour(vertex1);
		vertex4.addNeighbour(vertex1);
		vertex4.addNeighbour(vertex5);
		vertex5.addNeighbour(vertex6);
		vertex6.addNeighbour(vertex4);
		
		List<Vertex> vertexList = new ArrayList<>();
		vertexList.add(vertex1);
		vertexList.add(vertex2);
		vertexList.add(vertex3);
		vertexList.add(vertex4);
		vertexList.add(vertex5);
		vertexList.add(vertex6);
		
		CycleDetectionAlgorithm cycleDetectionAlgorithm = new CycleDetectionAlgorithm();
		
		cycleDetectionAlgorithm.detectCycle(vertexList);
	}
}
