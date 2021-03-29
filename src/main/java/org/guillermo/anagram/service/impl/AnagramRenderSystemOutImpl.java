package org.guillermo.anagram.service.impl;

import org.guillermo.anagram.model.AnagramMap;
import org.guillermo.anagram.service.AnagramRenderer;
import org.springframework.stereotype.Service;

@Service
public class AnagramRenderSystemOutImpl<T> implements AnagramRenderer<T> {

    @Override
    public void printAnagrams(AnagramMap<T> anagramMap) {
        System.out.println(anagramMap); 
    }

}
