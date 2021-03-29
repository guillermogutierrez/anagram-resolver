package org.guillermo.anagram.model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.guillermo.anagram.exception.NotValidKeyException;

public class AnagramSet<T> {

    private T key;

    private Set<AnagramWord<T>> words;

    public AnagramSet(T key) {
        this.key = key;
        this.words = new HashSet<AnagramWord<T>>();
    }

    public AnagramSet(AnagramWord<T> anagram) {
        this(anagram.getKey());
        this.words.add(anagram);
    }

    public void addAnagram(AnagramWord<T> anagram) throws NotValidKeyException {

        if (anagram != null && !anagram.getKey().equals(key))
            throw new NotValidKeyException(
                    String.format("Expeted anagram key is %s, but found %s", this.key, anagram.getKey()));

        words.add(anagram);

    }

    public AnagramSet<T> merge(AnagramSet<T> setToAdd) throws NotValidKeyException {

        if (!this.key.equals(setToAdd.getKey())) {
            throw new NotValidKeyException(
                    String.format("Expeted anagram key is %s, but found %s", this.key, setToAdd.getKey()));
        }

        words.addAll(setToAdd.words);

        return this;
    }

    public Set<AnagramWord<T>> getAnagrams() {
        return this.words;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public void setAnagrams(Set<AnagramWord<T>> anagrams) {
        this.words = anagrams;
    }

    public String toString() {
        return this.words.stream().map(AnagramWord::toString).collect(Collectors.joining(","));
    }
}
