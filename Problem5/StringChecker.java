package Problem5;

class StringChecker {
    

    static boolean isVowel(Character c){
        return c == 'a' ||
        c == 'e' || c == 'i' 
        || c == 'u' || c =='o';
    }

    static boolean sameLetter(Character currentChar, Character nextChar) {
        if (currentChar.equals(nextChar)){
            return true;
        }
        return false;
    }

    static boolean naughtyString(Character currenChar, Character nextCharacter) {
        String[] naughtyStrings = {"ab", "cd", "pq", "xy"};
        String charString = String.valueOf(currenChar) + String.valueOf(nextCharacter);

        for (String naughtyString : naughtyStrings) {
            if (naughtyString.equals(charString)){
                return true;
            }
        }
        return false;
    }
    
}