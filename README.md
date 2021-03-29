# Getting Started

The implementation of the service is based on the fundamental theorem of arithmetic. 

1. Map each of the 26 English letters to a unique prime number.
2. Multiply the characters of each word.
3. Since every integer is either a prime itself OR a unique product of primes, two words are anagrams if their products are the same.

The solution and the data structure have been designed and implemented to support different algorithms, just by implementing the actual anagram calculation.

### chosen language
The solution is implemented on Java 11 using SpringBoot

### how we can run your code
``` 
./anagram_analysis <path_file> 

./anagram_analysis Data/test.txt
```
anagram_analysis is a bah script that run the Java code and pass the first argument as the path to the file to execute

```
java -jar ./anagram-resolver.jar org.guillermo.anagram.AnagramResolverApplication --filepath=$1
```

Output gets printed in the console, and additional log gets stored in logs/spring-boot-logger.log

A build script has been included in case the code needs to get rebuilt
 
### Big O analysis
```
foreach item in the file	// O(n) n number of words in the file
	read item	// O(1)
	
	if item.size != length previous word
  		print words	// O(p)
  		initialise a new map 
  		p = 0
  	endif
  
  calculatate the value for that anagram	// O(m) where m is the length of that word
  
  if already have an entry for anagram value	// O(1)
    append the new word to the list of anagrams 	// O(p) where p is the number of words for that specific key
  else 
    add a new entry to the map with the new key 	// O(1)
  
  increment p

end 	
```

O(n) * ( O(p) + O(m) + O(1) + O(p)) = O(n) * O(2p+m+1) = O(n) * O(1) = O(n)
n >>> p > m
If we consider m and p equals to 1 when compared with the value of n, the algorithm is O(n)  
	
### reasons behind data structures chosen 

AnagramWord
Represents a specific word, and contains the word and the anagram key

AnagramSet
Represents a set of words that share the same anagram key.

AnagramMap
Represents a collection of sets of anagrams with the same length in common.

These data structures allow us to manipulate words with the same length and group them based on the chosen algorithm for the anagram evaluation. Having a key value added to each word, we can compare words and place words in the right anagram set without having to recalculate the anagram value for the words already processed. 
 

### what you would do given more time
Added comments to describe the data structure and how to use the services implemented
I would added more log data into the process, so we could understand better how the application is performing in production.
Implemented different algorithms and collections to find the most efficient way to process the data.
Implemented additional renders to switch from the console output to a different output and format such a file in a JSON format