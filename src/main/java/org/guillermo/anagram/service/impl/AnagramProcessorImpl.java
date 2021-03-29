package org.guillermo.anagram.service.impl;

import java.util.Arrays;

import org.guillermo.anagram.model.AnagramWord;
import org.guillermo.anagram.model.AnagramMap;
import org.guillermo.anagram.service.AnagramCalculatorService;
import org.guillermo.anagram.service.AnagramProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnagramProcessorImpl implements AnagramProcessor<Integer> {

	@Autowired
	private AnagramCalculatorService anagramCalculatorService;

	public void processWord(AnagramMap<Integer> anagramMap, String word) {

		anagramMap.addAnagram(new AnagramWord<Integer>(anagramCalculatorService.calculateValue(word), word));
	}
	
	public void processWords(AnagramMap<Integer> anagramMap, String[] words) {

		Arrays.stream(words).forEach((word)-> this.processWord(anagramMap, word));
	}

}
