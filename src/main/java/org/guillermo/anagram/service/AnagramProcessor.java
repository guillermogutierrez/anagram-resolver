package org.guillermo.anagram.service;

import org.guillermo.anagram.model.AnagramMap;

public interface AnagramProcessor<T> {

	void processWord(AnagramMap<T> anagramMap, String word);
	
	void processWords(AnagramMap<Integer> anagramMap, String[] words);

}
