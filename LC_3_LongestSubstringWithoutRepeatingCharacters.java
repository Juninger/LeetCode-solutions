import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 */
public class LC_3_LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        // no repeating characters
        if (s.length() <= 1) return s.length();

        // <char : index> current substring
        Map<Character, Integer> seen = new HashMap<>();

        // length of longest substring
        int longestSubStr = 0;

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (seen.containsKey(chars[i])) { // repeating character found
                if (seen.keySet().size() > longestSubStr) { // if current substring > longestSubstring
                    longestSubStr = seen.keySet().size();
                }
                i = seen.get(chars[i]) + 1; // moves iterator to start new substring
                seen.clear(); // new substring
            }
            seen.put(chars[i], i); // adds current character and its index to the current substring
        }
        // returns maximum of current substring vs longest substring
        return Math.max(longestSubStr, seen.size());
    }
}
