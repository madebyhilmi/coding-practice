package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayPractice {

    //is unique: implement an algorithm to determine if a string has all unique characters. what if you cannot use additional data structures
    public static boolean isUnique(String input) {
        Map<Character, Boolean> cMap = new HashMap<>();

        for (char c : input.toCharArray()) {
            if (cMap.containsKey(c)) {
                return false;
            }
            cMap.put(c, Boolean.TRUE);
        }
        return true;
    }

    public static char[] urlify(char[] url, int trueLength) {
        int lastIndex = url.length - 1;
        boolean doneMovingTrailingSpaces = false;

        if (url.length == trueLength) {
            return url;
        }

        for (int i = url.length - 1; i >= 0; i--) {
            if (i == lastIndex && doneMovingTrailingSpaces) {
                break;
            }
            if (url[i] != ' ') {
                doneMovingTrailingSpaces = true;
                url[lastIndex] = url[i];
                url[i] = ' ';
                lastIndex--;
            } else if (url[i] == ' ' && doneMovingTrailingSpaces) {
                url[lastIndex] = '0';
                url[lastIndex - 1] = '2';
                url[lastIndex - 2] = '%';
                lastIndex = lastIndex - 3;
            }


        }
        return url;
    }

    //Insert, Remove, Replace, Same
    public static boolean oneAway(char[] one, char[] two)
    {
        int oLen = one.length;
        int tLen = two.length;
        int bLen = Math.max(oLen, tLen);

        if (Math.abs(one.length - two.length) > 1)
        {
            return false;
        }

        boolean[] sameCharacters = new boolean[bLen];
        for (int i = 0; i < Math.min(oLen, tLen); i++) {
            if (one[i] == two[i])
            {
                sameCharacters[i] = true;
            }
        }
        oLen--;
        tLen--;
        while (oLen > 0 || tLen > 0)
        {
            if (one[oLen] == two[tLen])
            {
                sameCharacters[Math.max(oLen, tLen)] = true;
            }
            oLen--;
            tLen--;
        }
        int counter = 0;
        for (boolean sameCharacter: sameCharacters)
        {
            if (!sameCharacter)
            {
                counter++;
            }
        }
        return counter <= 1;
    }

    //string rotation - isSubstring (one call) check if two strings are rotation of one another
    public boolean isRotation(String s1, String s2)
    {

        return false;
    }

}
