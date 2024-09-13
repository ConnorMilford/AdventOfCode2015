package aoc2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;

class Problem2 {

    static int paperSum = 0;
    static int ribbonSum = 0;

    public static void main(String[] args) {
    
        File file = new File("aoc2/problem2.txt");
        
        try (Stream<String> lines = Files.lines(file.toPath())) {
            lines.forEachOrdered(Problem2::calculatePaperSize);
        } catch(IOException ioException) {
            System.out.println("error: " + ioException);
        }
        
    }

    //2*l*w + 2*w*h + 2*h*l
    public static int calculateSurfaceArea(int l, int w, int h) {
        return (2*l*w + 2*w*h + 2*h*l);
    }

    public static int smallestSide(int l, int w, int h) {
        int a = l * w;
        int b = w * h;
        int c = h * l;
        
        //ternary to return smallest of three sides
        // if c < result of (a<b).. 
        return c < (a<b ? a:b) ? c:((a<b) ? a:b);  

    }

    public static void calculatePaperSize(String dimensions) {
        String regexString = "x";
        String[] stringsSplit = dimensions.split(regexString); 
        // map each string in the array to an int   
        int[] dimensionsArr = Stream.of(stringsSplit).mapToInt(Integer::parseInt).toArray();
        
        int l = dimensionsArr[0];
        int w = dimensionsArr[1];
        int h = dimensionsArr[2];

        System.out.println("Paper sum: " + (paperSum += smallestSide(l, w, h) + calculateSurfaceArea(l, w, h)));
        System.out.println(calculateRibbonSize(l, w, h));
    }

    /*  A present with dimensions 2x3x4 requires 2+2+3+3 = 10
    feet of ribbon to wrap the present, plus 2*3*4 = 24
    feet of ribbon for the bow, for a total of 34 feet. 
    
    The ribbon required to wrap a present is the shortest distance around its sides,
     or the smallest perimeter of any one face.                 */

    public static String calculateRibbonSize(int l, int w, int h) {
        //present wrap
        int a = 2*(l+w);
        int b = 2*(h+w);
        int c = 2*(l+h);
        
        // same as above
        int pw = c < (a<b ? a:b) ? c:((a<b) ? a:b); 

        int bow = l*w*h;

        return "Ribbon sum: " + (ribbonSum += (pw+bow));
    }  

}