package aoc2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Map;
import java.util.Arrays;
import java.util.Set;






public class Problem3 {
    
    // use a set, as it avoids duplicates 
    // size of set equal to number of seperate houses 
    static Set<String> coordSet = new HashSet<>();


    // int to represent north south movement 
    static int ns;
    //int to represent east west movement
    static int ew;


    //one house to the north (^), south (v), east (>), or west (<).

    public static void main(String[] args) {
        try {
            char[] lines = Files.readAllLines(Paths.get("aoc2/problem3.txt")).toString().toCharArray();
            
            //iterate over chars, calculate their nsew pos, and their index, if they dont exist add to map
            
            // add first coord to set 
            coordSet.add("0x0"); 

            for (int i=1; i<lines.length-1; i++) {
                int c = lines[i]; 
                
                switch (c) {
                    case '^':
                        ns += 1; 
                        break;
                    case 'v':
                        ns-=1;
                        break;
                    case '>':
                        ew += 1;
                        break;
                    case '<':
                        ew -=1;
                        break;
                    default:
                        break;
                }
                
                String coords = Integer.toString(ns) + Integer.toString(ew);
                // convert ns, ew to strings such as 1x1
                coordSet.add(coords);
            }
            System.out.println(coordSet.size());

        } catch (IOException ioException){
            System.out.println(ioException.getMessage());
        }
    }

}
