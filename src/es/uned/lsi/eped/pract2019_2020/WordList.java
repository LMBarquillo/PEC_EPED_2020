package es.uned.lsi.eped.pract2019_2020;

import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.ListIF;

public class WordList {
	private ListIF<WordListN> wordList;
	
	public WordList() {
		this.wordList = new List<WordListN>();
	}
	
	public void add(String word) {
		WordListN list = null;

		// Buscamos si ya existe una lista para ese tamaño de palabra
		if(wordList.size() > 0) {
			for(int pos=1; pos<=wordList.size(); pos++) {
				if(wordList.get(pos).getWordSize() == word.length()) {
					list = wordList.get(pos);
				}
			}
		}

		// Si no la hemos encontrado, la creamos y la insertamos en la posición adecuada
		if(list == null) {
			list = new WordListN(word.length());
			int pos = 1;
			while (wordList.size() > 0 && wordList.size() >= pos && wordList.get(pos).getWordSize() < word.length()) {
				pos++;
			}
			wordList.insert(pos, list);
		}

		// Finalmente, añadimos la letra a nuestra lista
		list.add(word);
	}
	
	public String toString() {
		StringBuilder salida = new StringBuilder();
		for ( int pos = 1 ; pos <= this.wordList.size() ; pos++ ) {
			salida.append(this.wordList.get(pos).toString());
		}
		return salida.toString();
	}
}
