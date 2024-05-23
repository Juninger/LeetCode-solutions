import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * You are given a string s and an integer k.
 * You can choose any character of the string and change it to any other uppercase English character.
 * You can perform this operation at most k times.
 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
 */
public class LC_424_LongestRepeatingCharacterReplacement {

    /**
     * Sliding window solution:
     * VALID: length of window - # of most frequent char <= k
     * res == length of longest valid window
     * WHEN k exceeded --> shift left pointer +1 AND decrement char from old pointer pos
     */
    public int characterReplacement(String s, int k) {

        int res = 0; // longest valid window
        int lp = 0; // left pointer

        // frequency map --> < char : occurrences >
        Map<Character, Integer> map = new HashMap<>();

        // 'rp' == right pointer
        for (int rp = 0; rp < s.length(); rp++) {

            char c = s.charAt(rp); // current character on right pointer

            // add +1 of current char to map
            map.put(c, map.getOrDefault(c, 0) + 1);

            // frequency for the most common character in current window
            int highestFreq = Collections.max(map.values());

            // length of window
            int len = (rp - lp + 1);

            // validates window, shrinks window if more than 'k' replacements needed
            if ((len - highestFreq) > k) {
                map.put(s.charAt(lp), map.get(s.charAt(lp)) - 1); // decrements character frequency on left pointer
                lp++; // shrinks window by moving left pointer
                len--; // updates window length
            }
            res = Math.max(res, len); // updates the result if current windows is larger than current max
        }
        return res;
    }
}
