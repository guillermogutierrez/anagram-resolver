package org.guillermo.anagram.service.impl;

import org.guillermo.anagram.service.AnagramCalculatorService;
import org.springframework.stereotype.Service;

@Service
public class AnagramCalculatorServiceImpl implements AnagramCalculatorService {

	@Override
	public Integer calculateValue(String word) {
		return word.toUpperCase().chars().reduce(1, (a, b) -> a * LETTER_VALUE[b - ASCII_INDEX]);
	}

	private static int[] LETTER_VALUE = new int[] { 2, 3, 5, 7, 9, 11, 13, 17, 19, 23, 25, 29, 31, 37, 41, 43, 47, 49,
			53, 59, 61, 67, 71, 73, 79, 83, 89, 97 };

	private static int ASCII_INDEX = 65;
}
