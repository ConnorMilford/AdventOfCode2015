package aoc2;
import java.security.*;
import java.util.Base64;
import java.util.HexFormat;



/*
    MD5 hashes in hexadecimal, start with at least five zeroes
    https://stackoverflow.com/questions/415953/how-can-i-generate-an-md5-hash-in-java



    find the lowest number that combines with the key 'yzbqklnj', produces an md5 hash with 5 leading 0s. 

    https://www.geeksforgeeks.org/substring-in-java/)
    // while md5 hash substring 0-6 != "00000" increment number by one.

    Look at digestUtils as well.
*/ 


class Problem4 {

    public static void main(String[] args) {
        String matchString = "0".repeat(6);
        System.out.println(matchString);
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");

            int i =0;
            
            boolean correctMD5 = true; 
            while (correctMD5) {
                String hashString = "yzbqklnj" + i;
                String hash = HexFormat.of().formatHex(md5.digest(hashString.getBytes()));
                i++;
                if (correctHash(hash, 6)){
                    System.out.println("Found hash: " + hashString);
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