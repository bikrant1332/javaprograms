package in.bjena.javacollection.LinkedList.impl;

import lombok.Data;

public class LinkedList {
	public Node head;
	public int size;

	//public void add()
	
	@Data
	private static class Node{
		private Node nextNode;
		private Object data;
	}
}
