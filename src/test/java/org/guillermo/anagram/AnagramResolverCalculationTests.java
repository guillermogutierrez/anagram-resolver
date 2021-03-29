package org.guillermo.anagram;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.guillermo.anagram.service.AnagramCalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AnagramResolverCalculationTests {

    @Autowired
    private AnagramCalculatorService anagramService;

    @Test
    void testFirstCharAnagramValue() {
        testCalculation(2, "a");
    }

    @Test
    void testLastCharAnagramValue() {
        testCalculation(83, "z");
    }

    @Test
    void testValidAnagramValue() {
        testCalculation(30, "abc");
    }

    @Test
    void testlargeAnagram() {
        testCalculation(2026286224, "ethylenediaminetetraacetates");

    }

    private void testCalculation(Integer expexted, String word) {
        assertEquals(expexted, anagramService.calculateValue(word));
    }

}
