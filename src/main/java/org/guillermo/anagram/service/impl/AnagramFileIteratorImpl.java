package org.guillermo.anagram.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.guillermo.anagram.model.AnagramMap;
import org.guillermo.anagram.model.ProcessResult;
import org.guillermo.anagram.service.AnagramFileProcessor;
import org.guillermo.anagram.service.AnagramProcessor;
import org.guillermo.anagram.service.AnagramRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnagramFileIteratorImpl implements AnagramFileProcessor {

    @Autowired
    AnagramProcessor<Integer> anagramProcessor;
    
    @Autowired
    AnagramRenderer<Integer> anagramRenderer;

    private Logger logger = LogManager.getLogger(AnagramFileIteratorImpl.class);

    @Override
    public ProcessResult findAnagramsInFile(String filePath, String enconding) {
        Instant startTime = Instant.now();

        AnagramMap<Integer> anagrams = null;

        Integer wordSize = 0;

        Integer words = 0;

        File f = new File(filePath);

        try {
            LineIterator it = FileUtils.lineIterator(f, enconding);

            while (it.hasNext()) {
                String line = it.nextLine();

                if (line.length() != wordSize) {

                    if (anagrams != null)
                        anagramRenderer.printAnagrams(anagrams);

                    anagrams = new AnagramMap<Integer>(line.length());
                    wordSize = line.length();
                }

                anagramProcessor.processWord(anagrams, line);

                words++;
            }

            anagramRenderer.printAnagrams(anagrams);

        } catch (FileNotFoundException fileNotFoundException) {

            logger.error("The file {} does not exists", filePath);
        }
        catch (IOException ioException) {
            logger.error(ioException.getMessage());
        }
        
        Instant endTime = Instant.now();

        return new ProcessResult(words, Duration.between(startTime, endTime).toMillis());
    }

}
