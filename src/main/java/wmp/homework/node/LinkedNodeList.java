package wmp.homework.node;

import java.util.ArrayList;
import java.util.Iterator;

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
		// zero copy.
		LinkedList<Node> workingList = null;
		LinkedList<Node> headList = null;
		for (LinkedList<Node> list : nodeArray) {
			if (list != null) {
				if (workingList == null) {
					workingList = list;
					headList = list;
				} else {
					workingList.linkedTo(list);
					workingList = list;
				}
			}
		}
		return headList.iterator();
	}
}
