package aoc2;
import java.security.*;
import java.util.HexFormat;


class Problem4 {

    public static void main(String[] args) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");

            int i =0;
            
            boolean correctMD5 = false; 
            while (!correctMD5) {
                String hashString = "yzbqklnj" + i;
                String hash = HexFormat.of().formatHex(md5.digest(hashString.getBytes()));
                i++;
                if (correctHash(hash, 6)){
                    System.out.println("Found hash: " + hashString);
                    correctMD5 = true;
                }
            }
            
        } catch(NoSuchAlgorithmException NoSuchAlgorithmException) {

        }
        
    }

    static boolean correctHash(String hash, int zeroes)  {
        String matchString = "0".repeat(zeroes);
        return hash.substring(0,zeroes).equals(matchString);   
    }
        
}