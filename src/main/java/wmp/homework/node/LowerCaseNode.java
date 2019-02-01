package wmp.homework.node;

public class LowerCaseNode extends Node implements Alphabetic {

	public static final Character FIRST_CHARACTER = 'a';
	
	public LowerCaseNode(Character character) {
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
