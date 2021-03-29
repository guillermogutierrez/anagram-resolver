package org.guillermo.anagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;

import org.guillermo.anagram.exception.NotValidLenghtException;
import org.guillermo.anagram.model.AnagramMap;
import org.guillermo.anagram.service.AnagramProcessor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AnagramResolverProcessorTests {

	@Autowired
	private AnagramProcessor<Integer> anagramProcessor;
	
	@Test
	public void testThreeAnagrams() {

		String[] words = new String[] {"abc", "abb","cba"};
		
		AnagramMap<Integer> anagramMap = new AnagramMap<Integer>(3);

		processWordsArray(words, anagramMap);
				
		assertEquals(2, anagramMap.size());

		System.out.println("testThreeAnagrams");
		
		System.out.println(anagramMap.toString());
			
	}
	
	@Test
	public void testThreeAnagramsWords() {

		String[] words = new String[] {"abc", "abb","cba"};
		
		AnagramMap<Integer> anagramMap = new AnagramMap<Integer>(3);

		processWords(words, anagramMap);
				
		assertEquals(2, anagramMap.size());
		
		System.out.println("testThreeAnagramsWords");
		
		System.out.println(anagramMap.toString());
			
	}
	
	@Test
	public void testDifferentSizeAnagrams() {

		String[] words = new String[] {"abc", "abb","cbad"};
		
		AnagramMap<Integer> anagramMap = new AnagramMap<Integer>(3);

		assertThrows( NotValidLenghtException.class, ()->{processWordsArray(words, anagramMap);});
			
	}
	
	@Test
	public void testFourAnagrams() {
		
		String[] words = new String[] {"abcd", "abbd","cbac","zzzz"};
		
		AnagramMap<Integer> anagramMap = new AnagramMap<Integer>(4);
		
		processWordsArray(words, anagramMap);
		
		assertEquals(4, anagramMap.size());
		
		System.out.println(anagramMap.toString());
			
	}
	
	@Test
	public void addNullAnagram() {
		AnagramMap<Integer> anagramMap = new AnagramMap<Integer>(3);
				assertThrows(NullPointerException.class,()->{anagramMap.addAnagram(null);});
	}
	
	private void processWords(String[] words, AnagramMap<Integer> anagramMap) {
		anagramProcessor.processWords(anagramMap, words);
	}
	
	private void processWordsArray(String[] words, AnagramMap<Integer> anagramMap) {
		Arrays.stream(words).forEach((a)-> anagramProcessor.processWord(anagramMap, a));
	}
}
