package org.guillermo.anagram;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.guillermo.anagram.model.ProcessResult;
import org.guillermo.anagram.service.AnagramFileProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AnagramResolverApplication {

    @Value("${filepath:src/main/resources/demo.txt}")
    private String filepath;

    @Autowired
    private AnagramFileProcessor anagramFileProcessor;

    private Logger logger = LogManager.getLogger(AnagramResolverApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(AnagramResolverApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            logger.info("Processing the file {}", filepath);

            ProcessResult processResult = anagramFileProcessor.findAnagramsInFile(filepath, "UTF-8");

            logger.info("Processed {} words on {} milliseconds", processResult.getWords(), processResult.getTime());

        };
    }
}
