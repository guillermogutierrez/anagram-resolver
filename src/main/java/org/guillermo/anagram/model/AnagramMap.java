package org.guillermo.anagram.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.guillermo.anagram.exception.NotValidLenghtException;

public class AnagramMap<T> {

    private Map<T, AnagramSet<T>> anagramMap;

    private Integer anagramLenght;

    public AnagramMap(Integer anagramLenght) {
        this.anagramLenght = anagramLenght;
        this.anagramMap = new HashMap<T, AnagramSet<T>>();
    }

    public void addAnagram(AnagramWord<T> anagram) throws NotValidLenghtException, NullPointerException {

        Objects.requireNonNull(anagram);

        if (anagram != null && !validAnagramLenght(anagram))
            throw new NotValidLenghtException(String.format("Word lenght for %s is %d but expected %d", anagram.getWord(),
                    anagram.getWord().length(), this.anagramLenght));

        anagramMap.merge(anagram.getKey(), new AnagramSet<T>(anagram), (set1, set2) -> set1.merge(set2));

    }

    public Integer size() {
        return this.anagramMap.size();
    }

    public String toString() {

        return this.anagramMap.values().stream().map(AnagramSet::toString).collect(Collectors.joining("\n"));
    }

    private Boolean validAnagramLenght(AnagramWord<T> anagram) {
        return anagram != null && this.anagramLenght.equals(anagram.getWord().length());
    }
}
