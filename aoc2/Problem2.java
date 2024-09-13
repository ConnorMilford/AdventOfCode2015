package aoc2;

class Problem2 {

    public static void main(String[] args) {
        System.out.println(smallestSide(2, 3, 4));
    }

    //2*l*w + 2*w*h + 2*h*l
    public static int calculateSurfaceArea() {
        return 0;
    }

    public static int smallestSide(int l, int h, int w) {
        int a = l * w;
        int b = w * h;
        int c = h * l;
        
        //ternary to return smallest of three sides
        // if c < result of (a<b).. 
        return c < (a<b ? a:b) ? c:((a<b) ? a:b);  

    }

}