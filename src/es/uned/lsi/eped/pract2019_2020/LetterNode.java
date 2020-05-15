package es.uned.lsi.eped.pract2019_2020;

public class LetterNode extends Node {
	private final char letter;

	public LetterNode(char letter) {
		this.letter = letter;
	}

	public char getLetter() {
		return letter;
	}

	@Override public NodeType getNodeType() {
		return NodeType.LETTERNODE;
	}
}
