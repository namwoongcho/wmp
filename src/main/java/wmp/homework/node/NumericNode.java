package wmp.homework.node;

import java.util.LinkedList;

public class NumericNode extends Node {

	public static final Character FIRST_CHARACTER = '0';

	public NumericNode(Character character) {
		super(character);
	}

	@Override
	public void index(Character character) {
		super.index0(FIRST_CHARACTER);
	}

	@Override
	public void add(LinkedList<Node> linkedList) {
		linkedList.addLast(this);
	}
}
