package org.guillermo.anagram.service;

import org.guillermo.anagram.model.ProcessResult;

public interface AnagramFileProcessor {

    ProcessResult findAnagramsInFile(String filePath, String encoding);
}
