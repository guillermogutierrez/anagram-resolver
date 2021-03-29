package org.guillermo.anagram.service;

import org.guillermo.anagram.model.AnagramMap;

public interface AnagramRenderer<T> {

    void printAnagrams(AnagramMap<T> anagramMap);
}
