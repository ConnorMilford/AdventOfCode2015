package Problem5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class Problem5 {
    
    public static void main(String[] args) {
        File file = new File("Problem5/Problem5.txt");

        Set<String> niceWords = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            Character lastChar = ' ';
            //contains three vowels, a double letter and not a naughty string 
            while ((line = br.readLine())!=null) {

                int numVowels = 0;
                boolean doubleLetter = false;
                boolean naughtySubstring = false;

                for (int i=0; i<line.length(); i++) {
                    Character curChar = line.charAt(i);
                    if (StringChecker.isVowel(curChar)){
                        numVowels++;
                    }

                    if (doubleLetter == false){
                        doubleLetter = StringChecker.sameLetter(lastChar, curChar);
                    }

                    if (naughtySubstring == false){
                        naughtySubstring = StringChecker.naughtyString(lastChar, curChar);
                    }

                    if (numVowels >= 3 && doubleLetter && naughtySubstring == false){
                        niceWords.add(line);
                    }
                    lastChar = curChar;
                }
            }
            System.out.println("NICE WORDS: " + niceWords.size());
        } catch (IOException ioe){
            System.out.println(ioe.getMessage());
        } 
        
    }
}
