package org.guillermo.anagram.model;

public class ProcessResult {

    private Integer words;
    
    private Long time;

    public ProcessResult(Integer words, Long time) {
        super();
        this.words = words;
        this.time = time;
    }

    public Integer getWords() {
        return words;
    }

    public void setWords(Integer words) {
        this.words = words;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
