import java.util.HashMap;

/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * In other words, return true if one of s1's permutations is the substring of s2.
 *

 * Example 1:
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 *
 * Example 2:
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 */
public class LC_567_PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false; // impossible edge case

        HashMap<Character, Integer> s1FreqMap = new HashMap<>(); // character frequencies for string s1
        HashMap<Character, Integer> s2FreqMap =  new HashMap<>(); // characters in current sliding window of s2

        // build frequency map for s1
        for (char c : s1.toCharArray()) {
            s1FreqMap.put(c, s1FreqMap.getOrDefault(c, 0) + 1); // +1 frequency of current char
        }

        // iteratively move sliding window over s2
        for (int i = 0; i < s2.length(); i++) {
            char c1 = s2.charAt(i);
            s2FreqMap.put(c1, s2FreqMap.getOrDefault(c1, 0) + 1); // +1 frequency of current char

            if (i >= s1.length()) { // keep sliding window same size as length of s1
                char c2 = s2.charAt(i - s1.length()); // character to be removed from window
                s2FreqMap.put(c2, s2FreqMap.get(c2) - 1); // -1 frequency of current char

                if (s2FreqMap.get(c2) == 0) s2FreqMap.remove(c2); // if no more occurrences, delete the entry
            }

            if (s1FreqMap.equals(s2FreqMap)) return true; // compare frequency maps to check for permutations
        }

        return false; // no permutations
    }
}
