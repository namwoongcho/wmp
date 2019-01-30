package wmp.homework.node;

import java.util.LinkedList;

public class UpperCaseNode extends Node implements Alphabetic {

	public static final Character FIRST_CHARACTER = 'A';

	public UpperCaseNode(Character character) {
		super(character);
	}

	@Override
	public void index(Character character) {
		super.index0(FIRST_CHARACTER);
	}

	@Override
	public void add(LinkedList<Node> linkedList) {
		linkedList.addFirst(this);
	}
}
