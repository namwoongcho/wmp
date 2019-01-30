package wmp.homework.node;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedNodeList {
	private ArrayList<LinkedList<Node>> nodeArray;
	
	@SuppressWarnings("unused")
	private LinkedNodeList() {
		// it does not want a call.
	}

	public LinkedNodeList(int capacity) {
		nodeArray = new ArrayList<LinkedList<Node>>(capacity);
		for (int i = 0; i < capacity; i++) {
			nodeArray.add(i, null);
		}
	}

	public void addNode(Node newNode) {
		int index = newNode.index();
		LinkedList<Node> linkedList = nodeArray.get(index);
		if (linkedList == null) {
			linkedList = new LinkedList<Node>();
			nodeArray.set(index, linkedList);
		}
		newNode.add(linkedList);
	}

	public Iterator<Node> iterator() {
		// it is bad smell but we've have no time.
		LinkedList<Node> toMerge = new LinkedList<Node>();
		for (LinkedList<Node> list : nodeArray) {
			if (list != null)
				toMerge.addAll(list);
		}

		return toMerge.iterator();
	}
}
