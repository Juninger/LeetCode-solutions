import java.util.Arrays;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 */
public class LC_242_ValidAnagram {
    public boolean isAnagram(String s, String t) {
        //converts both strings to charArrays
        char[] w1 = s.toCharArray();
        char[] w2 = t.toCharArray();

        //sorts both charArrays
        Arrays.sort(w1);
        Arrays.sort(w2);

        //if arrays are equal return true, otherwise return false
        return Arrays.equals(w1, w2);
    }
}
