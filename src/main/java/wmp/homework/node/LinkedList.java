package wmp.homework.node;

import java.util.Iterator;

public class LinkedList<T> {
	Node head;
	Node tail;

	class Node {
		T data;
		Node next;

		public Node(T data) {
			this.data = data;
		}
		
		public T get() {
			return data;
		}
	}

	public void addLast(T data) {
		Node node = new Node(data);
		if (tail == null) {
			tail = node;
			head = node;
		} else {
			tail.next = node;
			tail = node;
		}
	}

	public void addFirst(T data) {
		Node node = new Node(data);
		if (head == null) {
			head = node;
			tail = node;
		} else {
			node.next = head;
			head = node;
		}
	}

	public void linkedTo(LinkedList<T> linkedList) {
		this.tail.next = linkedList.head;
	}

	public Iterator<T> iterator() {
		return new NodeIterator(this.head);
	}

	class NodeIterator implements Iterator<T> {
		
		Node node;
		public NodeIterator(Node head) {
			this.node = head;
		}

		@Override
		public boolean hasNext() {
			return node != null;
		}

		@Override
		public T next() {
			Node temp = node;
			node = node.next;
			return temp.get();
		}
	}

	public static void main (String[] args) throws Exception {
		LinkedList<String> sample1 = new LinkedList<String>();
		LinkedList<String> sample2 = new LinkedList<String>();
		LinkedList<String> sample3 = new LinkedList<String>();

		sample1.addLast("b");
		sample1.addFirst("c");
		sample1.addFirst("a");
		sample1.addLast("a");
		sample1.addFirst("1");
		sample1.addLast("2");

		sample2.addLast("L3");
		sample2.addFirst("L2");
		sample2.addFirst("L1");

		sample3.addLast("H3");
		sample3.addFirst("H2");
		sample3.addFirst("H1");

		sample1.linkedTo(sample2);
		sample2.linkedTo(sample3);

		Iterator<String> iter = sample1.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next());
		}
	}
}
