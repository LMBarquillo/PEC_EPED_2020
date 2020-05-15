package es.uned.lsi.eped.pract2019_2020;

import es.uned.lsi.eped.DataStructures.GTree;
import es.uned.lsi.eped.DataStructures.GTreeIF;
import es.uned.lsi.eped.DataStructures.ListIF;

public class Dictionary {

	private GTree<Node> dict; /* El diccionario es un árbol general de nodos */
	
	/* Constructor de la clase */
	public Dictionary() {
		this.dict = new GTree<>();
	}
	
	/* Método de inserción de una nueva palabra en el diccionario */
	public void insert(String word) {
		/* Insertamos la palabra a partir del nodo raíz del árbol */
		insertInTree(word,this.dict);
	}
	
	/* Método privado llamado por el anterior */
	private void insertInTree(String word, GTreeIF<Node> node) {
		if(word.length() == 0) {
			// Si word es palabra vacía, es que hemos llegado al final
			GTree<Node> endOfWord = new GTree<>();
			endOfWord.setRoot(new WordNode());
			node.addChild(1, endOfWord);
		} else {
			if(node.getRoot() == null && !node.isLeaf()) node.setRoot(new RootNode());
			ListIF<GTreeIF<Node>> children = node.getChildren();
			GTreeIF<Node> child = null;
			// Buscamos si ya tiene un hijo con la letra que le toca
			for(int i=1; i<=children.size(); i++) {
				Node n = children.get(i).getRoot();
				if(n.getNodeType().equals(Node.NodeType.LETTERNODE) && ((LetterNode) n).getLetter() == word.charAt(0)) {
					child = children.get(i);	// Ya existe esa letra
				}
			}
			// Si no encontramos un hijo con esa letra, lo creamos
			if(child == null) {
				child = new GTree<>();
				child.setRoot(new LetterNode(word.charAt(0)));
				// Buscamos la posición adecuada para insertarlo manteniendo el orden alfabético
				int pos = 1;
				if(children.size() == 0) {
					children.insert(1, child);
				} else {
					while(((LetterNode) children.get(pos).getRoot()).getLetter() < word.charAt(0)) pos++;
					children.insert(pos, child);
				}
			}
			insertInTree(word.substring(1), child);
		}
	}

	/* Método público de búsqueda de todas las palabras a partir de una secuencia */
	public WordList search(String sequence) {
		WordList salida = new WordList();           /* Variable donde construiremos la salida */
		searchInTree(sequence,"",this.dict,salida); /* Construimos la salida recursivamente */
		return salida;
	}
	
	/* Método privado llamado por el anterior */
	private void searchInTree(String sequence, String word,
							  GTreeIF<Node> node, WordList salida) {...}
	
	/* Método público de búsqueda de todas las palabras de tamaño size a partir de una secuencia */
	public WordListN search(String sequence, int size) {
		WordListN salida = new WordListN(size);           /* Variable donde construiremos la salida */
		searchInTreeN(sequence,"",this.dict,salida,size); /* Construimos la salida recursivamente */
		return salida;
	}
	
	/* Método privado llamado por el anterior */
	private void searchInTreeN(String sequence, String word,
							   GTreeIF<Node> node, WordListN salida,
							   int size) {...}
	
}
