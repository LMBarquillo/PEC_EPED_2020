package es.uned.lsi.eped.pract2019_2020;

import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.ListIF;

public class WordListN {
	/* Atributos de la clase con la estructura adecuada */
	private final ListIF<String> wordList;
	private final int wordSize;
	/* Atributos de la clase con la estructura adecuada */

	public WordListN(int size) {
		this.wordSize = size;
		this.wordList = new List<String>() {};
	}
	
	public void add(String word) {
		wordList.insert(wordList.size()+1, word);
	}
	
	public int getWordSize() {
		return this.wordSize;
	}
	
	public String toString() {
		StringBuilder salida = new StringBuilder();
		int numPalabras = this.wordList.size();
		salida.append("-Palabras de ");
		salida.append(this.getWordSize());
		salida.append(" letra");
		if ( this.getWordSize() > 1 ) { salida.append('s'); }
		salida.append(": ");
		for (int pos = 1 ; pos <= numPalabras ; pos++) {
			/* Estas líneas dependen de la estructura escogida */
			String word = wordList.get(pos); /* Obtener la siguiente palabra */
			/* Avanzar a la siguiente sin destruir la estructura */
			// No es necesario añadir código aquí. El propio bucle se encarga de avanzar la posición
			/* Estas líneas dependen de la estructura escogida */
			salida.append(word);
			if ( pos < numPalabras ) {
				salida.append(", ");
			}
		}
		salida.append('\n');
		return salida.toString();
	}
}
