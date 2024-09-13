package aoc2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;


public class Problem3 {
    
    // use a set, as it avoids duplicates 
    // size of set equal to number of seperate houses 
    static Set<String> coordSet = new HashSet<>();


    // int to represent north south movement 
    static int santaNs;
    static int roboNs ;
    //int to represent east west movement
    static int santaEw ;
    static int roboEw ;

    public static void main(String[] args) {
        try {
            char[] lines = Files.readAllLines(Paths.get("aoc2/problem3.txt")).toString().toCharArray();
            
            //iterate over chars, calculate their nsew pos, and their index, if they dont exist add to map
            
            // add first coord to set 
            coordSet.add("0x0");    
            
            for (int i=1; i<lines.length-1; i++) {
                Character c = lines[i]; 
                
                // santas turn
                if (i%2==0){
                    calculateDirection(c, true);
                } else {
                    calculateDirection(c, false);
                }
            }
            System.out.println(coordSet.size());

        } catch (IOException ioException){
            System.out.println(ioException.getMessage());
        }
    }

    // true is santa, false is robo
    public static void calculateDirection (Character c, boolean turn){
        if (turn){
            switch (c) {
                case '^':
                    santaNs += 1; 
                    break;
                case 'v':
                    santaNs-=1;
                    break;
                case '>':
                    santaEw += 1;
                    break;
                case '<':
                    santaEw -=1;
                    break;
                default:
                    break;
            }
            coordSet.add(santaNs + "x" + santaEw);
        } else {
            switch (c) {
                case '^':
                    roboNs += 1; 
                    break;
                case 'v':
                    roboNs-=1;
                    break;
                case '>':
                    roboEw += 1;
                    break;
                case '<':
                    roboEw -=1;
                    break;
                default:
                    break;
            }
            coordSet.add(roboNs + "x" + roboEw);
        }
        
    }
}
