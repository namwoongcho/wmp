package wmp.homework.node;

public abstract class Node {
	private Character character;
	private int index = 0;

	public Node(Character character) {
		this.character = character;
		index(character);
	}

	public Character getValue() {
		return character;
	}
	
	protected void index0(Character firstCharacter) {
		index = this.character - firstCharacter;
	}

	public int index() {
		return index;
	}

	public String toString() {
		return Character.toString(this.character);
	}

	public abstract void index(Character character);
	public abstract void add(LinkedList<Node> linkedList);
}
